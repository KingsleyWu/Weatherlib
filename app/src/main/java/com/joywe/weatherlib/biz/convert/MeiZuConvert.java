package com.joywe.weatherlib.biz.convert;

import com.joywe.weatherlib.model.weather.Weather;
import com.joywe.weatherlib.model.weather.meizu.MeiZuWeather;

import java.util.List;

public class MeiZuConvert extends BaseConvert<MeiZuWeather> {

    @Override
    public Weather convertWeather(MeiZuWeather meiZuWeather) {
        try {
            MeiZuWeather.ValueBean valueBean = meiZuWeather.getValue().get(0);
            MeiZuWeather.ValueBean.RealtimeBean realtime = valueBean.getRealtime();
            MeiZuWeather.ValueBean.Pm25Bean pm25 = valueBean.getPm25();
            List<MeiZuWeather.ValueBean.WeathersBean> weathers = valueBean.getWeathers();
            List<MeiZuWeather.ValueBean.IndexesBean> indexes = valueBean.getIndexes();
            List<MeiZuWeather.ValueBean.AlarmsBean> meiZuAlarms = valueBean.getAlarms();

            mCity = valueBean.getCity();

            mRealTime.setWs(realtime.getWs())
                    .setWd(realtime.getWd())
                    .setWeather(realtime.getWeather())
                    .setTime(realtime.getTime())
                    .setHum(realtime.getSd())
                    .setTemp(realtime.getTemp());

            MeiZuWeather.ValueBean.WeathersBean weathersBean6 = weathers.get(6);
            mYesterday.setDate(weathersBean6.getDate())
                    .setHigh(weathersBean6.getTemp_day_c())
                    .setLow(weathersBean6.getTemp_night_c())
                    .setWd(weathersBean6.getWd())
                    .setWs(weathersBean6.getWs())
                    .setWeather(weathersBean6.getWeather())
                    .setWeek(weathersBean6.getWeek());
            int size = weathers.size();
            for (int i = 0; i < size-2; i++) {
                Weather.Forecast forecast = new Weather.Forecast();
                MeiZuWeather.ValueBean.WeathersBean weathersBean = weathers.get(i);
                forecast.setDate(weathersBean.getDate())
                        .setHigh(weathersBean.getTemp_day_c())
                        .setLow(weathersBean.getTemp_night_c())
                        .setSunrise(weathersBean.getSun_rise_time())
                        .setSunset(weathersBean.getSun_down_time())
                        .setWd(weathersBean.getWd())
                        .setWs(weathersBean.getWs())
                        .setWeather(weathersBean.getWeather())
                        .setWeek(weathersBean.getWeek());
                mForecasts.add(forecast);
            }

            for (MeiZuWeather.ValueBean.IndexesBean index : indexes) {
                Weather.LifeIndex lifeIndex = new Weather.LifeIndex();
                lifeIndex.setName(index.getName())
                        .setLevel(index.getLevel())
                        .setContent(index.getContent());
                mLifeIndexs.add(lifeIndex);
            }

            mAqi.setAqi(pm25.getAqi())
                    .setPm25(pm25.getPm25())
                    .setPm10(pm25.getPm10())
                    .setQuality(pm25.getQuality())
                    .setCo(pm25.getCo())
                    .setNo2(pm25.getNo2())
                    .setO3(pm25.getO3())
                    .setSo2(pm25.getSo2())
                    .setUpDateTime(pm25.getUpDateTime());

            for (MeiZuWeather.ValueBean.AlarmsBean meiZuAlarm : meiZuAlarms) {
                Weather.Alarms alarm = new Weather.Alarms();
                alarm.setAlarmId(meiZuAlarm.getAlarmId())
                        .setAlarmType(meiZuAlarm.getAlarmType())
                        .setAlarmTypeDesc(meiZuAlarm.getAlarmTypeDesc())
                        .setAlarmLevelNo(meiZuAlarm.getAlarmLevelNo())
                        .setAlarmLevelNoDesc(meiZuAlarm.getAlarmLevelNoDesc())
                        .setAlarmContent(meiZuAlarm.getAlarmContent())
                        .setPublishTime(meiZuAlarm.getPublishTime())
                        .setAlarmDesc(meiZuAlarm.getAlarmDesc())
                        .setPrecaution(meiZuAlarm.getPrecaution());
                mAlarms.add(alarm);
            }

            setWeather();

        } catch (Exception e) {
            return null;
        }
        return mWeather;
    }

}
