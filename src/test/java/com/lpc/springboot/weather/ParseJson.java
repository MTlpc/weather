package com.lpc.springboot.weather;

import com.lpc.springboot.weather.util.TestXmlBuilder;
import com.lpc.springboot.weather.vo.City;
import com.lpc.springboot.weather.vo.CityList;
import com.lpc.springboot.weather.vo.ProvinceList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ParseJson {
    public static void main(String[] args) throws Exception{
//        TODO..读取JSON文件
//        读取XML
        Resource resource = new ClassPathResource("citilist.xml");

//        加入一个输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));

        String line = "";
        StringBuffer buffer = new StringBuffer();

        while ((line = br.readLine()) != null){
            buffer.append(line);
        }

        br.close();
//      将XML转换成java对象
        ProvinceList provinceList = (ProvinceList) TestXmlBuilder.xmlStrToObject(ProvinceList.class, buffer.toString());

        for(CityList cityList : provinceList.getProvinces()){
            System.out.println(cityList.getProvince());
            for (City city: cityList.getCityList()){
                System.out.println(city.getName() + " ==> "+ city.getId());
            }
            System.out.println("----------------");
        }
    }
}
