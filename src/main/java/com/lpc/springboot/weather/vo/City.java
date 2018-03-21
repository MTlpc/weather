package com.lpc.springboot.weather.vo;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="市")
@XmlAccessorType(XmlAccessType.FIELD)   //通过字段来访问
public class City {
    @XmlElement(name="编码")
    private String id;
    @XmlElement(name="市名")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
