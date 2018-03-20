package com.lpc.springboot.weather.service;

import com.lpc.springboot.weather.vo.WeatherResponse;

public interface WeatherDataService {
    /**
     * 通过城市ID来获取城市信息
     * @param cityId 城市ID
     * @return 天气预报信息
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 通过城市名称获取城市信息
     * @param cityName 城市名称
     * @return 天气预报信息
     */
    WeatherResponse getDataByCityName(String cityName);

    /**
     * 根据城市ID来同步天气
     * @param cityId
     */
    void syncDateByCityId(String cityId);
}
