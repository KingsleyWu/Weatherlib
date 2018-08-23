package com.joywe.weatherlib.biz.convert;

import android.annotation.SuppressLint;

import com.joywe.weatherlib.model.weather.Weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseConvert<T> {

    /**
     * 把其它天气类转换成Weather
     *
     * @param t 被转换的天气
     * @return 转换后的Weather
     */
    public abstract Weather convertWeather(T t);

    /**
     * Weather类
     */
    Weather mWeather = new Weather();
    /**
     * 城市
     */
    String mCity;
    /**
     * 天气预报
     */
    List<Weather.Forecast> mForecasts = new ArrayList<>();
    /**
     * 昨天天气
     */
    Weather.Yesterday mYesterday = new Weather.Yesterday();
    /**
     * 实时天气
     */
    Weather.RealTime mRealTime = new Weather.RealTime();
    /**
     * 空气质量
     */
    Weather.Aqi mAqi = new Weather.Aqi();
    /**
     * 生活指数
     */
    List<Weather.LifeIndex> mLifeIndexs = new ArrayList<>();
    /**
     * 实时紧急通知
     */
    List<Weather.Alarms> mAlarms = new ArrayList<>();

    /**
     * 通过aqi值获取空气质量
     *
     * @param aqi aqi
     * @return 空气质量
     */
    String getQualityByAqi(String aqi) {
        String quality = null;
        int aqiValue = Integer.valueOf(aqi);
        if (aqiValue < 50) {
            quality = "优";
        } else if (aqiValue > 50 && aqiValue < 100) {
            quality = "良好";
        } else if (aqiValue >= 100 && aqiValue <= 200) {
            quality = "轻度污染";
        } else if (aqiValue > 200 && aqiValue <= 300) {
            quality = "中度污染";
        } else if (aqiValue > 300) {
            quality = "严重污染";
        }
        return quality;
    }

    static String subString(String str, String strStart, String strEnd) {
        /* 找出指定的2个字符在 该字符串里面的 位置 */
        int strStartIndex = str.lastIndexOf(strStart);
        int strEndIndex = str.indexOf(strEnd);
        /* 开始截取 */
        return str.substring(strStartIndex, strEndIndex).substring(strStart.length());
    }

    void setWeather() {
        mWeather.setCity(mCity)
                .setRealTime(mRealTime)
                .setYesterday(mYesterday)
                .setAqi(mAqi)
                .setForecasts(mForecasts)
                .setLifeIndex(mLifeIndexs)
                .setAlarms(mAlarms);
    }


    @SuppressLint("SimpleDateFormat")
    static SimpleDateFormat getFormat(String format) {
        return new SimpleDateFormat(format);
    }

    long getDayTimeMillis() {
        return 60 * 60 * 24 * 1000;
    }

    static final String MONTH_DAY_FORMAT = "yyyy-MM-dd";

    private static final String WEEK_FORMAT = "EEEE";

    /**
     * 通过data获取星期
     *
     * @param dataStr data
     * @return 星期
     */
    static String getWeek(String dataStr) {
        try {
            return getFormat(WEEK_FORMAT).format(getFormat(MONTH_DAY_FORMAT).parse(dataStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    static SimpleDateFormat getYMDFormat() {
        return getFormat(MONTH_DAY_FORMAT);
    }

}
