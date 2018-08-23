package com.joywe.weatherlib.model.weather.wthrcdn;

import java.util.List;

public class WthrcdnWeather {

    /**
     * data : {"yesterday":{"date":"16日星期三","high":"高温 28℃","fx":"东南风","low":"低温 21℃","fl":"<![CDATA[<3级]]>","type":"多云"},"city":"北京","aqi":"85","forecast":[{"date":"17日星期四","high":"高温 25℃","fengli":"<![CDATA[<3级]]>","low":"低温 19℃","fengxiang":"东北风","type":"小雨"},{"date":"18日星期五","high":"高温 28℃","fengli":"<![CDATA[<3级]]>","low":"低温 17℃","fengxiang":"南风","type":"多云"},{"date":"19日星期六","high":"高温 28℃","fengli":"<![CDATA[<3级]]>","low":"低温 16℃","fengxiang":"东南风","type":"多云"},{"date":"20日星期天","high":"高温 24℃","fengli":"<![CDATA[<3级]]>","low":"低温 16℃","fengxiang":"东风","type":"多云"},{"date":"21日星期一","high":"高温 25℃","fengli":"<![CDATA[<3级]]>","low":"低温 17℃","fengxiang":"南风","type":"多云"}],"ganmao":"相对今天出现了较大幅度降温，较易发生感冒，体质较弱的朋友请注意适当防护。","wendu":"21"}
     * status : 1000
     * desc : OK
     */

    private DataBean data;
    private String status;
    private String desc;

    public void setData(DataBean data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DataBean getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public static class DataBean {
        /**
         * yesterday : {"date":"16日星期三","high":"高温 28℃","fx":"东南风","low":"低温 21℃","fl":"<![CDATA[<3级]]>","type":"多云"}
         * city : 北京
         * aqi : 85
         * forecast : [{"date":"17日星期四","high":"高温 25℃","fengli":"<![CDATA[<3级]]>","low":"低温 19℃","fengxiang":"东北风","type":"小雨"},
         * {"date":"18日星期五","high":"高温 28℃","fengli":"<![CDATA[<3级]]>","low":"低温 17℃","fengxiang":"南风","type":"多云"},
         * {"date":"19日星期六","high":"高温 28℃","fengli":"<![CDATA[<3级]]>","low":"低温 16℃","fengxiang":"东南风","type":"多云"},
         * {"date":"20日星期天","high":"高温 24℃","fengli":"<![CDATA[<3级]]>","low":"低温 16℃","fengxiang":"东风","type":"多云"},
         * {"date":"21日星期一","high":"高温 25℃","fengli":"<![CDATA[<3级]]>","low":"低温 17℃","fengxiang":"南风","type":"多云"}]
         * ganmao : 相对今天出现了较大幅度降温，较易发生感冒，体质较弱的朋友请注意适当防护。
         * wendu : 21
         */

        private YesterdayBean yesterday;
        private String city;
        private String aqi;
        private String ganmao;
        private String wendu;
        private List<ForecastBean> forecast;

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public String getCity() {
            return city;
        }

        public String getAqi() {
            return aqi;
        }

        public String getGanmao() {
            return ganmao;
        }

        public String getWendu() {
            return wendu;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 16日星期三
             * high : 高温 28℃
             * fx : 东南风
             * low : 低温 21℃
             * fl : <![CDATA[<3级]]>
             * type : 多云
             */

            private String date;
            private String high;
            private String fx;
            private String low;
            private String fl;
            private String type;

            public void setDate(String date) {
                this.date = date;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDate() {
                return date;
            }

            public String getHigh() {
                return high;
            }

            public String getFx() {
                return fx;
            }

            public String getLow() {
                return low;
            }

            public String getFl() {
                return fl;
            }

            public String getType() {
                return type;
            }
        }

        public static class ForecastBean {
            /**
             * date : 17日星期四
             * high : 高温 25℃
             * fengli : <![CDATA[<3级]]>
             * low : 低温 19℃
             * fengxiang : 东北风
             * type : 小雨
             */

            private String date;
            private String high;
            private String fengli;
            private String low;
            private String fengxiang;
            private String type;

            public void setDate(String date) {
                this.date = date;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDate() {
                return date;
            }

            public String getHigh() {
                return high;
            }

            public String getFengli() {
                return fengli;
            }

            public String getLow() {
                return low;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public String getType() {
                return type;
            }
        }
    }
}
