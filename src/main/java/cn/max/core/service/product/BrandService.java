package cn.max.core.service.product;

import cn.max.core.bean.PageBean;
import cn.max.core.bean.product.Brand;
import cn.max.core.query.product.BrandQuery;

import java.util.List;

/**
 * 品牌
 * @author max
 *
 */
public interface BrandService {

	PageBean getBrandListWithPage(Brand brand);

	List<Brand> getBrandList(BrandQuery brandQuery);

	//添加品牌
	void addBrand(Brand brand);

	//删除
	void deleteBrandByKey(Integer id);

	//删除 批量
	void deleteBrandByKeys(Integer[] ids);//List<Integer>  ids

	//修改
	void updateBrandByKey(Brand brand);

	Brand getBrandByKey(Integer id);
}
