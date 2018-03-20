package com.lpc.springboot.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lpc.springboot.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    //    添加日志处理
    private static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    private static final long TIME_OUT = 1200L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri) {

        String key = uri;
        String strBody = null;
        ValueOperations<String, String> ops =  stringRedisTemplate.opsForValue();

        //使用jackson进行解析
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = new WeatherResponse();


//       查询缓存，如果缓存中存在，则调缓存
        if(stringRedisTemplate.hasKey(key)){
            logger.info("redis has data");
            // 调用缓存
            strBody = ops.get(key);
        }else {
            logger.info("redis don't has data");
            //调用接口
            //使用HttpClient工具获取 ==> String对象
            ResponseEntity<String> respStr = restTemplate.getForEntity(uri, String.class);
            //提取对象的body ==> String
            if(respStr.getStatusCodeValue() == 200){
                strBody = respStr.getBody();
            }
            //存入缓存
            ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
        }


//        进行JSON转换
        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            logger.error("Error: " + e.getMessage());
        }

        return resp;
    }
}
