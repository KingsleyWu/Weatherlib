package com.joywe.weatherlib.biz.convert;

import com.joywe.weatherlib.model.weather.Weather;
import com.joywe.weatherlib.model.weather.nineton.NineTonWeather;

import java.util.List;

public class NineTonConvert extends BaseConvert<NineTonWeather> {

    @Override
    public Weather convertWeather(NineTonWeather nineTonWeather) {
        try {
            NineTonWeather.WeatherBean weatherBean = nineTonWeather.getWeather().get(0);
            NineTonWeather.WeatherBean.NowBean nowBean = weatherBean.getNow();
            NineTonWeather.WeatherBean.TodayBean todayBean = weatherBean.getToday();

            mCity = weatherBean.getCity_name();

            mRealTime.setWs(nowBean.getWind_scale())
                    .setWd(nowBean.getWind_direction())
                    .setWeather(nowBean.getText())
                    .setTime(weatherBean.getLast_update())
                    .setHum(nowBean.getHumidity())
                    .setTemp(nowBean.getTemperature())
                    .setSunrise(todayBean.getSunrise())
                    .setSunset(todayBean.getSunset());

            List<NineTonWeather.WeatherBean.FutureBean> futureBeans = weatherBean.getFuture();
            int size = futureBeans.size()-2;
            for (int i = 3; i < size; i++) {
                Weather.Forecast forecast = new Weather.Forecast();
                NineTonWeather.WeatherBean.FutureBean weathersBean = futureBeans.get(i);
                forecast.setDate(weathersBean.getDate())
                        .setHigh(weathersBean.getHigh())
                        .setLow(weathersBean.getLow())
                        .setWs(weathersBean.getWind())
                        .setWeather(weathersBean.getText())
                        .setWeek(weathersBean.getDay());
                mForecasts.add(forecast);
            }
            if (size>3){
                NineTonWeather.WeatherBean.FutureBean weathersBean = futureBeans.get(2);
                mYesterday.setDate(weathersBean.getDate())
                        .setHigh(weathersBean.getHigh())
                        .setLow(weathersBean.getLow())
                        .setWs(weathersBean.getWind())
                        .setWeather(weathersBean.getText())
                        .setWeek(weathersBean.getDay());
            }


            NineTonWeather.WeatherBean.TodayBean.SuggestionBean suggestionBean = todayBean.getSuggestion();
            NineTonWeather.WeatherBean.TodayBean.SuggestionBean.CarWashingBean carWashing = suggestionBean.getCar_washing();
            NineTonWeather.WeatherBean.TodayBean.SuggestionBean.DressingBean dressing = suggestionBean.getDressing();
            NineTonWeather.WeatherBean.TodayBean.SuggestionBean.FluBean flu = suggestionBean.getFlu();
            NineTonWeather.WeatherBean.TodayBean.SuggestionBean.SportBean sport = suggestionBean.getSport();
            NineTonWeather.WeatherBean.TodayBean.SuggestionBean.TravelBean travel = suggestionBean.getTravel();
            NineTonWeather.WeatherBean.TodayBean.SuggestionBean.UvBean uv = suggestionBean.getUv();

            mLifeIndexs.add(getLifeIndex("洗车指数", carWashing.getBrief(), carWashing.getDetails()));
            mLifeIndexs.add(getLifeIndex("化妆指数", dressing.getBrief(), dressing.getDetails()));
            mLifeIndexs.add(getLifeIndex("感冒指数", flu.getBrief(), flu.getDetails()));
            mLifeIndexs.add(getLifeIndex("运动指数", sport.getBrief(), sport.getDetails()));
            mLifeIndexs.add(getLifeIndex("旅游指数", travel.getBrief(), travel.getDetails()));
            mLifeIndexs.add(getLifeIndex("紫外线强度指数", uv.getBrief(), uv.getDetails()));

            NineTonWeather.WeatherBean.NowBean.AirQualityBean.CityBean qualityCity = nowBean.getAir_quality().getCity();
            mAqi.setAqi(qualityCity.getAqi())
                    .setPm25(qualityCity.getPm25())
                    .setPm10(qualityCity.getPm10())
                    .setQuality(qualityCity.getQuality())
                    .setCo(qualityCity.getCo())
                    .setNo2(qualityCity.getNo2())
                    .setO3(qualityCity.getO3())
                    .setSo2(qualityCity.getSo2())
                    .setUpDateTime(qualityCity.getLast_update());

            // todo missing alarms
            // todo missing yesterday

            setWeather();

        } catch (Exception e) {
            return null;
        }
        return mWeather;
    }

    /**
     * 获取lifeIndex
     *
     * @param name    lifeIndex name
     * @param brief   lifeIndex level
     * @param details lifeIndex content
     * @return lifeIndex
     */
    private static Weather.LifeIndex getLifeIndex(String name, String brief, String details) {
        Weather.LifeIndex lifeIndex = new Weather.LifeIndex();
        lifeIndex.setName(name)
                .setLevel(brief)
                .setContent(details);
        return lifeIndex;
    }
}
