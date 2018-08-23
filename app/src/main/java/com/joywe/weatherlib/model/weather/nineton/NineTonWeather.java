package com.joywe.weatherlib.model.weather.nineton;

import java.util.List;

/**
 * 中央天气预报
    url：http://tj.nineton.cn/Heart/index/all
    拼接参数：
    city：城市码
    language：固定值 zh-chs
    unit：温度单位固定值 c。可不填。也可省略该参数
    aqi：固定值 city。可不填。也可省略该参数
    alarm：固定值 1。可不填。也可省略该参数
    key：秘钥，固定值 78928e706123c1a8f1766f062bc8676b。可不填。也可省略该参数
    url 示例：http://tj.nineton.cn/Heart/index/all?city=CHSH000000&language=zh-chs&unit=c&aqi=city&alarm=1&key=78928e706123c1a8f1766f062bc8676b
    或 http://tj.nineton.cn/Heart/index/all?city=CHSH000000&language=&unit=&aqi=&alarm=&key= 或 http://tj.nineton.cn/Heart/index/all?city=CHSH000000
 */

public class NineTonWeather {

    /**
     * status : OK
     * weather : [{"city_name":"上海","city_id":"CHSH000000","last_update":"2018-05-11T08:49:00+08:00","now":{"text":"多云","code":"4","temperature":"20","feels_like":"20","wind_direction":"北","wind_speed":"3.60","wind_scale":"1","humidity":"62","visibility":"18.20","pressure":"1017","pressure_rising":"未知","air_quality":{"city":{"aqi":"47","pm25":"17","pm10":"47","so2":"8","no2":"29","co":"0.430","o3":"95","last_update":"2018-05-11T08:00:00+08:00","quality":"优"},"stations":null},"alarms":[]},"today":{"sunrise":"05:02 AM","sunset":"06:40 PM","suggestion":{"dressing":{"brief":"舒适","details":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"},"uv":{"brief":"弱","details":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"},"car_washing":{"brief":"较适宜","details":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"travel":{"brief":"适宜","details":"天气较好，温度适宜，但风稍微有点大。这样的天气适宜旅游，您可以尽情地享受大自然的无限风光。"},"flu":{"brief":"较易发","details":"虽然温度适宜但风力较大，仍较易发生感冒，体质较弱的朋友请注意适当防护。"},"sport":{"brief":"较适宜","details":"天气较好，但因风力稍强，户外可选择对风力要求不高的运动，推荐您进行室内运动。"}}},"future":[{"date":"2018-05-11","high":"26","low":"16","day":"周五","text":"多云/小雨","code1":"4","code2":"13","cop":"","wind":"风力3级"},{"date":"2018-05-12","high":"28","low":"21","day":"周六","text":"小雨/小雨","code1":"13","code2":"13","cop":"","wind":"风力4级"},{"date":"2018-05-13","high":"29","low":"22","day":"周日","text":"多云/阴","code1":"4","code2":"9","cop":"","wind":"风力2级"},{"date":"2018-05-14","high":"30","low":"23","day":"周一","text":"阴/多云","code1":"9","code2":"4","cop":"","wind":"风力3级"},{"date":"2018-05-15","high":"32","low":"24","day":"周二","text":"多云/多云","code1":"4","code2":"4","cop":"","wind":"风力3级"},{"date":"2018-05-16","high":"32","low":"24","day":"周三","text":"阵雨/小雨","code1":"10","code2":"13","cop":"","wind":"风力3级"},{"date":"2018-05-17","high":"28","low":"22","day":"周四","text":"小雨/小雨","code1":"13","code2":"13","cop":"","wind":"风力3级"},{"date":"2018-05-18","high":"30","low":"19","day":"周五","text":"阴/阴","code1":"9","code2":"9","cop":"","wind":"风力3级"},{"date":"2018-05-19","high":"27","low":"17","day":"周六","text":"阴/小雨","code1":"9","code2":"13","cop":"","wind":"风力3级"},{"date":"2018-05-20","high":"30","low":"19","day":"周日","text":"多云/多云","code1":"4","code2":"4","cop":"","wind":"风力2级"}]}]
     */

    private String status;
    private List<WeatherBean> weather;

    @Override
    public String toString() {
        return "NineTonWeather{" +
                "status='" + status + '\'' +
                ", weather=" + weather +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<WeatherBean> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherBean> weather) {
        this.weather = weather;
    }

    public static class WeatherBean {
        /**
         * city_name : 上海
         * city_id : CHSH000000
         * last_update : 2018-05-11T08:49:00+08:00
         * now : {"text":"多云","code":"4","temperature":"20","feels_like":"20","wind_direction":"北","wind_speed":"3.60","wind_scale":"1","humidity":"62","visibility":"18.20","pressure":"1017","pressure_rising":"未知","air_quality":{"city":{"aqi":"47","pm25":"17","pm10":"47","so2":"8","no2":"29","co":"0.430","o3":"95","last_update":"2018-05-11T08:00:00+08:00","quality":"优"},"stations":null},"alarms":[]}
         * today : {"sunrise":"05:02 AM","sunset":"06:40 PM","suggestion":{"dressing":{"brief":"舒适","details":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"},"uv":{"brief":"弱","details":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"},"car_washing":{"brief":"较适宜","details":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"travel":{"brief":"适宜","details":"天气较好，温度适宜，但风稍微有点大。这样的天气适宜旅游，您可以尽情地享受大自然的无限风光。"},"flu":{"brief":"较易发","details":"虽然温度适宜但风力较大，仍较易发生感冒，体质较弱的朋友请注意适当防护。"},"sport":{"brief":"较适宜","details":"天气较好，但因风力稍强，户外可选择对风力要求不高的运动，推荐您进行室内运动。"}}}
         * future : [{"date":"2018-05-11","high":"26","low":"16","day":"周五","text":"多云/小雨","code1":"4","code2":"13","cop":"","wind":"风力3级"},{"date":"2018-05-12","high":"28","low":"21","day":"周六","text":"小雨/小雨","code1":"13","code2":"13","cop":"","wind":"风力4级"},{"date":"2018-05-13","high":"29","low":"22","day":"周日","text":"多云/阴","code1":"4","code2":"9","cop":"","wind":"风力2级"},{"date":"2018-05-14","high":"30","low":"23","day":"周一","text":"阴/多云","code1":"9","code2":"4","cop":"","wind":"风力3级"},{"date":"2018-05-15","high":"32","low":"24","day":"周二","text":"多云/多云","code1":"4","code2":"4","cop":"","wind":"风力3级"},{"date":"2018-05-16","high":"32","low":"24","day":"周三","text":"阵雨/小雨","code1":"10","code2":"13","cop":"","wind":"风力3级"},{"date":"2018-05-17","high":"28","low":"22","day":"周四","text":"小雨/小雨","code1":"13","code2":"13","cop":"","wind":"风力3级"},{"date":"2018-05-18","high":"30","low":"19","day":"周五","text":"阴/阴","code1":"9","code2":"9","cop":"","wind":"风力3级"},{"date":"2018-05-19","high":"27","low":"17","day":"周六","text":"阴/小雨","code1":"9","code2":"13","cop":"","wind":"风力3级"},{"date":"2018-05-20","high":"30","low":"19","day":"周日","text":"多云/多云","code1":"4","code2":"4","cop":"","wind":"风力2级"}]
         */

        private String city_name;
        private String city_id;
        private String last_update;
        private NowBean now;
        private TodayBean today;
        private List<FutureBean> future;

        @Override
        public String toString() {
            return "WeatherBean{" +
                    "city_name='" + city_name + '\'' +
                    ", city_id='" + city_id + '\'' +
                    ", last_update='" + last_update + '\'' +
                    ", now=" + now +
                    ", today=" + today +
                    ", future=" + future +
                    '}';
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getLast_update() {
            return last_update;
        }

        public void setLast_update(String last_update) {
            this.last_update = last_update;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public TodayBean getToday() {
            return today;
        }

        public void setToday(TodayBean today) {
            this.today = today;
        }

        public List<FutureBean> getFuture() {
            return future;
        }

        public void setFuture(List<FutureBean> future) {
            this.future = future;
        }

        public static class NowBean {
            /**
             * text : 多云
             * code : 4
             * temperature : 20
             * feels_like : 20
             * wind_direction : 北
             * wind_speed : 3.60
             * wind_scale : 1
             * humidity : 62
             * visibility : 18.20
             * pressure : 1017
             * pressure_rising : 未知
             * air_quality : {"city":{"aqi":"47","pm25":"17","pm10":"47","so2":"8","no2":"29","co":"0.430","o3":"95","last_update":"2018-05-11T08:00:00+08:00","quality":"优"},"stations":null}
             * alarms : []
             */

            private String text;
            private String code;
            private String temperature;
            private String feels_like;
            private String wind_direction;
            private String wind_speed;
            private String wind_scale;
            private String humidity;
            private String visibility;
            private String pressure;
            private String pressure_rising;
            private AirQualityBean air_quality;
            private List<?> alarms;

            @Override
            public String toString() {
                return "NowBean{" +
                        "text='" + text + '\'' +
                        ", code='" + code + '\'' +
                        ", temperature='" + temperature + '\'' +
                        ", feels_like='" + feels_like + '\'' +
                        ", wind_direction='" + wind_direction + '\'' +
                        ", wind_speed='" + wind_speed + '\'' +
                        ", wind_scale='" + wind_scale + '\'' +
                        ", humidity='" + humidity + '\'' +
                        ", visibility='" + visibility + '\'' +
                        ", pressure='" + pressure + '\'' +
                        ", pressure_rising='" + pressure_rising + '\'' +
                        ", air_quality=" + air_quality +
                        ", alarms=" + alarms +
                        '}';
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getFeels_like() {
                return feels_like;
            }

            public void setFeels_like(String feels_like) {
                this.feels_like = feels_like;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getWind_speed() {
                return wind_speed;
            }

            public void setWind_speed(String wind_speed) {
                this.wind_speed = wind_speed;
            }

            public String getWind_scale() {
                return wind_scale;
            }

            public void setWind_scale(String wind_scale) {
                this.wind_scale = wind_scale;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getVisibility() {
                return visibility;
            }

            public void setVisibility(String visibility) {
                this.visibility = visibility;
            }

            public String getPressure() {
                return pressure;
            }

            public void setPressure(String pressure) {
                this.pressure = pressure;
            }

            public String getPressure_rising() {
                return pressure_rising;
            }

            public void setPressure_rising(String pressure_rising) {
                this.pressure_rising = pressure_rising;
            }

            public AirQualityBean getAir_quality() {
                return air_quality;
            }

            public void setAir_quality(AirQualityBean air_quality) {
                this.air_quality = air_quality;
            }

            public List<?> getAlarms() {
                return alarms;
            }

            public void setAlarms(List<?> alarms) {
                this.alarms = alarms;
            }

            public static class AirQualityBean {
                /**
                 * city : {"aqi":"47","pm25":"17","pm10":"47","so2":"8","no2":"29","co":"0.430","o3":"95","last_update":"2018-05-11T08:00:00+08:00","quality":"优"}
                 * stations : null
                 */

                private CityBean city;
                private Object stations;

                @Override
                public String toString() {
                    return "AirQualityBean{" +
                            "city=" + city +
                            ", stations=" + stations +
                            '}';
                }

                public CityBean getCity() {
                    return city;
                }

                public void setCity(CityBean city) {
                    this.city = city;
                }

                public Object getStations() {
                    return stations;
                }

                public void setStations(Object stations) {
                    this.stations = stations;
                }

                public static class CityBean {
                    /**
                     * aqi : 47
                     * pm25 : 17
                     * pm10 : 47
                     * so2 : 8
                     * no2 : 29
                     * co : 0.430
                     * o3 : 95
                     * last_update : 2018-05-11T08:00:00+08:00
                     * quality : 优
                     */

                    private String aqi;
                    private String pm25;
                    private String pm10;
                    private String so2;
                    private String no2;
                    private String co;
                    private String o3;
                    private String last_update;
                    private String quality;

                    @Override
                    public String toString() {
                        return "CityBean{" +
                                "aqi='" + aqi + '\'' +
                                ", pm25='" + pm25 + '\'' +
                                ", pm10='" + pm10 + '\'' +
                                ", so2='" + so2 + '\'' +
                                ", no2='" + no2 + '\'' +
                                ", co='" + co + '\'' +
                                ", o3='" + o3 + '\'' +
                                ", last_update='" + last_update + '\'' +
                                ", quality='" + quality + '\'' +
                                '}';
                    }

                    public String getAqi() {
                        return aqi;
                    }

                    public void setAqi(String aqi) {
                        this.aqi = aqi;
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

                    public String getSo2() {
                        return so2;
                    }

                    public void setSo2(String so2) {
                        this.so2 = so2;
                    }

                    public String getNo2() {
                        return no2;
                    }

                    public void setNo2(String no2) {
                        this.no2 = no2;
                    }

                    public String getCo() {
                        return co;
                    }

                    public void setCo(String co) {
                        this.co = co;
                    }

                    public String getO3() {
                        return o3;
                    }

                    public void setO3(String o3) {
                        this.o3 = o3;
                    }

                    public String getLast_update() {
                        return last_update;
                    }

                    public void setLast_update(String last_update) {
                        this.last_update = last_update;
                    }

                    public String getQuality() {
                        return quality;
                    }

                    public void setQuality(String quality) {
                        this.quality = quality;
                    }
                }
            }
        }

        public static class TodayBean {
            /**
             * sunrise : 05:02 AM
             * sunset : 06:40 PM
             * suggestion : {"dressing":{"brief":"舒适","details":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"},"uv":{"brief":"弱","details":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"},"car_washing":{"brief":"较适宜","details":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"travel":{"brief":"适宜","details":"天气较好，温度适宜，但风稍微有点大。这样的天气适宜旅游，您可以尽情地享受大自然的无限风光。"},"flu":{"brief":"较易发","details":"虽然温度适宜但风力较大，仍较易发生感冒，体质较弱的朋友请注意适当防护。"},"sport":{"brief":"较适宜","details":"天气较好，但因风力稍强，户外可选择对风力要求不高的运动，推荐您进行室内运动。"}}
             */

            private String sunrise;
            private String sunset;
            private SuggestionBean suggestion;

            @Override
            public String toString() {
                return "TodayBean{" +
                        "sunrise='" + sunrise + '\'' +
                        ", sunset='" + sunset + '\'' +
                        ", suggestion=" + suggestion +
                        '}';
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public SuggestionBean getSuggestion() {
                return suggestion;
            }

            public void setSuggestion(SuggestionBean suggestion) {
                this.suggestion = suggestion;
            }

            public static class SuggestionBean {
                /**
                 * dressing : {"brief":"舒适","details":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。"}
                 * uv : {"brief":"弱","details":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}
                 * car_washing : {"brief":"较适宜","details":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
                 * travel : {"brief":"适宜","details":"天气较好，温度适宜，但风稍微有点大。这样的天气适宜旅游，您可以尽情地享受大自然的无限风光。"}
                 * flu : {"brief":"较易发","details":"虽然温度适宜但风力较大，仍较易发生感冒，体质较弱的朋友请注意适当防护。"}
                 * sport : {"brief":"较适宜","details":"天气较好，但因风力稍强，户外可选择对风力要求不高的运动，推荐您进行室内运动。"}
                 */

                private DressingBean dressing;
                private UvBean uv;
                private CarWashingBean car_washing;
                private TravelBean travel;
                private FluBean flu;
                private SportBean sport;

                @Override
                public String toString() {
                    return "SuggestionBean{" +
                            "dressing=" + dressing +
                            ", uv=" + uv +
                            ", car_washing=" + car_washing +
                            ", travel=" + travel +
                            ", flu=" + flu +
                            ", sport=" + sport +
                            '}';
                }

                public DressingBean getDressing() {
                    return dressing;
                }

                public void setDressing(DressingBean dressing) {
                    this.dressing = dressing;
                }

                public UvBean getUv() {
                    return uv;
                }

                public void setUv(UvBean uv) {
                    this.uv = uv;
                }

                public CarWashingBean getCar_washing() {
                    return car_washing;
                }

                public void setCar_washing(CarWashingBean car_washing) {
                    this.car_washing = car_washing;
                }

                public TravelBean getTravel() {
                    return travel;
                }

                public void setTravel(TravelBean travel) {
                    this.travel = travel;
                }

                public FluBean getFlu() {
                    return flu;
                }

                public void setFlu(FluBean flu) {
                    this.flu = flu;
                }

                public SportBean getSport() {
                    return sport;
                }

                public void setSport(SportBean sport) {
                    this.sport = sport;
                }

                public static class DressingBean {
                    /**
                     * brief : 舒适
                     * details : 建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。
                     */

                    private String brief;
                    private String details;

                    @Override
                    public String toString() {
                        return "DressingBean{" +
                                "brief='" + brief + '\'' +
                                ", details='" + details + '\'' +
                                '}';
                    }

                    public String getBrief() {
                        return brief;
                    }

                    public void setBrief(String brief) {
                        this.brief = brief;
                    }

                    public String getDetails() {
                        return details;
                    }

                    public void setDetails(String details) {
                        this.details = details;
                    }
                }

                public static class UvBean {
                    /**
                     * brief : 弱
                     * details : 紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。
                     */

                    private String brief;
                    private String details;

                    @Override
                    public String toString() {
                        return "UvBean{" +
                                "brief='" + brief + '\'' +
                                ", details='" + details + '\'' +
                                '}';
                    }

                    public String getBrief() {
                        return brief;
                    }

                    public void setBrief(String brief) {
                        this.brief = brief;
                    }

                    public String getDetails() {
                        return details;
                    }

                    public void setDetails(String details) {
                        this.details = details;
                    }
                }

                public static class CarWashingBean {
                    /**
                     * brief : 较适宜
                     * details : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
                     */

                    private String brief;
                    private String details;

                    @Override
                    public String toString() {
                        return "CarWashingBean{" +
                                "brief='" + brief + '\'' +
                                ", details='" + details + '\'' +
                                '}';
                    }

                    public String getBrief() {
                        return brief;
                    }

                    public void setBrief(String brief) {
                        this.brief = brief;
                    }

                    public String getDetails() {
                        return details;
                    }

                    public void setDetails(String details) {
                        this.details = details;
                    }
                }

                public static class TravelBean {
                    /**
                     * brief : 适宜
                     * details : 天气较好，温度适宜，但风稍微有点大。这样的天气适宜旅游，您可以尽情地享受大自然的无限风光。
                     */

                    private String brief;
                    private String details;

                    @Override
                    public String toString() {
                        return "TravelBean{" +
                                "brief='" + brief + '\'' +
                                ", details='" + details + '\'' +
                                '}';
                    }

                    public String getBrief() {
                        return brief;
                    }

                    public void setBrief(String brief) {
                        this.brief = brief;
                    }

                    public String getDetails() {
                        return details;
                    }

                    public void setDetails(String details) {
                        this.details = details;
                    }
                }

                public static class FluBean {
                    /**
                     * brief : 较易发
                     * details : 虽然温度适宜但风力较大，仍较易发生感冒，体质较弱的朋友请注意适当防护。
                     */

                    private String brief;
                    private String details;

                    @Override
                    public String toString() {
                        return "FluBean{" +
                                "brief='" + brief + '\'' +
                                ", details='" + details + '\'' +
                                '}';
                    }

                    public String getBrief() {
                        return brief;
                    }

                    public void setBrief(String brief) {
                        this.brief = brief;
                    }

                    public String getDetails() {
                        return details;
                    }

                    public void setDetails(String details) {
                        this.details = details;
                    }
                }

                public static class SportBean {
                    /**
                     * brief : 较适宜
                     * details : 天气较好，但因风力稍强，户外可选择对风力要求不高的运动，推荐您进行室内运动。
                     */

                    private String brief;
                    private String details;

                    @Override
                    public String toString() {
                        return "SportBean{" +
                                "brief='" + brief + '\'' +
                                ", details='" + details + '\'' +
                                '}';
                    }

                    public String getBrief() {
                        return brief;
                    }

                    public void setBrief(String brief) {
                        this.brief = brief;
                    }

                    public String getDetails() {
                        return details;
                    }

                    public void setDetails(String details) {
                        this.details = details;
                    }
                }
            }
        }

        public static class FutureBean {
            /**
             * date : 2018-05-11
             * high : 26
             * low : 16
             * day : 周五
             * text : 多云/小雨
             * code1 : 4
             * code2 : 13
             * cop :
             * wind : 风力3级
             */

            private String date;
            private String high;
            private String low;
            private String day;
            private String text;
            private String code1;
            private String code2;
            private String cop;
            private String wind;

            @Override
            public String toString() {
                return "FutureBean{" +
                        "date='" + date + '\'' +
                        ", high='" + high + '\'' +
                        ", low='" + low + '\'' +
                        ", day='" + day + '\'' +
                        ", text='" + text + '\'' +
                        ", code1='" + code1 + '\'' +
                        ", code2='" + code2 + '\'' +
                        ", cop='" + cop + '\'' +
                        ", wind='" + wind + '\'' +
                        '}';
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
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

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getCode1() {
                return code1;
            }

            public void setCode1(String code1) {
                this.code1 = code1;
            }

            public String getCode2() {
                return code2;
            }

            public void setCode2(String code2) {
                this.code2 = code2;
            }

            public String getCop() {
                return cop;
            }

            public void setCop(String cop) {
                this.cop = cop;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }
        }
    }
}
