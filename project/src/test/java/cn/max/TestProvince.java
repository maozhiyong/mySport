package cn.max;

import cn.max.core.bean.country.Province;
import cn.max.core.query.country.ProvinceQuery;
import cn.max.core.service.country.ProvinceService;
import frame.SpringJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestProvince extends SpringJunitTest{
    @Autowired
    ProvinceService provinceService;

    @Test
    public void testList() {
        List<Province> provinceList = provinceService.getProvinceList(new ProvinceQuery());

        for (Province province : provinceList) {
            System.out.println(province.toString());
        }
    }
}
