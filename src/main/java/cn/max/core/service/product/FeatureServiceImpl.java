package cn.max.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import cn.max.core.bean.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.max.core.bean.product.Feature;
import cn.max.core.dao.product.FeatureDao;
import cn.max.core.query.product.FeatureQuery;
/**
 * 商品属性事务层
 * @author max
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class FeatureServiceImpl implements FeatureService {

	@Resource
	FeatureDao featureDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addFeature(Feature feature) {
		return featureDao.addFeature(feature);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Feature getFeatureByKey(Integer id) {
		return featureDao.getFeatureByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Feature> getFeaturesByKeys(List<Integer> idList) {
		return featureDao.getFeaturesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return featureDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return featureDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateFeatureByKey(Feature feature) {
		return featureDao.updateFeatureByKey(feature);
	}
	
	@Transactional(readOnly = true)
	public PageBean getFeatureListWithPage(FeatureQuery featureQuery) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(featureQuery.getPageNo());
		pageBean.setPageData(featureDao.getFeatureListWithPage(featureQuery));
		pageBean.setPageSize(featureQuery.getPageSize());
		pageBean.setTotalCount(featureDao.getFeatureListCount(featureQuery));
		return pageBean;
	}
	
	@Transactional(readOnly = true)
	public List<Feature> getFeatureList(FeatureQuery featureQuery) {
		return featureDao.getFeatureList(featureQuery);
	}
}
