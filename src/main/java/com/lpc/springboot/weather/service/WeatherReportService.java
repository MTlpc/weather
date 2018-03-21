package com.lpc.springboot.weather.service;

import com.lpc.springboot.weather.vo.Weather;
import org.springframework.stereotype.Service;

public interface WeatherReportService {

    /**
     * 根据城市ID查询天气
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
