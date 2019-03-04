package cn.max.core.service.product;

import javax.annotation.Resource;

import cn.max.core.bean.PageBean;
import cn.max.core.bean.product.Brand;
import cn.max.core.dao.product.BrandDao;
import cn.max.core.query.product.BrandQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 品牌事务
 * @author maxwell
 *
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {

	@Resource
	private BrandDao brandDao;

	@Transactional(readOnly = true)
	public PageBean getBrandListWithPage(Brand brand){
		//1:起始页  startRow = (pageNo - 1)*pageSize
		//2:每页数
		//3:总记录数
		return new PageBean(brandDao.getBrandListWithPage(brand), brandDao.getBrandCount(brand), brand.getPageSize());
	}

	@Override
	public void addBrand(Brand brand) {
		brandDao.addBrand(brand);
	}

	@Override
	public void deleteBrandByKey(Integer id) {
		brandDao.deleteBrandByKey(id);

	}

	@Override
	public void deleteBrandByKeys(Integer[] ids) {
		brandDao.deleteBrandByKeys(ids);

	}

	@Override
	public void updateBrandByKey(Brand brand) {
		brandDao.updateBrandByKey(brand);

	}

	@Override
	public Brand getBrandByKey(Integer id) {
		// TODO Auto-generated method stub
		return brandDao.getBrandByKey(id);
	}

	@Override
	public List<Brand> getBrandList(BrandQuery brandQuery) {
		// TODO Auto-generated method stub
		return brandDao.getBrandList(brandQuery);
	}
}
