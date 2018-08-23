package com.joywe.weatherlib.biz;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.joywe.weatherlib.biz.convert.WeatherConvertManger;
import com.joywe.weatherlib.callback.ResponseCallback;
import com.joywe.weatherlib.http.IpToCityManger;
import com.joywe.weatherlib.model.city.City;
import com.joywe.weatherlib.model.weather.Weather;
import com.joywe.weatherlib.model.weather.meizu.MeiZuWeather;
import com.joywe.weatherlib.model.weather.nineton.NineTonWeather;
import com.joywe.weatherlib.model.weather.sojson.SoJsonWeather;
import com.joywe.weatherlib.model.weather.wthrcdn.WthrcdnWeather;
import com.joywe.weatherlib.utils.CityUtil;
import com.smart.common.data.DataFormat;
import com.smart.common.http.HttpManger;
import com.smart.common.util.DebugUtil;
import com.smart.common.util.ThreadUtil;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @author : Kingsley
 */
public class WeatherManger {
    private static Weather sWeather;
    private static City sCity;
    private static boolean isFirst = true;
    private static boolean isMeiZu, isNineTon, isSoJson, isWthrcdn, isRevamp;
    private static final String MEI_ZU_HOST = "http://aider.meizu.com/app/weather/listWeather?cityIds=";
    private static final String NINE_TON_HOST = "http://tj.nineton.cn/Heart/index/all?city=";
    private static final String SO_JSON_HOST = "https://www.sojson.com/open/api/weather/json.shtml?city=";
    private static final String WTHRCDN_HOST = "http://wthrcdn.etouch.cn/weather_mini?city=";
    private Handler mMainHandler;

    private static class Holder {
        static final WeatherManger INSTANCE = new WeatherManger();
    }

    public static WeatherManger getInstance() {
        return Holder.INSTANCE;
    }

    private WeatherManger() {
        mMainHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * 通过city获取天气
     *
     * @param city 需要被查询的city
     * @return 成功返回天气数据 失败返回null
     * @throws IOException IOException
     */
    private Weather getWeatherByCity(City city) throws Exception {
        DebugUtil.d(city.toString());
        sCity = city;
        // 1、默认获取魅族天气
        sWeather = setDefaultWeather();
        DebugUtil.d("setDefaultWeather " + sWeather);
        if (sWeather == null || sCity.getTownId() == null || sCity.getCityId() == null) {
            sWeather = getNextBackupWeather();
            DebugUtil.d("setDefaultWeather = null getNextBackupWeather = " + sWeather);
            if (sWeather == null) {
                return null;
            }
        }
        // 2、进行判断是否为魅族天气
        if (isMeiZu && !isRevamp) {
            // 2.1、添加天气预报的风向和风力参数
            revampMeiZuWeather();
            DebugUtil.d("revampMeiZuWeather " + sWeather);
            isRevamp = true;
        }
        // 3、判断是否为中央天气
        if (isNineTon && !isRevamp) {
            // 3.1、添加天气预报的风力，风向，日落，日出参数
            revampNineTonWeather();
            DebugUtil.d("revampNineTonWeather = " + sWeather);
            isRevamp = true;
        }
        // 4、判断是否为SoJson天气
        if (isSoJson && !isRevamp) {
            // 4.1、添加天气aqi参数
            revampSoJsonWeather();
            DebugUtil.d("revampSoJsonWeather = " + sWeather);
            isRevamp = true;
        }
        // 如果全部接口失效则返回空
        return sWeather;
    }

    /**
     * 通过cityName获取天气
     *
     * @param context  context
     * @param cityName 需要被查询的city
     * @return 成功返回天气数据 失败返回null
     * @throws IOException IOException
     */
    public Weather getWeatherByCityNameSync(Context context, String cityName) throws Exception {
        City city = CityUtil.getInstance().getCityByName(context, cityName);
        isMeiZu = isNineTon = isRevamp = isSoJson = isWthrcdn = false;
        isFirst = true;
        return getWeatherByCity(city);
    }

    /**
     * 通过Ip地址定位获取city，并返回天气数据
     *
     * @param callback 回调 请求回调
     */
    public void getWeatherByNoCity(final Context context, final ResponseCallback<Weather> callback) {
        ExecutorService singlePool = ThreadUtil.getSinglePool();
        singlePool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    String cityName = IpToCityManger.getInstance().getCityName();
                    DebugUtil.d("cityName: " + cityName);
                    getWeatherByName(context, cityName, callback);
                } catch (Exception e) {
                    e.printStackTrace();
                    onFailureCallback(callback, e.getMessage());
                }
            }
        });
    }

    /**
     * 通过Ip地址定位获取city，并返回天气数据
     */
    public Weather getWeatherByNoCitySync(final Context context) throws Exception {
        String cityName = IpToCityManger.getInstance().getCityName();
        return WeatherManger.getInstance().getWeatherByCityNameSync(context, cityName);
    }

    private void onFailureCallback(final ResponseCallback<Weather> callback, final String message) {
        mMainHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onFailure(message);
            }
        });
    }

    /**
     * 通过城市名获取天气
     *
     * @param cityName 城市名
     * @param callback 请求回调
     * @throws IOException IOException
     */
    private void getWeatherByName(Context context, String cityName, final ResponseCallback<Weather> callback) throws Exception {
        if (!DataFormat.isEmpty(cityName)) {
            final Weather weather = WeatherManger.getInstance().getWeatherByCityNameSync(context, cityName);
            mMainHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (weather != null) {
                        callback.onSuccess(weather);
                    } else {
                        callback.onFailure("获取天气失败");
                    }
                }
            });

        } else {
            onFailureCallback(callback, "城市名为空");
        }
    }

    /**
     * 通过城市名获取天气
     *
     * @param cityName 城市名
     * @param callback 请求回调
     */
    public void getWeatherByCityName(final Context context, final String cityName, final ResponseCallback<Weather> callback) {
        ExecutorService singlePool = ThreadUtil.getSinglePool();
        singlePool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    getWeatherByName(context, cityName, callback);
                } catch (Exception e) {
                    e.printStackTrace();
                    callback.onFailure(e.getMessage());
                }
            }
        });
    }

    /**
     * 如果请求的数据是魅族天气接口，
     * 则进行SoJson接口请求并修补天气预报的风力，风向参数
     * （因为中央天气缺少风向，所以直接请求SoJson接口）
     *
     * @throws IOException IOException
     */
    private void revampMeiZuWeather() throws Exception {
        Weather backupWeather = getNextBackupWeather();
        if (!DataFormat.isEmpty(backupWeather)) {
            Weather.Yesterday yesterday = sWeather.getYesterday();
            Weather.Yesterday backupYesterday = backupWeather.getYesterday();
            yesterday.setWd(backupYesterday.getWd())
                    .setWs(backupYesterday.getWs());
            List<Weather.Forecast> forecasts = sWeather.getForecasts();
            List<Weather.Forecast> backupForecasts = backupWeather.getForecasts();
            for (int i = 0; i < backupForecasts.size(); i++) {
                String wd = backupForecasts.get(i).getWd();
                String ws = backupForecasts.get(i).getWs();
                String notice = backupForecasts.get(i).getNotice();
                forecasts.get(i)
                        .setNotice(notice)
                        .setWd(wd)
                        .setWs(ws);
            }
        }
    }

    /**
     * 如果请求的数据是中央天气接口，
     * （因为前面的调用接口都已经失效才会请求到中央天气接口）
     * 则进行SoJson接口请求并修补天气预报的风力，风向，日落，日出参数
     *
     * @throws IOException IOException
     */
    private void revampNineTonWeather() throws Exception {
        // 获取的是SoJson的数据
        Weather backupWeather = getNextBackupWeather();
        if (!DataFormat.isEmpty(backupWeather)) {
            if (DataFormat.isEmpty(sWeather) || DataFormat.isEmpty(sWeather.getYesterday())) {
                return;
            }
            Weather.Yesterday yesterday = sWeather.getYesterday();
            Weather.Yesterday backupYesterday = backupWeather.getYesterday();
            yesterday.setWeek(backupYesterday.getWeek())
                    .setWd(backupYesterday.getWd())
                    .setWeather(backupYesterday.getWeather());

            List<Weather.Forecast> forecasts = sWeather.getForecasts();
            List<Weather.Forecast> backupForecasts = backupWeather.getForecasts();
            for (int i = 0; i < backupForecasts.size(); i++) {
                String wd = backupForecasts.get(i).getWd();
                String ws = backupForecasts.get(i).getWs();
                String sunrise = backupForecasts.get(i).getSunrise();
                String sunset = backupForecasts.get(i).getSunset();
                String week = backupForecasts.get(i).getWeek();
                String weather = backupForecasts.get(i).getWeather();
                String notice = backupForecasts.get(i).getNotice();
                forecasts.get(i)
                        .setWd(wd)
                        .setWs(ws)
                        .setWeek(week)
                        .setNotice(notice)
                        .setSunset(sunset)
                        .setSunrise(sunrise)
                        .setWeather(weather);
            }
        }
    }

    /**
     * 如果请求的数据是SoJson接口，
     * （因为前面的调用接口都已经失效才会请求到SoJson接口）
     * 则进行中华万年历接口请求并修补reaTime下的temp，time参数
     * （这两个参数SoJson接口请求下来的数据有问题）
     *
     * @throws IOException IOException
     */
    private void revampSoJsonWeather() throws Exception {
        // 获取的是Wthrcdn天气的数据
        Weather backupWeather = getNextBackupWeather();
        if (DataFormat.isEmpty(backupWeather)) {
            Weather.RealTime realTime = sWeather.getRealTime();
            Weather.RealTime backupRealTime = backupWeather.getRealTime();
            realTime.setTemp(backupRealTime.getTemp())
                    .setTime(backupRealTime.getTime());
        }
    }

    /**
     * 默认先请求魅族天气，
     * 调用接口失败则会调用中央天气接口
     *
     * @return 天气
     * @throws IOException IOException
     */
    private Weather setDefaultWeather() throws Exception {
        String param;
        Weather weather = null;
        if ((param = sCity.getCityId()) != null) {
            weather = WeatherManger.getInstance().getMeiZuWeather(param);
            if (DataFormat.isEmpty(weather)) {
                weather = getBackupWeather();
            } else {
                isMeiZu = true;
            }
        }
        return weather;
    }

    /**
     * 获取中央天气，
     * 如果出现请求出现问题则请求SoJson天气
     *
     * @return 天气
     * @throws IOException IOException
     */
    private Weather getBackupWeather() throws Exception {
        String param;
        Weather weather = null;
        if ((param = sCity.getTownId()) != null) {
            weather = WeatherManger.getInstance().getNineTonWeather(param);
            if (!DataFormat.isEmpty(weather)) {
                weather = getNextBackupWeather();
            } else {
                isNineTon = true;
            }
        }
        return weather;
    }

    /**
     * 获取中华万年历或SoJson的天气，
     * 如第一次请求SoJson接口出错则会调用中华万年历的接口
     * 第一次请求是SoJson天气，第二次请求是中华万年历天气
     *
     * @return 中华万年历或者SoJson的天气
     * @throws IOException IOException
     */
    private Weather getNextBackupWeather() throws Exception {
        String param;
        Weather weather = null;
        if ((param = sCity.getCity()) != null) {
            if (isFirst) {
                weather = WeatherManger.getInstance().getSoJsonWeather(param);
                if (weather != null) {
                    DebugUtil.d("getSoJsonWeather " + weather.toString());
                }
                isFirst = false;
                if (!DataFormat.isEmpty(weather)) {
                    isSoJson = true;
                }
            } else {
                weather = WeatherManger.getInstance().getWthrcdnWeather(param);
                if (weather != null) {
                    DebugUtil.d("getWthrcdnWeather " + weather.toString());
                }
                isWthrcdn = true;
            }
            if (DataFormat.isEmpty(weather)) {
                if (!isWthrcdn) {
                    weather = getNextBackupWeather();
                }
            }
        }
        return weather;
    }

    /**
     * 获取SoJson天气
     * 缺少 生活指数 lifeIndex & 实时紧急通知 alarms
     *
     * @param city 中文城市名
     */
    private Weather getSoJsonWeather(@NonNull String city) throws Exception {
        String url = SO_JSON_HOST + city;
        String weatherJson = HttpManger.getInstance().getSyncString(url);
        final Weather[] weather = {null};
        if (!DataFormat.isEmpty(weatherJson)) {
            SoJsonWeather soJsonWeather = new Gson().fromJson(weatherJson, SoJsonWeather.class);
            if (!DataFormat.isEmpty(soJsonWeather)) {
                weather[0] = WeatherConvertManger.convertWeather(soJsonWeather);
            }
        } else {
            final String preCity = getPreCity();
            if (!DataFormat.isEmpty(preCity)) {
                // 请求上级城市的天气 由于SoJson接口需要3秒后才能继续请求，所以延迟3秒后请求
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            weather[0] = getSoJsonWeather(preCity);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, 3000);
            }
        }
        if (!DataFormat.isEmpty(weather[0])) {
            return weather[0];
        }
        return null;
    }

    /**
     * 获取上级城市名字
     *
     * @return 上级城市名字
     */
    private String getPreCity() {
        String preCityName = CityUtil.getInstance().getPreCityName();
        if (!DataFormat.isEmpty(preCityName)) {
            return preCityName;
        }
        return null;
    }

    /**
     * 获取中华日历天气
     * 缺少 实时紧急通知 alarms & 生活指数 lifeIndex & 空气质量 aqi
     *
     * @param city 城市名ID 特殊ID
     */
    private Weather getWthrcdnWeather(@NonNull String city) throws Exception {
        String url = WTHRCDN_HOST + city;
        String weatherJson = HttpManger.getInstance().getSyncString(url);
        if (!DataFormat.isEmpty(weatherJson)) {
            WthrcdnWeather wthrcdnWeather = new Gson().fromJson(weatherJson, WthrcdnWeather.class);
            if (!DataFormat.isEmpty(wthrcdnWeather)) {
                Weather weather = WeatherConvertManger.convertWeather(wthrcdnWeather);
                if (!DataFormat.isEmpty(weather)) {
                    return weather;
                }
            }
        }
        return null;
    }

    /**
     * 获取魅族天气
     * 缺少 风力 ws
     *
     * @param cityIds 城市名ID 特殊ID
     */
    private Weather getMeiZuWeather(@NonNull String cityIds) throws Exception {
        String url = MEI_ZU_HOST + cityIds;
        String weatherJson = HttpManger.getInstance().getSyncString(url);
        if (!DataFormat.isEmpty(weatherJson)) {
            MeiZuWeather meiZuWeather = new Gson().fromJson(weatherJson, MeiZuWeather.class);
            if (!DataFormat.isEmpty(meiZuWeather)) {
                Weather weather = WeatherConvertManger.convertWeather(meiZuWeather);
                if (!DataFormat.isEmpty(weather)) {
                    return weather;
                }
            }
        }
        return null;
    }

    /**
     * 获取中央天气
     * 缺少 实时紧急通知  alarms
     *
     * @param cityId 城市名ID
     */
    private Weather getNineTonWeather(@NonNull String cityId) throws Exception {
        String url = NINE_TON_HOST + cityId;
        String weatherJson = HttpManger.getInstance().getSyncString(url);
        if (!DataFormat.isEmpty(weatherJson)) {
            NineTonWeather nineTonWeather = new Gson().fromJson(weatherJson, NineTonWeather.class);
            if (!DataFormat.isEmpty(nineTonWeather)) {
                Weather weather = WeatherConvertManger.convertWeather(nineTonWeather);
                if (!DataFormat.isEmpty(weather)) {
                    return weather;
                }
            }
        }
        return null;
    }

}

