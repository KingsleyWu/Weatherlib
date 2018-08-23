package com.joywe.weatherlib.biz.convert;

import com.joywe.weatherlib.model.weather.Weather;
import com.joywe.weatherlib.model.weather.meizu.MeiZuWeather;
import com.joywe.weatherlib.model.weather.nineton.NineTonWeather;
import com.joywe.weatherlib.model.weather.sojson.SoJsonWeather;
import com.joywe.weatherlib.model.weather.wthrcdn.WthrcdnWeather;

public class WeatherConvertManger {

    private static MeiZuConvert sMeiZuConvert;
    private static NineTonConvert sNineTonConvert;
    private static SoJsonConvert sSoJsonConvert;
    private static WthrcdnConvert sWthrcdnConvert;

    /**
     * 把魅族天气及转化成Weather
     *
     * @param meiZuWeather 魅族天气
     */
    public static Weather convertWeather(MeiZuWeather meiZuWeather) {
        sMeiZuConvert = new MeiZuConvert();
        return sMeiZuConvert.convertWeather(meiZuWeather);
    }

    /**
     * 把中央天气转化成JoyWeWeather
     * 缺少实时紧急通知 alarms
     *
     * @param nineTonWeather 中央天气
     */
    public static Weather convertWeather(NineTonWeather nineTonWeather) {
        sNineTonConvert = new NineTonConvert();
        return sNineTonConvert.convertWeather(nineTonWeather);
    }

    /**
     * 把SoJson天气转化成JoyWeWeather
     * 缺少实时紧急通知 alarms
     * http://open.sojson.com/images/weather/day/1.png 图片地址
     *
     * @param soJsonWeather SoJson天气
     */
    public static Weather convertWeather(SoJsonWeather soJsonWeather) {
        sSoJsonConvert = new SoJsonConvert();
        return sSoJsonConvert.convertWeather(soJsonWeather);
    }

    /**
     * 把中华日历天气转化成JoyWeWeather
     * 缺少实时紧急通知 alarms 湿度  hum
     *
     * @param wthrcdnWeather 中华日历天气
     */
    public static Weather convertWeather(WthrcdnWeather wthrcdnWeather) {
        sWthrcdnConvert = new WthrcdnConvert();
        return sWthrcdnConvert.convertWeather(wthrcdnWeather);
    }

    public static MeiZuConvert getMeiZuConvert() {
        return sMeiZuConvert;
    }

    public static NineTonConvert getNineTonConvert() {
        return sNineTonConvert;
    }

    public static SoJsonConvert getSoJsonConvert() {
        return sSoJsonConvert;
    }

    public static WthrcdnConvert getWthrcdnConvert() {
        return sWthrcdnConvert;
    }
}
