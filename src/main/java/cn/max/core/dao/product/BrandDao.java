package cn.max.core.dao.product;

import java.util.List;

import cn.max.core.bean.product.Brand;

/**
 * 品牌
 * @author max
 *
 */
public interface BrandDao {
	//List集合
	List<Brand> getBrandListWithPage(Brand brand);
	
	//查询总记录数
	int getBrandCount(Brand brand);
	//添加品牌
	void addBrand(Brand brand);
}
