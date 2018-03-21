package com.lpc.springboot.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * xml转换工具类
 */
public class TestXmlBuilder {

    public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception{

        Object xmlObject = null;

//        初始化JABContext

        JAXBContext context = JAXBContext.newInstance(clazz);

//        调用XML转为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();

//        读文件
        Reader reader = null;
        reader = new StringReader(xmlStr);

//        转换
        xmlObject = unmarshaller.unmarshal(reader);

        if(null != reader){
            reader.close();
        }

        return xmlObject;
    }

}
