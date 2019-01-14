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

	public List<Brand> getBrandList(BrandQuery brandQuery);

	//添加品牌
	public void addBrand(Brand brand);

	//删除
	public void deleteBrandByKey(Integer id);

	//删除 批量
	public void deleteBrandByKeys(Integer[] ids);//List<Integer>  ids

	//修改
	public void updateBrandByKey(Brand brand);


	public Brand getBrandByKey(Integer id);
}
