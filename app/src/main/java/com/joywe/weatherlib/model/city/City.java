package com.joywe.weatherlib.model.city;

/**
 * city Holder
 * @author 吴文成
 */

public class City {
    /**
     * cityId : 101310230  魅族天气使用
     * city : 广州  中华日历天气 & SoJson 天气 & 和风天气使用
     * townId : CHBJ000000 中央天气使用
     */

    private String cityId;

    private String city;

    private String townId;

    @Override
    public String toString() {
        return "City{" +
                "city='" + city + '\'' +
                ", cityId='" + cityId + '\'' +
                ", townId='" + townId + '\'' +
                '}';
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTownId() {
        return townId;
    }

    public void setTownId(String townId) {
        this.townId = townId;
    }
}