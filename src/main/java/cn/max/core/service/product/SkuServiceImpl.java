package cn.max.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import cn.max.core.bean.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.max.core.bean.product.Sku;
import cn.max.core.dao.product.SkuDao;
import cn.max.core.query.product.SkuQuery;
/**
 * 最小销售单元事务层
 * @author max
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class SkuServiceImpl implements SkuService {

	@Resource
	SkuDao skuDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addSku(Sku sku) {
		return skuDao.addSku(sku);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Sku getSkuByKey(Integer id) {
		return skuDao.getSkuByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Sku> getSkusByKeys(List<Integer> idList) {
		return skuDao.getSkusByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return skuDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return skuDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateSkuByKey(Sku sku) {
		return skuDao.updateSkuByKey(sku);
	}
	
	@Transactional(readOnly = true)
	public PageBean getSkuListWithPage(SkuQuery skuQuery) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(skuQuery.getPageNo());
		pageBean.setPageData(skuDao.getSkuListWithPage(skuQuery));
		pageBean.setPageSize(skuQuery.getPageSize());
		pageBean.setTotalCount(skuDao.getSkuListCount(skuQuery));
		return pageBean;
	}
	
	@Transactional(readOnly = true)
	public List<Sku> getSkuList(SkuQuery skuQuery) {
		return skuDao.getSkuList(skuQuery);
	}
}
