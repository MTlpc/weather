package com.lpc.springboot.weather.service;

import com.lpc.springboot.weather.util.XmlBuilder;
import com.lpc.springboot.weather.vo.City;
import com.lpc.springboot.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService{

    @Override
    public List<City> listCity() throws Exception {
//        读取XML
        Resource resource = new ClassPathResource("citylist.xml");

//        加入一个输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));

        StringBuffer buffer = new StringBuffer();
        String line = "";

        while ((line = br.readLine()) != null){
            buffer.append(line);
        }

        br.close();
//         将XML转换成java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());

        return cityList.getCityList();
    }

}
