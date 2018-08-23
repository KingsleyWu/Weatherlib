package com.joywe.weatherlib.model.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 1、温度（实时、最低、最高）
 * 2、天气（文字+图片显示）
 * 3、风向风力
 * 4、紫外线强度
 * 5、相对湿度
 * 6、空气质量
 * 7、实时紧急通知
 */

public class Weather implements Parcelable {
    /** 城市 */
    private String city;
    /** 天气预报 */
    private List<Forecast> forecasts;
    /** 实时紧急通知 */
    private List<Alarms> alarms;
    /** 昨天天气 */
    private Yesterday yesterday;
    /** 实时天气 */
    private RealTime realTime;
    /** 空气质量 */
    private Aqi aqi;
    /** 生活指数 */
    private List<LifeIndex> lifeIndex;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Weather weather = (Weather) o;
        return Objects.equals(city, weather.city) &&
                Objects.equals(forecasts, weather.forecasts) &&
                Objects.equals(alarms, weather.alarms) &&
                Objects.equals(yesterday, weather.yesterday) &&
                Objects.equals(realTime, weather.realTime) &&
                Objects.equals(aqi, weather.aqi) &&
                Objects.equals(lifeIndex, weather.lifeIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, forecasts, alarms, yesterday, realTime, aqi, lifeIndex);
    }

    @Override
    public String toString() {
        return "Weather{" +
                " city='" + city + '\'' +
                ", aqi=" + aqi +
                ", yesterday=" + yesterday +
                ", realTime=" + realTime +
                ", forecasts=" + forecasts +
                ", lifeIndex=" + lifeIndex +
                ", alarms=" + alarms +
                '}';
    }

    public String getCity() {
        return city;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public Yesterday getYesterday() {
        return yesterday;
    }

    public List<Alarms> getAlarms() {
        return alarms;
    }

    public RealTime getRealTime() {
        return realTime;
    }

    public Aqi getAqi() {
        return aqi;
    }

    public List<LifeIndex> getLifeIndex() {
        return lifeIndex;
    }

    public Weather setCity(String city) {
        this.city = city;
        return this;
    }

    public Weather setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
        return this;
    }

    public Weather setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
        return this;
    }

    public Weather setAlarms(List<Alarms> alarms) {
        this.alarms = alarms;
        return this;
    }

    public Weather setRealTime(RealTime realTime) {
        this.realTime = realTime;
        return this;
    }

    public Weather setAqi(Aqi aqi) {
        this.aqi = aqi;
        return this;
    }

    public Weather setLifeIndex(List<LifeIndex> lifeIndex) {
        this.lifeIndex = lifeIndex;
        return this;
    }

    public static class Alarms implements Parcelable {

        /*
         * alarmContent : 安徽省气象台2016年09月29日11时30分变更台风蓝色预警信号区域。受台风“鲇鱼”残留云系影响，24小时内全省东北风平均风力4级左右，部分地区阵风可达8-9级，沿淮到沿江部分地区暴雨，局部大暴雨，请注意加强防范。
         * alarmDesc : 24小时内平均风力达6级以上或阵风8级以上，并可能持续
         * alarmId : 201609291135583211台风蓝色
         * alarmLevelNo : 01
         * alarmLevelNoDesc : 蓝色
         * alarmType : 01
         * alarmTypeDesc : 台风预警
         * precaution : 1.关好门窗并将易被风吹动的搭建物固紧;
         * <p>
         * 2.居民避免外出，停止室外作业到室内暂避;
         * <p>
         * 3.做好台风准备的同时，也要做好防雷电的准备。
         * publishTime : 09月29日 11:30 发布
         */

        /** 紧急通知内容 */
        private String alarmContent;
        /** 紧急通知描述 */
        private String alarmDesc;
        /** 紧急通知Id */
        private String alarmId;
        /** 紧急通知编号 */
        private String alarmLevelNo;
        /** 紧急通知编号描述 */
        private String alarmLevelNoDesc;
        /** 紧急通知类型 */
        private String alarmType;
        /** 紧急通知类型描述 */
        private String alarmTypeDesc;
        /** 预防提示 */
        private String precaution;
        /** 紧急通知发布时间 */
        private String publishTime;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Alarms alarms = (Alarms) o;
            return Objects.equals(alarmContent, alarms.alarmContent) &&
                    Objects.equals(alarmDesc, alarms.alarmDesc) &&
                    Objects.equals(alarmId, alarms.alarmId) &&
                    Objects.equals(alarmLevelNo, alarms.alarmLevelNo) &&
                    Objects.equals(alarmLevelNoDesc, alarms.alarmLevelNoDesc) &&
                    Objects.equals(alarmType, alarms.alarmType) &&
                    Objects.equals(alarmTypeDesc, alarms.alarmTypeDesc) &&
                    Objects.equals(precaution, alarms.precaution) &&
                    Objects.equals(publishTime, alarms.publishTime);
        }

        @Override
        public int hashCode() {

            return Objects.hash(alarmContent, alarmDesc, alarmId, alarmLevelNo, alarmLevelNoDesc, alarmType, alarmTypeDesc, precaution, publishTime);
        }

        @Override
        public String toString() {
            return "Alarms{" +
                    "alarmContent='" + alarmContent + '\'' +
                    ", alarmDesc='" + alarmDesc + '\'' +
                    ", alarmId='" + alarmId + '\'' +
                    ", alarmLevelNo='" + alarmLevelNo + '\'' +
                    ", alarmLevelNoDesc='" + alarmLevelNoDesc + '\'' +
                    ", alarmType='" + alarmType + '\'' +
                    ", alarmTypeDesc='" + alarmTypeDesc + '\'' +
                    ", precaution='" + precaution + '\'' +
                    ", publishTime='" + publishTime + '\'' +
                    '}';
        }

        public Alarms setAlarmContent(String alarmContent) {
            this.alarmContent = alarmContent;
            return this;
        }

        public Alarms setAlarmDesc(String alarmDesc) {
            this.alarmDesc = alarmDesc;
            return this;
        }

        public Alarms setAlarmId(String alarmId) {
            this.alarmId = alarmId;
            return this;
        }

        public Alarms setAlarmLevelNo(String alarmLevelNo) {
            this.alarmLevelNo = alarmLevelNo;
            return this;
        }

        public Alarms setAlarmLevelNoDesc(String alarmLevelNoDesc) {
            this.alarmLevelNoDesc = alarmLevelNoDesc;
            return this;
        }

        public Alarms setAlarmType(String alarmType) {
            this.alarmType = alarmType;
            return this;
        }

        public Alarms setAlarmTypeDesc(String alarmTypeDesc) {
            this.alarmTypeDesc = alarmTypeDesc;
            return this;
        }

        public Alarms setPrecaution(String precaution) {
            this.precaution = precaution;
            return this;
        }

        public Alarms setPublishTime(String publishTime) {
            this.publishTime = publishTime;
            return this;
        }

        public String getAlarmContent() {
            return alarmContent;
        }

        public String getAlarmDesc() {
            return alarmDesc;
        }

        public String getAlarmId() {
            return alarmId;
        }

        public String getAlarmLevelNo() {
            return alarmLevelNo;
        }

        public String getAlarmLevelNoDesc() {
            return alarmLevelNoDesc;
        }

        public String getAlarmType() {
            return alarmType;
        }

        public String getAlarmTypeDesc() {
            return alarmTypeDesc;
        }

        public String getPrecaution() {
            return precaution;
        }

        public String getPublishTime() {
            return publishTime;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel reply){
            this.alarmContent = reply.readString();
            this.alarmDesc = reply.readString();
            this.alarmId = reply.readString();
            this.alarmLevelNo = reply.readString();
            this.alarmLevelNoDesc = reply.readString();
            this.alarmType = reply.readString();
            this.alarmTypeDesc = reply.readString();
            this.precaution = reply.readString();
            this.publishTime = reply.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.alarmContent);
            dest.writeString(this.alarmDesc);
            dest.writeString(this.alarmId);
            dest.writeString(this.alarmLevelNo);
            dest.writeString(this.alarmLevelNoDesc);
            dest.writeString(this.alarmType);
            dest.writeString(this.alarmTypeDesc);
            dest.writeString(this.precaution);
            dest.writeString(this.publishTime);
        }

        public Alarms() {
        }

        protected Alarms(Parcel in) {
            this.alarmContent = in.readString();
            this.alarmDesc = in.readString();
            this.alarmId = in.readString();
            this.alarmLevelNo = in.readString();
            this.alarmLevelNoDesc = in.readString();
            this.alarmType = in.readString();
            this.alarmTypeDesc = in.readString();
            this.precaution = in.readString();
            this.publishTime = in.readString();
        }

        public static final Creator<Alarms> CREATOR = new Creator<Alarms>() {
            @Override
            public Alarms createFromParcel(Parcel source) {
                return new Alarms(source);
            }

            @Override
            public Alarms[] newArray(int size) {
                return new Alarms[size];
            }
        };
    }

    public static class Yesterday implements Parcelable {
        /*
         * date : 2018-05-15
         * week : 星期二
         * high : 35
         * low : 26
         * weather : 晴
         * wd : 南风
         * ws : 3级
         */
        /** 时间 */
        private String date;
        /** 星期 */
        private String week;
        /** 最高温 */
        private String high;
        /** 最低温 */
        private String low;
        /** 天气 */
        private String weather;
        /** 风向 */
        private String wd;
        /** 风力 */
        private String ws;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Yesterday yesterday = (Yesterday) o;
            return Objects.equals(date, yesterday.date) &&
                    Objects.equals(week, yesterday.week) &&
                    Objects.equals(high, yesterday.high) &&
                    Objects.equals(low, yesterday.low) &&
                    Objects.equals(weather, yesterday.weather) &&
                    Objects.equals(wd, yesterday.wd) &&
                    Objects.equals(ws, yesterday.ws);
        }

        @Override
        public int hashCode() {

            return Objects.hash(date, week, high, low, weather, wd, ws);
        }

        @Override
        public String toString() {
            return "Yesterday{" +
                    "date='" + date + '\'' +
                    ", week='" + week + '\'' +
                    ", high='" + high + '\'' +
                    ", low='" + low + '\'' +
                    ", weather='" + weather + '\'' +
                    ", wd='" + wd + '\'' +
                    ", ws='" + ws + '\'' +
                    '}';
        }

        public String getDate() {
            return date;
        }

        public Yesterday setDate(String date) {
            this.date = date;
            return this;
        }

        public String getWeek() {
            return week;
        }

        public Yesterday setWeek(String week) {
            this.week = week;
            return this;
        }

        public String getHigh() {
            return high;
        }

        public Yesterday setHigh(String high) {
            this.high = high;
            return this;
        }

        public String getLow() {
            return low;
        }

        public Yesterday setLow(String low) {
            this.low = low;
            return this;
        }

        public String getWeather() {
            return weather;
        }

        public Yesterday setWeather(String weather) {
            this.weather = weather;
            return this;
        }

        public String getWd() {
            return wd;
        }

        public Yesterday setWd(String wd) {
            this.wd = wd;
            return this;
        }

        public String getWs() {
            return ws;
        }

        public Yesterday setWs(String ws) {
            this.ws = ws;
            return this;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel reply){
            this.date = reply.readString();
            this.week = reply.readString();
            this.high = reply.readString();
            this.low = reply.readString();
            this.weather = reply.readString();
            this.wd = reply.readString();
            this.ws = reply.readString();
        }
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.date);
            dest.writeString(this.week);
            dest.writeString(this.high);
            dest.writeString(this.low);
            dest.writeString(this.weather);
            dest.writeString(this.wd);
            dest.writeString(this.ws);
        }

        public Yesterday() {
        }

        protected Yesterday(Parcel in) {
            this.date = in.readString();
            this.week = in.readString();
            this.high = in.readString();
            this.low = in.readString();
            this.weather = in.readString();
            this.wd = in.readString();
            this.ws = in.readString();
        }

        public static final Creator<Yesterday> CREATOR = new Creator<Yesterday>() {
            @Override
            public Yesterday createFromParcel(Parcel source) {
                return new Yesterday(source);
            }

            @Override
            public Yesterday[] newArray(int size) {
                return new Yesterday[size];
            }
        };
    }

    public static class RealTime implements Parcelable {
        /*
         * temp : 31
         * time : 2018-05-15
         * weather : 晴
         * hum : 60
         * wd : 西南风
         * ws : 3级
         */
        /** 温度 */
        private String temp;
        /** 时间 */
        private String time;
        /** 天气 */
        private String weather;
        /** 相对湿度 */
        private String hum;
        /** 风向 */
        private String wd;
        /** 风力 */
        private String ws;
        /** 日出时间 */
        private String sunrise;
        /** 日落时间 */
        private String sunset;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            RealTime realTime = (RealTime) o;
            return Objects.equals(temp, realTime.temp) &&
                    Objects.equals(time, realTime.time) &&
                    Objects.equals(weather, realTime.weather) &&
                    Objects.equals(hum, realTime.hum) &&
                    Objects.equals(wd, realTime.wd) &&
                    Objects.equals(ws, realTime.ws) &&
                    Objects.equals(sunrise, realTime.sunrise) &&
                    Objects.equals(sunset, realTime.sunset);
        }

        @Override
        public int hashCode() {

            return Objects.hash(temp, time, weather, hum, wd, ws, sunrise, sunset);
        }

        @Override
        public String toString() {
            return "RealTime{" +
                    "temp='" + temp + '\'' +
                    ", time='" + time + '\'' +
                    ", weather='" + weather + '\'' +
                    ", hum='" + hum + '\'' +
                    ", wd='" + wd + '\'' +
                    ", ws='" + ws + '\'' +
                    '}';
        }

        public String getTemp() {
            return temp;
        }

        public RealTime setTemp(String temp) {
            this.temp = temp;
            return this;
        }

        public String getTime() {
            return time;
        }

        public RealTime setTime(String time) {
            this.time = time;
            return this;
        }

        public String getWeather() {
            return weather;
        }

        public RealTime setWeather(String weather) {
            this.weather = weather;
            return this;
        }

        public String getHum() {
            return hum;
        }

        public RealTime setHum(String hum) {
            this.hum = hum;
            return this;
        }

        public String getWd() {
            return wd;
        }

        public RealTime setWd(String wd) {
            this.wd = wd;
            return this;
        }

        public String getWs() {
            return ws;
        }

        public RealTime setWs(String ws) {
            this.ws = ws;
            return this;
        }

        public String getSunrise() {
            return sunrise;
        }

        public RealTime setSunrise(String sunrise) {
            this.sunrise = sunrise;
            return this;
        }

        public String getSunset() {
            return sunset;
        }

        public RealTime setSunset(String sunset) {
            this.sunset = sunset;
            return this;
        }

        @Override
        public int describeContents() {
            return 0;
        }
        public void readFromParcel(Parcel reply){
            this.temp = reply.readString();
            this.time = reply.readString();
            this.weather = reply.readString();
            this.hum = reply.readString();
            this.wd = reply.readString();
            this.ws = reply.readString();
            this.sunrise = reply.readString();
            this.sunset = reply.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.temp);
            dest.writeString(this.time);
            dest.writeString(this.weather);
            dest.writeString(this.hum);
            dest.writeString(this.wd);
            dest.writeString(this.ws);
            dest.writeString(this.sunrise);
            dest.writeString(this.sunset);
        }

        public RealTime() {
        }

        protected RealTime(Parcel in) {
            this.temp = in.readString();
            this.time = in.readString();
            this.weather = in.readString();
            this.hum = in.readString();
            this.wd = in.readString();
            this.ws = in.readString();
            this.sunrise = in.readString();
            this.sunset = in.readString();
        }

        public static final Creator<RealTime> CREATOR = new Creator<RealTime>() {
            @Override
            public RealTime createFromParcel(Parcel source) {
                return new RealTime(source);
            }

            @Override
            public RealTime[] newArray(int size) {
                return new RealTime[size];
            }
        };
    }

    public static class Aqi implements Parcelable {
        /*
         * so2 : 8
         * o3 : 22
         * co : 10
         * level : 0
         * color : 0
         * no2 : 13
         * aqi : 49
         * quality : 优
         * pm10 : 49
         * pm25 : 17
         * advice : 0
         * upDateTime : 2018-05-15 09:00:00
         */

        /** 二氧化硫 */
        private String so2;
        /** 臭氧 */
        private String o3;
        /** 一氧化碳 */
        private String co;
        /** 二氧化氮 */
        private String no2;
        /** 空气质量指数 */
        private String aqi;
        /** 空气质量 */
        private String quality;
        /** 可吸入颗粒物 */
        private String pm10;
        /** 细颗粒物 */
        private String pm25;
        /** 更新时间 */
        private String upDateTime;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Aqi aqi1 = (Aqi) o;
            return Objects.equals(so2, aqi1.so2) &&
                    Objects.equals(o3, aqi1.o3) &&
                    Objects.equals(co, aqi1.co) &&
                    Objects.equals(no2, aqi1.no2) &&
                    Objects.equals(aqi, aqi1.aqi) &&
                    Objects.equals(quality, aqi1.quality) &&
                    Objects.equals(pm10, aqi1.pm10) &&
                    Objects.equals(pm25, aqi1.pm25) &&
                    Objects.equals(upDateTime, aqi1.upDateTime);
        }

        @Override
        public int hashCode() {

            return Objects.hash(so2, o3, co, no2, aqi, quality, pm10, pm25, upDateTime);
        }

        @Override
        public String toString() {
            return "Aqi{" +
                    "so2='" + so2 + '\'' +
                    ", o3='" + o3 + '\'' +
                    ", co='" + co + '\'' +
                    ", no2='" + no2 + '\'' +
                    ", aqi='" + aqi + '\'' +
                    ", quality='" + quality + '\'' +
                    ", pm10='" + pm10 + '\'' +
                    ", pm25='" + pm25 + '\'' +
                    ", upDateTime='" + upDateTime + '\'' +
                    '}';
        }

        public String getSo2() {
            return so2;
        }

        public Aqi setSo2(String so2) {
            this.so2 = so2;
            return this;
        }

        public String getO3() {
            return o3;
        }

        public Aqi setO3(String o3) {
            this.o3 = o3;
            return this;
        }

        public String getCo() {
            return co;
        }

        public Aqi setCo(String co) {
            this.co = co;
            return this;
        }

        public String getNo2() {
            return no2;
        }

        public Aqi setNo2(String no2) {
            this.no2 = no2;
            return this;
        }

        public String getAqi() {
            return aqi;
        }

        public Aqi setAqi(String aqi) {
            this.aqi = aqi;
            return this;
        }

        public String getQuality() {
            return quality;
        }

        public Aqi setQuality(String quality) {
            this.quality = quality;
            return this;
        }

        public String getPm10() {
            return pm10;
        }

        public Aqi setPm10(String pm10) {
            this.pm10 = pm10;
            return this;
        }

        public String getPm25() {
            return pm25;
        }

        public Aqi setPm25(String pm25) {
            this.pm25 = pm25;
            return this;
        }

        public String getUpDateTime() {
            return upDateTime;
        }

        public Aqi setUpDateTime(String upDateTime) {
            this.upDateTime = upDateTime;
            return this;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel reply){
            this.so2 = reply.readString();
            this.o3 = reply.readString();
            this.co = reply.readString();
            this.no2 = reply.readString();
            this.aqi = reply.readString();
            this.quality = reply.readString();
            this.pm10 = reply.readString();
            this.pm25 = reply.readString();
            this.upDateTime = reply.readString();
        }
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.so2);
            dest.writeString(this.o3);
            dest.writeString(this.co);
            dest.writeString(this.no2);
            dest.writeString(this.aqi);
            dest.writeString(this.quality);
            dest.writeString(this.pm10);
            dest.writeString(this.pm25);
            dest.writeString(this.upDateTime);
        }

        public Aqi() {
        }

        protected Aqi(Parcel in) {
            this.so2 = in.readString();
            this.o3 = in.readString();
            this.co = in.readString();
            this.no2 = in.readString();
            this.aqi = in.readString();
            this.quality = in.readString();
            this.pm10 = in.readString();
            this.pm25 = in.readString();
            this.upDateTime = in.readString();
        }

        public static final Creator<Aqi> CREATOR = new Creator<Aqi>() {
            @Override
            public Aqi createFromParcel(Parcel source) {
                return new Aqi(source);
            }

            @Override
            public Aqi[] newArray(int size) {
                return new Aqi[size];
            }
        };
    }

    public static class Forecast implements Parcelable {
        /*
         * date : 2018-5-14
         * week : 星期一
         * sunrise : 05:45
         * high : 高温 32.0℃
         * low : 低温 26.0℃
         * sunset : 18:56
         * wd : 南风
         * ws : <3级
         * weather : 多云
         * notice : 阴晴之间，谨防紫外线侵扰
         */
        /** 时间 */
        private String date;
        /** 星期 */
        private String week;
        /** 天气 */
        private String weather;
        /** 天气img 编号 */
        private String img;
        /** 风向 */
        private String wd;
        /** 风力 */
        private String ws;
        /** 日出时间 */
        private String sunrise;
        /** 日落时间 */
        private String sunset;
        /** 最高温 */
        private String high;
        /** 最低温 */
        private String low;
        /** 注意提示 */
        private String notice;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Forecast forecast = (Forecast) o;
            return Objects.equals(date, forecast.date) &&
                    Objects.equals(week, forecast.week) &&
                    Objects.equals(weather, forecast.weather) &&
                    Objects.equals(img, forecast.img) &&
                    Objects.equals(wd, forecast.wd) &&
                    Objects.equals(ws, forecast.ws) &&
                    Objects.equals(sunrise, forecast.sunrise) &&
                    Objects.equals(sunset, forecast.sunset) &&
                    Objects.equals(high, forecast.high) &&
                    Objects.equals(low, forecast.low) &&
                    Objects.equals(notice, forecast.notice);
        }

        @Override
        public int hashCode() {

            return Objects.hash(date, week, weather, img, wd, ws, sunrise, sunset, high, low, notice);
        }

        @Override
        public String toString() {
            return "Forecast{" +
                    "date='" + date + '\'' +
                    ", week='" + week + '\'' +
                    ", sunrise='" + sunrise + '\'' +
                    ", sunset='" + sunset + '\'' +
                    ", high='" + high + '\'' +
                    ", low='" + low + '\'' +
                    ", wd='" + wd + '\'' +
                    ", ws='" + ws + '\'' +
                    ", weather='" + weather + '\'' +
                    ", notice='" + notice + '\'' +
                    '}';
        }

        public String getDate() {
            return date;
        }

        public Forecast setDate(String date) {
            this.date = date;
            return this;
        }

        public String getSunrise() {
            return sunrise;
        }

        public Forecast setSunrise(String sunrise) {
            this.sunrise = sunrise;
            return this;
        }

        public String getHigh() {
            return high;
        }

        public Forecast setHigh(String high) {
            this.high = high;
            return this;
        }

        public String getLow() {
            return low;
        }

        public Forecast setLow(String low) {
            this.low = low;
            return this;
        }

        public String getSunset() {
            return sunset;
        }

        public Forecast setSunset(String sunset) {
            this.sunset = sunset;
            return this;
        }

        public String getWeek() {
            return week;
        }

        public Forecast setWeek(String week) {
            this.week = week;
            return this;
        }

        public String getWeather() {
            return weather;
        }

        public Forecast setWeather(String weather) {
            this.weather = weather;
            return this;
        }

        public String getImg() {
            return img;
        }

        public Forecast setImg(String img) {
            this.img = img;
            return this;
        }

        public String getWd() {
            return wd;
        }

        public Forecast setWd(String wd) {
            this.wd = wd;
            return this;
        }

        public String getWs() {
            return ws;
        }

        public Forecast setWs(String ws) {
            this.ws = ws;
            return this;
        }

        public String getNotice() {
            return notice;
        }

        public Forecast setNotice(String notice) {
            this.notice = notice;
            return this;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel reply){
            this.date = reply.readString();
            this.week = reply.readString();
            this.weather = reply.readString();
            this.img = reply.readString();
            this.wd = reply.readString();
            this.ws = reply.readString();
            this.sunrise = reply.readString();
            this.sunset = reply.readString();
            this.high = reply.readString();
            this.low = reply.readString();
            this.notice = reply.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.date);
            dest.writeString(this.week);
            dest.writeString(this.weather);
            dest.writeString(this.img);
            dest.writeString(this.wd);
            dest.writeString(this.ws);
            dest.writeString(this.sunrise);
            dest.writeString(this.sunset);
            dest.writeString(this.high);
            dest.writeString(this.low);
            dest.writeString(this.notice);
        }

        public Forecast() {
        }

        protected Forecast(Parcel in) {
            this.date = in.readString();
            this.week = in.readString();
            this.weather = in.readString();
            this.img = in.readString();
            this.wd = in.readString();
            this.ws = in.readString();
            this.sunrise = in.readString();
            this.sunset = in.readString();
            this.high = in.readString();
            this.low = in.readString();
            this.notice = in.readString();
        }

        public static final Creator<Forecast> CREATOR = new Creator<Forecast>() {
            @Override
            public Forecast createFromParcel(Parcel source) {
                return new Forecast(source);
            }

            @Override
            public Forecast[] newArray(int size) {
                return new Forecast[size];
            }
        };
    }

    public static class LifeIndex implements Parcelable {
        /*
         * name : 防晒
         * level : 弱
         * content : 属弱紫外辐射天气，长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。
         */
        /** 生活指数名称 */
        private String name;
        /** 生活指数等级 */
        private String level;
        /** 生活指数内容 */
        private String content;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            LifeIndex lifeIndex = (LifeIndex) o;
            return Objects.equals(name, lifeIndex.name) &&
                    Objects.equals(level, lifeIndex.level) &&
                    Objects.equals(content, lifeIndex.content);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name, level, content);
        }

        @Override
        public String toString() {
            return "LifeIndex{" +
                    "name='" + name + '\'' +
                    ", level='" + level + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }

        public LifeIndex setName(String name) {
            this.name = name;
            return this;
        }

        public LifeIndex setLevel(String level) {
            this.level = level;
            return this;
        }

        public LifeIndex setContent(String content) {
            this.content = content;
            return this;
        }

        public String getName() {
            return name;
        }

        public String getLevel() {
            return level;
        }

        public String getContent() {
            return content;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel reply){
            this.name = reply.readString();
            this.level = reply.readString();
            this.content = reply.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name);
            dest.writeString(this.level);
            dest.writeString(this.content);
        }

        public LifeIndex() {
        }

        protected LifeIndex(Parcel in) {
            this.name = in.readString();
            this.level = in.readString();
            this.content = in.readString();
        }

        public static final Creator<LifeIndex> CREATOR = new Creator<LifeIndex>() {
            @Override
            public LifeIndex createFromParcel(Parcel source) {
                return new LifeIndex(source);
            }

            @Override
            public LifeIndex[] newArray(int size) {
                return new LifeIndex[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public void readFromParcel(Parcel reply) {
        this.city = reply.readString();
        this.forecasts = new ArrayList<Forecast>();
        reply.readList(this.forecasts, List.class.getClassLoader());
        this.alarms = new ArrayList<Alarms>();
        reply.readList(this.alarms, List.class.getClassLoader());
        this.yesterday = reply.readParcelable(Yesterday.class.getClassLoader());
        this.realTime = reply.readParcelable(RealTime.class.getClassLoader());
        this.aqi = reply.readParcelable(Aqi.class.getClassLoader());
        this.lifeIndex = new ArrayList<LifeIndex>();
        reply.readList(this.lifeIndex, List.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.city);
        dest.writeList(this.forecasts);
        dest.writeList(this.alarms);
        dest.writeParcelable(this.yesterday, flags);
        dest.writeParcelable(this.realTime, flags);
        dest.writeParcelable(this.aqi, flags);
        dest.writeList(this.lifeIndex);
    }


    public Weather() {
    }

    protected Weather(Parcel in) {
        this.city = in.readString();
        this.forecasts = new ArrayList<Forecast>();
        in.readList(this.forecasts, Forecast.class.getClassLoader());
        this.alarms = new ArrayList<Alarms>();
        in.readList(this.alarms, Alarms.class.getClassLoader());
        this.yesterday = in.readParcelable(Yesterday.class.getClassLoader());
        this.realTime = in.readParcelable(RealTime.class.getClassLoader());
        this.aqi = in.readParcelable(Aqi.class.getClassLoader());
        this.lifeIndex = new ArrayList<LifeIndex>();
        in.readList(this.lifeIndex, LifeIndex.class.getClassLoader());
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel source) {
            return new Weather(source);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };
}

