package com.lpc.springboot.weather.job;

import com.lpc.springboot.weather.service.CityDataService;
import com.lpc.springboot.weather.service.WeatherDataService;
import com.lpc.springboot.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;


/**
 * 自动定时获取天气信息
 */
public class WeatherDataSyncJob  extends QuartzJobBean{

    private Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Weather Data Sync Job. Start!");
//        TODO.. 获取城市列表
        List<City> cityList = null;

        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            logger.error("Exception!", e);
        }
//        TODO.. 遍历城市ID并写入到Redis中

        for(City city : cityList){
            String cityId = city.getId();
            logger.info("Weather Data Sync Job, cityId ==> " + cityId);
            weatherDataService.syncDateByCityId(cityId);
        }
        logger.info("Weather Data Sync Job. end!");
    }
}
