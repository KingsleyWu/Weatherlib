package com.joywe.weatherlib.biz.convert;


import com.joywe.weatherlib.model.weather.Weather;
import com.joywe.weatherlib.model.weather.sojson.SoJsonWeather;

import java.util.Date;
import java.util.List;

public class SoJsonConvert extends BaseConvert<SoJsonWeather> {
    @Override
    public Weather convertWeather(SoJsonWeather soJsonWeather) {
        try {
            SoJsonWeather.DataBean soJsonWeatherData = soJsonWeather.getData();
            List<SoJsonWeather.DataBean.ForecastBean> forecastBeans = soJsonWeatherData.getForecast();
            SoJsonWeather.DataBean.ForecastBean realTimeForecast = forecastBeans.get(0);

            mCity = soJsonWeather.getCity();

            mRealTime.setHum(soJsonWeatherData.getShidu())
                    .setTemp(soJsonWeatherData.getWendu())
                    .setTime(soJsonWeather.getDate())
                    .setWeather(realTimeForecast.getType())
                    .setWd(realTimeForecast.getFx())
                    .setWs(realTimeForecast.getFl());

            SoJsonWeather.DataBean.YesterdayBean soJsonYesterday = soJsonWeatherData.getYesterday();
            mYesterday.setDate(getFormat(MONTH_DAY_FORMAT).format(new Date(System.currentTimeMillis() - getDayTimeMillis())))
                    .setHigh(getHighOrLow(soJsonYesterday.getHigh()))
                    .setLow(getHighOrLow(soJsonYesterday.getLow()))
                    .setWd(soJsonYesterday.getFx())
                    .setWs(soJsonYesterday.getFl())
                    .setWeather(soJsonYesterday.getType())
                    .setWeek(soJsonYesterday.getDate().substring(soJsonYesterday.getDate().indexOf("日") + 1));
            int size = forecastBeans.size();
            for (int i = 0; i < size; i++) {
                SoJsonWeather.DataBean.ForecastBean forecastBean = forecastBeans.get(i);
                Weather.Forecast forecast = new Weather.Forecast();
                forecast.setDate(getFormat(MONTH_DAY_FORMAT).format(new Date(System.currentTimeMillis() + i * getDayTimeMillis())))
                        .setHigh(getHighOrLow(forecastBean.getHigh()))
                        .setLow(getHighOrLow(forecastBean.getLow()))
                        .setSunrise(forecastBean.getSunrise())
                        .setSunset(forecastBean.getSunset())
                        .setWd(forecastBean.getFx())
                        .setWs(forecastBean.getFl())
                        .setWeather(forecastBean.getType())
                        .setNotice(forecastBean.getNotice())
                        .setWeek(forecastBean.getDate().substring(forecastBean.getDate().indexOf("日") + 1));
                mForecasts.add(forecast);
            }

            mAqi.setAqi(realTimeForecast.getAqi())
                    .setPm25(soJsonWeatherData.getPm25())
                    .setPm10(soJsonWeatherData.getPm10())
                    .setQuality(soJsonWeatherData.getQuality())
                    .setUpDateTime(soJsonWeather.getDate());

            //  todo aqi 不全
            //  todo missing lifeIndex
            // todo missing alarms
            setWeather();
        } catch (Exception e) {
            return null;
        }
        return mWeather;
    }

    private String getHighOrLow(String highOrLowStr) {
        int startIndex = highOrLowStr.lastIndexOf(" ") + 1;
        int endIndex = highOrLowStr.indexOf(".");
        return highOrLowStr.substring(startIndex, endIndex);
    }
}
