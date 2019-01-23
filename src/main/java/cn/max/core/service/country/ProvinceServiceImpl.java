package cn.max.core.service.country;

import java.util.List;

import javax.annotation.Resource;
import cn.max.core.bean.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.max.core.bean.country.Province;
import cn.max.core.dao.country.ProvinceDao;
import cn.max.core.query.country.ProvinceQuery;
/**
 * 省
 * @author max
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

	@Resource
	ProvinceDao provinceDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addProvince(Province province) {
		return provinceDao.addProvince(province);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Province getProvinceByKey(Integer id) {
		return provinceDao.getProvinceByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Province> getProvincesByKeys(List<Integer> idList) {
		return provinceDao.getProvincesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return provinceDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return provinceDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateProvinceByKey(Province province) {
		return provinceDao.updateProvinceByKey(province);
	}
	
	@Transactional(readOnly = true)
	public PageBean getProvinceListWithPage(ProvinceQuery provinceQuery) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(provinceQuery.getPageNo());
		pageBean.setPageData(provinceDao.getProvinceListWithPage(provinceQuery));
		pageBean.setPageSize(provinceQuery.getPageSize());
		pageBean.setTotalCount(provinceDao.getProvinceListCount(provinceQuery));
		return pageBean;
	}
	
	@Transactional(readOnly = true)
	public List<Province> getProvinceList(ProvinceQuery provinceQuery) {
		return provinceDao.getProvinceList(provinceQuery);
	}
}
