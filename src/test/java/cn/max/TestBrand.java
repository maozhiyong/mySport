package cn.max;


import cn.max.core.bean.product.Brand;
import cn.max.core.query.product.BrandQuery;
import cn.max.core.service.product.BrandService;
import frame.SpringJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 测试
 * @author lx
 *
 */

public class TestBrand extends SpringJunitTest{

	@Autowired
	private BrandService brandService;
	@Test
	public void testGet() {
		BrandQuery brandQuery = new BrandQuery();
		
		brandQuery.setFields("id,name,description");
		brandQuery.setNameLike(true);
		brandQuery.setName("");
		brandQuery.orderbyId(false);
		
//		brandQuery.setPageNo(1);
//		brandQuery.setPageSize(2);
		List<Brand> brands = brandService.getBrandList(brandQuery);
		
		for (Brand b : brands) {
			System.out.println(b);
		}
	}
}
