package com.joywe.weatherlib.biz.convert;

import com.joywe.weatherlib.model.weather.Weather;
import com.joywe.weatherlib.model.weather.wthrcdn.WthrcdnWeather;

import java.util.Date;
import java.util.List;

public class WthrcdnConvert extends BaseConvert<WthrcdnWeather> {

    @Override
    public Weather convertWeather(WthrcdnWeather wthrcdnweather) {
        try {
            WthrcdnWeather.DataBean wthrcdnweatherdata = wthrcdnweather.getData();
            List<WthrcdnWeather.DataBean.ForecastBean> forecastBeans = wthrcdnweatherdata.getForecast();
            WthrcdnWeather.DataBean.YesterdayBean yesterdayBean = wthrcdnweatherdata.getYesterday();

            mCity = wthrcdnweatherdata.getCity();

            mYesterday.setDate(getFormat(MONTH_DAY_FORMAT).format(new Date(System.currentTimeMillis() - getDayTimeMillis())))
                    .setHigh(getHighOrLow(yesterdayBean.getHigh()))
                    .setLow(getHighOrLow(yesterdayBean.getLow()))
                    .setWd(yesterdayBean.getFx())
                    .setWs(getWs(yesterdayBean.getFl()))
                    .setWeather(yesterdayBean.getType())
                    .setWeek(yesterdayBean.getDate().substring(yesterdayBean.getDate().indexOf("日") + 1));

            WthrcdnWeather.DataBean.ForecastBean realTimeData = forecastBeans.get(0);
            mRealTime.setWd(realTimeData.getFengxiang())
                    .setWs(getWs(realTimeData.getFengli()))
                    .setWeather(realTimeData.getType())
                    .setTime(getFormat(MONTH_DAY_FORMAT).format(new Date(System.currentTimeMillis())))
                    .setTemp(wthrcdnweatherdata.getWendu());

            int size = forecastBeans.size();
            for (int i = 0; i < size; i++) {
                WthrcdnWeather.DataBean.ForecastBean forecastBean = forecastBeans.get(i);
                Weather.Forecast forecast = new Weather.Forecast();
                // 15日星期二
                String date = forecastBean.getDate();
                String nowYMD = getFormat(MONTH_DAY_FORMAT).format(new Date(System.currentTimeMillis() + getDayTimeMillis() * i - 1));
                forecast.setDate(nowYMD)
                        .setWd(forecastBean.getFengxiang())
                        .setWs(getWs(forecastBean.getFengli()))
                        .setLow(getHighOrLow(forecastBean.getLow()))
                        .setHigh(getHighOrLow(forecastBean.getHigh()))
                        .setWeather(forecastBean.getType())
                        .setWeek(date.substring(date.indexOf("日") + 1));
                mForecasts.add(forecast);
            }

            // todo missing lifeIndex

            // todo missing Aqi

            // todo missing alarms

            setWeather();

        } catch (Exception e) {
            return null;
        }
        return mWeather;
    }

    private String getWs(String wsStr){
        int startIndex = wsStr.lastIndexOf("[")+1;
        int endIndex = wsStr.indexOf("]");
       return wsStr.substring(startIndex, endIndex);
    }

    private String getHighOrLow(String highOrLowStr){
        int startIndex = highOrLowStr.lastIndexOf(" ")+1;
        int endIndex = highOrLowStr.indexOf("℃");
        return highOrLowStr.substring(startIndex, endIndex);
    }
}
