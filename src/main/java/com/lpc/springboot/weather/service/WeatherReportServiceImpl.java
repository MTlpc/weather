package com.lpc.springboot.weather.service;

import com.lpc.springboot.weather.vo.Weather;
import com.lpc.springboot.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    WeatherDataService weatherDataService;

    /**
     * 根据城市ID查询天气
     * @param cityId 城市ID
     * @return 天气Data数据
     */
    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse resp = weatherDataService.getDataByCityId(cityId);
        return resp.getData();
    }
}
