package com.lpc.springboot.weather.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProvinceList {
    @XmlElement(name = "城市代码")
    private List<CityList> provinces;

    public List<CityList> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<CityList> provinces) {
        this.provinces = provinces;
    }
}
