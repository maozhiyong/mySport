package cn.max;

import cn.max.core.bean.country.City;
import cn.max.core.query.country.CityQuery;
import frame.SpringJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestCity extends SpringJunitTest{

    @Autowired
    cn.max.core.service.country.CityService service;
    @Test
    public void test() {
        List<City> cityList = service.getCityList(new CityQuery());
        for (City city : cityList) {
            System.out.println(city.toString());
        }
    }
}
