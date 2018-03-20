package com.lpc.springboot.weather.vo;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

    @XmlElement(name="d")
    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
