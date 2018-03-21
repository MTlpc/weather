package com.lpc.springboot.weather.vo;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="城市代码")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

    @XmlElement(name="省")
    private String province;
    @XmlElement(name="市")
    private List<City> cityList;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
