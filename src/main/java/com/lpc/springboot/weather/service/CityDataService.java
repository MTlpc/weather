package com.lpc.springboot.weather.service;

import com.lpc.springboot.weather.vo.City;
import com.lpc.springboot.weather.vo.CityList;

import java.util.List;

public interface CityDataService {
    /**
     * 获取City列表
     * @return
     * @throws Exception
     */
    List<CityList> listCity() throws Exception;
}
