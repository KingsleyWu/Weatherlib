package com.joywe.weatherlib.model.weather.sojson;

import java.util.List;

public class SoJsonWeather {

    /**
     * date : 20180514
     * message : Success !
     * status : 200
     * city : 深圳
     * count : 1957
     * data : {"shidu":"89%","pm25":15,"pm10":28,"quality":"优","wendu":"27","ganmao":"各类人群可自由活动","yesterday":{"date":"13日星期日","sunrise":"05:45","high":"高温 32.0℃","low":"低温 25.0℃","sunset":"18:56","aqi":34,"fx":"南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},"forecast":[{"date":"14日星期一","sunrise":"05:45","high":"高温 32.0℃","low":"低温 26.0℃","sunset":"18:56","aqi":24,"fx":"南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"15日星期二","sunrise":"05:44","high":"高温 33.0℃","low":"低温 26.0℃","sunset":"18:56","aqi":22,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"16日星期三","sunrise":"05:44","high":"高温 32.0℃","low":"低温 26.0℃","sunset":"18:57","aqi":20,"fx":"无持续风向","fl":"<3级","type":"阵雨","notice":"阵雨来袭，出门记得带伞"},{"date":"17日星期四","sunrise":"05:44","high":"高温 32.0℃","low":"低温 26.0℃","sunset":"18:57","aqi":20,"fx":"无持续风向","fl":"<3级","type":"阵雨","notice":"阵雨来袭，出门记得带伞"},{"date":"18日星期五","sunrise":"05:43","high":"高温 32.0℃","low":"低温 26.0℃","sunset":"18:58","aqi":21,"fx":"无持续风向","fl":"<3级","type":"阵雨","notice":"阵雨来袭，出门记得带伞"}]}
     */

    private String date;
    private String message;
    private String status;
    private String city;
    private String count;
    private DataBean data;

    @Override
    public String toString() {
        return "SoJsonWeather{" +
                "date='" + date + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", city='" + city + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * shidu : 89%
         * pm25 : 15.0
         * pm10 : 28.0
         * quality : 优
         * wendu : 27
         * ganmao : 各类人群可自由活动
         * yesterday : {"date":"13日星期日","sunrise":"05:45","high":"高温 32.0℃","low":"低温 25.0℃","sunset":"18:56","aqi":34,"fx":"南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}
         * forecast : [{"date":"14日星期一","sunrise":"05:45","high":"高温 32.0℃","low":"低温 26.0℃","sunset":"18:56","aqi":24,"fx":"南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"15日星期二","sunrise":"05:44","high":"高温 33.0℃","low":"低温 26.0℃","sunset":"18:56","aqi":22,"fx":"无持续风向","fl":"<3级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"16日星期三","sunrise":"05:44","high":"高温 32.0℃","low":"低温 26.0℃","sunset":"18:57","aqi":20,"fx":"无持续风向","fl":"<3级","type":"阵雨","notice":"阵雨来袭，出门记得带伞"},{"date":"17日星期四","sunrise":"05:44","high":"高温 32.0℃","low":"低温 26.0℃","sunset":"18:57","aqi":20,"fx":"无持续风向","fl":"<3级","type":"阵雨","notice":"阵雨来袭，出门记得带伞"},{"date":"18日星期五","sunrise":"05:43","high":"高温 32.0℃","low":"低温 26.0℃","sunset":"18:58","aqi":21,"fx":"无持续风向","fl":"<3级","type":"阵雨","notice":"阵雨来袭，出门记得带伞"}]
         */

        private String shidu;
        private String pm25;
        private String pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private List<ForecastBean> forecast;

        @Override
        public String toString() {
            return "DataBean{" +
                    "shidu='" + shidu + '\'' +
                    ", pm25=" + pm25 +
                    ", pm10=" + pm10 +
                    ", quality='" + quality + '\'' +
                    ", wendu='" + wendu + '\'' +
                    ", ganmao='" + ganmao + '\'' +
                    ", yesterday=" + yesterday +
                    ", forecast=" + forecast +
                    '}';
        }

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public String getPm10() {
            return pm10;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 13日星期日
             * sunrise : 05:45
             * high : 高温 32.0℃
             * low : 低温 25.0℃
             * sunset : 18:56
             * aqi : 34.0
             * fx : 南风
             * fl : <3级
             * type : 多云
             * notice : 阴晴之间，谨防紫外线侵扰
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            @Override
            public String toString() {
                return "YesterdayBean{" +
                        "date='" + date + '\'' +
                        ", sunrise='" + sunrise + '\'' +
                        ", high='" + high + '\'' +
                        ", low='" + low + '\'' +
                        ", sunset='" + sunset + '\'' +
                        ", aqi=" + aqi +
                        ", fx='" + fx + '\'' +
                        ", fl='" + fl + '\'' +
                        ", type='" + type + '\'' +
                        ", notice='" + notice + '\'' +
                        '}';
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class ForecastBean {
            /**
             * date : 14日星期一
             * sunrise : 05:45
             * high : 高温 32.0℃
             * low : 低温 26.0℃
             * sunset : 18:56
             * aqi : 24.0
             * fx : 南风
             * fl : <3级
             * type : 多云
             * notice : 阴晴之间，谨防紫外线侵扰
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private String aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            @Override
            public String toString() {
                return "ForecastBean{" +
                        "date='" + date + '\'' +
                        ", sunrise='" + sunrise + '\'' +
                        ", high='" + high + '\'' +
                        ", low='" + low + '\'' +
                        ", sunset='" + sunset + '\'' +
                        ", aqi=" + aqi +
                        ", fx='" + fx + '\'' +
                        ", fl='" + fl + '\'' +
                        ", type='" + type + '\'' +
                        ", notice='" + notice + '\'' +
                        '}';
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
