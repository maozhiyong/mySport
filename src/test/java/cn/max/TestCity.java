package cn.max;

import frame.SpringJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestCity extends SpringJunitTest{

    @Autowired
    cn.max.core.service.country.CityService service;
    @Test
    public void test() {

    }
}
