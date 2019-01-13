package cn.max.core.service.product;

import cn.max.core.bean.PageBean;
import cn.max.core.bean.product.Brand;

/**
 * 品牌
 * @author max
 *
 */
public interface BrandService {

	PageBean getBrandListWithPage(Brand brand);
	
	//添加品牌
	void addBrand(Brand brand);
}
