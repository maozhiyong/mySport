package cn.max.core.service.country;

import java.util.List;

import javax.annotation.Resource;

import cn.max.core.bean.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.max.core.bean.country.City;
import cn.max.core.dao.country.CityDao;
import cn.max.core.query.country.CityQuery;
/**
 * 市
 * @author max
 *
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {

	@Resource
	CityDao cityDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addCity(City city) {
		return cityDao.addCity(city);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public City getCityByKey(Integer id) {
		return cityDao.getCityByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<City> getCitysByKeys(List<Integer> idList) {
		return cityDao.getCitysByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return cityDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return cityDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateCityByKey(City city) {
		return cityDao.updateCityByKey(city);
	}
	
	@Transactional(readOnly = true)
	public PageBean getCityListWithPage(CityQuery cityQuery) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(cityQuery.getPageNo());
		pageBean.setPageData(cityDao.getCityListWithPage(cityQuery));
		pageBean.setPageSize(cityQuery.getPageSize());
		pageBean.setTotalCount(cityDao.getCityListCount(cityQuery));
		return pageBean;
	}
	
	@Transactional(readOnly = true)
	public List<City> getCityList(CityQuery cityQuery) {
		return cityDao.getCityList(cityQuery);
	}
}
