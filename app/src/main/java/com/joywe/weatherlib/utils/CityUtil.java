package com.joywe.weatherlib.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joywe.weatherlib.model.city.City;
import com.joywe.weatherlib.model.city.CityBean;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CityUtil {

    private CityUtil() {}

    private static class Holder {
        private static final CityUtil INSTANCE = new CityUtil();
    }

    public static CityUtil getInstance() {
        return Holder.INSTANCE;
    }

    private CityHolder mCityHolder;
    private List<CityBean> mCities;

    /**
     * 通过城市名字获取cityIds
     *
     * @param cityName 城市名字
     * @param cities   城市List
     * @return cityIds
     */
    public String getCityIdsByCityName(String cityName, List<CityBean> cities) {
        String cityIds = null;
        // 用于确定是否为下级城市
        boolean isArea = false, isInnerArea = false;
        // 用于拿到cityIds的下标
        int provinceIndex = -1, areaIndex = -1, innerAreaIndex = -1;
        // 省list 判空
        if (cities != null && cities.size() > 0) {
            int provinceSize = cities.size();
            // 省级循环
            for (int i = 0; i < provinceSize; i++) {
                // 避免重复循环
                if (isArea || isInnerArea || cityIds != null) {
                    break;
                }
                CityBean cityBean = cities.get(i);
                String provinceName = cityBean.getName();
                // 省名称判空
                if (provinceName != null) {
                    // 拿到省级下标位置
                    provinceIndex = i;
                    // 是否匹配省级名称
                    if (provinceName.contains(cityName)) {
                        if (cityBean.getAreaId() != null) {
                            // 不为空的情况下直接赋值
                            cityIds = cityBean.getAreaId();
                        } else {
                            // 为空跳出这个循环
                            break;
                        }
                    } else {
                        List<CityBean.Area> areas = cityBean.getArea();
                        //市list 判空
                        if (areas != null) {
                            int areaSize = areas.size();
                            // 市级循环
                            for (int j = 0; j < areaSize; j++) {
                                // 避免重复循环
                                if (isInnerArea || cityIds != null) {
                                    break;
                                }
                                CityBean.Area area = areas.get(j);
                                String areaName = area.getName();
                                // 市名称判空
                                if (areaName != null) {
                                    // 拿到市级下标位置
                                    areaIndex = j;
                                    // 是否匹配市级名称
                                    if (areaName.contains(cityName)) {
                                        isArea = true;
                                        if (area.getAreaId() != null) {
                                            // 不为空的情况下直接赋值
                                            cityIds = area.getAreaId();
                                        } else {
                                            // 为空跳出这个循环
                                            break;
                                        }
                                    } else {
                                        List<CityBean.Area.InnerArea> innerAreas = area.getArea();
                                        // 县（区）list 判空
                                        if (innerAreas != null) {
                                            int innerAreaSize = innerAreas.size();
                                            // 县（区）级循环
                                            for (int k = 0; k < innerAreaSize; k++) {
                                                // 避免重复循环
                                                if (cityIds == null) {
                                                    CityBean.Area.InnerArea innerArea = innerAreas.get(k);
                                                    String innerAreaName = innerArea.getName();
                                                    // 县（区）名称判空
                                                    if (innerAreaName != null) {
                                                        // 拿到县（区）级下标位置
                                                        innerAreaIndex = k;
                                                        // 是否匹配县（区）级名称
                                                        if (innerAreaName.contains(cityName)) {
                                                            isInnerArea = true;
                                                            if (innerArea.getAreaId() != null) {
                                                                // 不为空的情况下直接赋值
                                                                cityIds = innerArea.getAreaId();
                                                            } else {
                                                                // 为空跳出这个循环
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            //保存index信息 用于外部提取上级城市的信息
            saveIndex(isArea, isInnerArea, provinceIndex, areaIndex, innerAreaIndex);
            // 判断是否已赋值 （没有对应的cityIds）
            if (cityIds == null) {
                // 判断是否匹配县（区）级名称
                if (innerAreaIndex != -1 && isInnerArea) {
                    // 拿到市级的cityIds
                    cityIds = cities.get(provinceIndex).getArea().get(areaIndex).getAreaId();
                    // 是否拿到市级 TownId
                    if (cityIds == null) {
                        // 没有则查找省级 cityIds
                        cityIds = cities.get(provinceIndex).getAreaId();
                    }
                    // 是否为市级名称
                } else if (areaIndex != -1 && isArea) {
                    // 是则查找省级 cityIds
                    cityIds = cities.get(provinceIndex).getAreaId();
                }
            }
            return cityIds;
        }
        return null;
    }

    /**
     * 通过城市名字获取cityIds
     *
     * @param cityName 城市名字
     * @param cities   城市List
     * @return cityIds
     */
    public String getCityByCityName(String cityName, List<CityBean> cities) {
        String city = null;
        // 用于确定是否为下级城市
        boolean isArea = false, isInnerArea = false;
        // 用于拿到cityIds的下标
        int provinceIndex = -1, areaIndex = -1, innerAreaIndex = -1;
        // 省list 判空
        if (cities != null && cities.size() > 0) {
            int provinceSize = cities.size();
            // 省级循环
            for (int i = 0; i < provinceSize; i++) {
                // 避免重复循环
                if (isArea || isInnerArea || city != null) {
                    break;
                }
                CityBean cityBean = cities.get(i);
                String provinceName = cityBean.getName();
                // 省名称判空
                if (provinceName != null) {
                    // 拿到省级下标位置
                    provinceIndex = i;
                    // 是否匹配省级名称
                    if (provinceName.contains(cityName)) {
                        if (cityBean.getName() != null && cityBean.getAreaId() == null || cityBean.getName() != null && cityBean.getTownId() == null) {
                            // 不为空的情况下直接赋值
                            city = cityBean.getName();
                        } else {
                            // 为空跳出这个循环
                            break;
                        }
                    } else {
                        List<CityBean.Area> areas = cityBean.getArea();
                        //市list 判空
                        if (areas != null) {
                            int areaSize = areas.size();
                            // 市级循环
                            for (int j = 0; j < areaSize; j++) {
                                // 避免重复循环
                                if (isInnerArea || city != null) {
                                    break;
                                }
                                CityBean.Area area = areas.get(j);
                                String areaName = area.getName();
                                // 市名称判空
                                if (areaName != null) {
                                    // 拿到市级下标位置
                                    areaIndex = j;
                                    // 是否匹配市级名称
                                    if (areaName.contains(cityName)) {
                                        isArea = true;
                                        if (area.getName() != null && area.getAreaId() == null || area.getName() != null && area.getTownId() == null) {
                                            // 不为空的情况下直接赋值
                                            city = area.getName();
                                        } else {
                                            // 为空跳出这个循环
                                            break;
                                        }
                                    } else {
                                        List<CityBean.Area.InnerArea> innerAreas = area.getArea();
                                        // 县（区）list 判空
                                        if (innerAreas != null) {
                                            int innerAreaSize = innerAreas.size();
                                            // 县（区）级循环
                                            for (int k = 0; k < innerAreaSize; k++) {
                                                // 避免重复循环
                                                if (city == null) {
                                                    CityBean.Area.InnerArea innerArea = innerAreas.get(k);
                                                    String innerAreaName = innerArea.getName();
                                                    // 县（区）名称判空
                                                    if (innerAreaName != null) {
                                                        // 拿到县（区）级下标位置
                                                        innerAreaIndex = k;
                                                        // 是否匹配县（区）级名称
                                                        if (innerAreaName.contains(cityName)) {
                                                            isInnerArea = true;
                                                            if (innerArea.getName() != null && innerArea.getAreaId() == null || innerArea.getName() != null && innerArea.getTownId() == null) {
                                                                // 不为空的情况下直接赋值
                                                                city = innerArea.getName();
                                                            } else {
                                                                // 为空跳出这个循环
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // 判断是否已赋值 （没有对应的city）
            if (city == null) {
                // 判断是否匹配县（区）级名称
                if (innerAreaIndex != -1 && isInnerArea) {
                    // 拿到市级的cityIds
                    city = cities.get(provinceIndex).getArea().get(areaIndex).getName();
                    // 是否拿到市级 TownId
                    if (city == null) {
                        // 没有则查找省级 cityIds
                        city = cities.get(provinceIndex).getName();
                    }
                    // 是否为市级名称
                } else if (areaIndex != -1 && isArea) {
                    // 是则查找省级 cityIds
                    city = cities.get(provinceIndex).getName();
                }
            }
            return city;
        }
        return null;
    }

    /**
     * 获取上一级城市的名称
     *
     * @param cities 城市List
     * @return 上一级城市的名称
     */
    public String getPreCityName(List<CityBean> cities) {
        String preCityName = null;
        if (mCityHolder != null) {
            // 判断是否匹配县（区）级名称
            if (mCityHolder.innerAreaIndex != -1 && mCityHolder.isInnerArea) {
                // 拿到市级的名称
                preCityName = cities.get(mCityHolder.provinceIndex).getArea().get(mCityHolder.areaIndex).getName();
                // 是否拿到市级名称
                if (preCityName == null) {
                    // 没有则查找省级名称
                    preCityName = cities.get(mCityHolder.provinceIndex).getName();
                }
                // 是否为市级名称
            } else if (mCityHolder.areaIndex != -1 && mCityHolder.isArea) {
                // 是则查找省级 名称
                preCityName = cities.get(mCityHolder.provinceIndex).getName();
            }
        }
        return preCityName;
    }

    /**
     * 获取上一级城市的名称
     *
     * @return 上一级城市的名称
     */
    public String getPreCityName() {
        String preCityName = null;
        if (mCityHolder != null && mCities != null) {
            // 判断是否匹配县（区）级名称
            if (mCityHolder.innerAreaIndex != -1 && mCityHolder.isInnerArea) {
                // 拿到市级的名称
                preCityName = mCities.get(mCityHolder.provinceIndex).getArea().get(mCityHolder.areaIndex).getName();
                // 是否拿到市级名称
                if (preCityName == null) {
                    // 没有则查找省级名称
                    preCityName = mCities.get(mCityHolder.provinceIndex).getName();
                }
                // 是否为市级名称
            } else if (mCityHolder.areaIndex != -1 && mCityHolder.isArea) {
                // 是则查找省级 名称
                preCityName = mCities.get(mCityHolder.provinceIndex).getName();
            }
        }
        return preCityName;
    }

    /**
     * 保存index信息
     */
    private void saveIndex(boolean isArea, boolean isInnerArea, int provinceIndex, int areaIndex, int innerAreaIndex) {
        boolean indexChange = innerAreaIndex != -1 || areaIndex != -1 || provinceIndex != -1;
        boolean innerCity = isInnerArea || isArea;
        if (indexChange && innerCity) {
            mCityHolder = new CityHolder(isArea, isInnerArea, provinceIndex, areaIndex, innerAreaIndex);
        }
    }


    /**
     * 通过城市名字获取townId
     *
     * @param cityName 城市名字
     * @param cities   城市beanList
     * @return TownId
     */
    public String getTownIdByCityName(String cityName, List<CityBean> cities) {
        String townId = null;
        // 用于确定是否为下级城市
        boolean isArea = false, isInnerArea = false;
        // 用于拿到TownId的下标
        int provinceIndex = -1, areaIndex = -1, innerAreaIndex = -1;
        // 省list 判空
        if (cities != null && cities.size() > 0) {
            int provinceSize = cities.size();
            // 省级循环
            for (int i = 0; i < provinceSize; i++) {
                // 避免重复循环
                if (isArea || isInnerArea || townId != null) {
                    break;
                }
                CityBean cityBean = cities.get(i);
                String provinceName = cityBean.getName();
                // 省名称判空
                if (provinceName != null) {
                    // 拿到省级下标位置
                    provinceIndex = i;
                    // 是否匹配省级名称
                    if (provinceName.contains(cityName)) {
                        if (cityBean.getTownId() != null) {
                            // 不为空的情况下直接赋值
                            townId = cityBean.getTownId();
                        } else {
                            // 为空跳出这个循环
                            break;
                        }
                    } else {
                        List<CityBean.Area> areas = cityBean.getArea();
                        //市list 判空
                        if (areas != null) {
                            int areaSize = areas.size();
                            // 市级循环
                            for (int j = 0; j < areaSize; j++) {
                                // 避免重复循环
                                if (isInnerArea || townId != null) {
                                    break;
                                }
                                CityBean.Area area = areas.get(j);
                                String areaName = area.getName();
                                // 市名称判空
                                if (areaName != null) {
                                    // 拿到市级下标位置
                                    areaIndex = j;
                                    // 是否匹配市级名称
                                    if (areaName.contains(cityName)) {
                                        isArea = true;
                                        if (area.getTownId() != null) {
                                            // 不为空的情况下直接赋值
                                            townId = area.getTownId();
                                        } else {
                                            // 为空跳出这个循环
                                            break;
                                        }
                                    } else {
                                        List<CityBean.Area.InnerArea> innerAreas = area.getArea();
                                        // 县（区）list 判空
                                        if (innerAreas != null) {
                                            int innerAreaSize = innerAreas.size();
                                            // 县（区）级循环
                                            for (int k = 0; k < innerAreaSize; k++) {
                                                // 避免重复循环
                                                if (townId == null) {
                                                    CityBean.Area.InnerArea innerArea = innerAreas.get(k);
                                                    String innerAreaName = innerArea.getName();
                                                    // 县（区）名称判空
                                                    if (innerAreaName != null) {
                                                        // 拿到县（区）级下标位置
                                                        innerAreaIndex = k;
                                                        // 是否匹配县（区）级名称
                                                        if (innerAreaName.contains(cityName)) {
                                                            isInnerArea = true;
                                                            if (innerArea.getTownId() != null) {
                                                                // 不为空的情况下直接赋值
                                                                townId = innerArea.getTownId();
                                                            } else {
                                                                // 为空跳出这个循环
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            //保存index信息 用于下次提取信息
            saveIndex(isArea, isInnerArea, provinceIndex, areaIndex, innerAreaIndex);
            // 判断是否已赋值 （没有对应的TownId）
            if (townId == null) {
                // 判断是否匹配县（区）级名称
                if (innerAreaIndex != -1 && isInnerArea) {
                    // 拿到市级的TownId
                    townId = cities.get(provinceIndex).getArea().get(areaIndex).getTownId();
                    // 是否拿到市级 TownId
                    if (townId == null) {
                        // 没有则查找省级 TownId
                        townId = cities.get(provinceIndex).getTownId();
                    }
                    // 是否为市级名称
                } else if (areaIndex != -1 && isArea) {
                    // 是则查找省级 TownId
                    townId = cities.get(provinceIndex).getTownId();
                }
            }
            return townId;
        }
        return null;
    }

    /**
     * 通过城市名字获取包装后的city对象
     *
     * @param context  context 用来获取Assets目录下的文件
     * @param cityName 城市名字
     * @return city对象
     */
    public City getCityByName(Context context, String cityName) {
        Context applicationContext = context.getApplicationContext();
        City city = new City();
        InputStream inputStream = null;
        List<CityBean> cities = null;
        // 通过文件拿到cities数据
        try {
            inputStream = applicationContext.getAssets().open("Cities.json");
            int available = inputStream.available();
            byte[] buffer = new byte[available];
            int read = inputStream.read(buffer);
            if (read != 0) {
                String citiesStr = new String(buffer);
                Type type = new TypeToken<ArrayList<CityBean>>() {
                }.getType();
                cities = new Gson().fromJson(citiesStr, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(inputStream);
        }
        String townId = getTownIdByCityName(cityName, cities);
        String cityIds = getCityIdsByCityName(cityName, cities);
        //cityName = getCityByCityName(cityName, cities);
        city.setCity(cityName);
        city.setCityId(cityIds);
        city.setTownId(townId);
        return city;
    }

    /**
     * 获取城市列表
     *
     * @param context context 用于获取Assets目录下的文件
     * @return 城市列表
     */
    public List<CityBean> getCities(Context context) {
        InputStream inputStream = null;
        List<CityBean> cities = null;
        // 从文件流中获取cities数据
        try {
            inputStream = context.getAssets().open("Cities.json");
            int available = inputStream.available();
            byte[] buffer = new byte[available];
            int read = inputStream.read(buffer);
            if (read != 0) {
                String citiesStr = new String(buffer);
                Type type = new TypeToken<ArrayList<CityBean>>() {
                }.getType();
                cities = new Gson().fromJson(citiesStr, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(inputStream);
        }
        return cities;
    }

    /**
     * 通过城市名字获取包装后的city对象
     *
     * @param cities   传进来的城市列表
     * @param cityName 城市名字
     * @return city对象
     */
    public City getCityByName(String cityName, List<CityBean> cities) {
        if (cityName != null && cities != null) {
            mCities = cities;
            City city = new City();
            String townId = getTownIdByCityName(cityName, cities);
            String cityIds = getCityIdsByCityName(cityName, cities);
            city.setCity(cityName);
            city.setCityId(cityIds);
            city.setTownId(townId);
            return city;
        } else {
            return null;
        }
    }

    public void closeQuietly(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 用于拿到city信息的Holder
     */
    private static class CityHolder {
        boolean isArea, isInnerArea;
        int provinceIndex, areaIndex, innerAreaIndex;

        CityHolder(boolean isArea, boolean isInnerArea,
                   int provinceIndex, int areaIndex, int innerAreaIndex) {
            this.isArea = isArea;
            this.isInnerArea = isInnerArea;
            this.provinceIndex = provinceIndex;
            this.areaIndex = areaIndex;
            this.innerAreaIndex = innerAreaIndex;
        }
    }
}