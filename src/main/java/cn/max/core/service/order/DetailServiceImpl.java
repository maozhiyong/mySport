package cn.max.core.service.order;

import java.util.List;

import javax.annotation.Resource;

import cn.max.core.bean.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.max.core.bean.order.Detail;
import cn.max.core.dao.order.DetailDao;
import cn.max.core.query.order.DetailQuery;
/**
 * 订单子项(订单详情)
 * @author max
 *
 */
@Service
@Transactional
public class DetailServiceImpl implements DetailService {

	@Resource
	DetailDao detailDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addDetail(Detail detail) {
		return detailDao.addDetail(detail);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Detail getDetailByKey(Integer id) {
		return detailDao.getDetailByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Detail> getDetailsByKeys(List<Integer> idList) {
		return detailDao.getDetailsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return detailDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return detailDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateDetailByKey(Detail detail) {
		return detailDao.updateDetailByKey(detail);
	}
	
	@Transactional(readOnly = true)
	public PageBean getDetailListWithPage(DetailQuery detailQuery) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(detailQuery.getPageNo());
		pageBean.setPageData(detailDao.getDetailListWithPage(detailQuery));
		pageBean.setPageSize(detailQuery.getPageSize());
		pageBean.setTotalCount(detailDao.getDetailListCount(detailQuery));
		return pageBean;
	}
	
	@Transactional(readOnly = true)
	public List<Detail> getDetailList(DetailQuery detailQuery) {
		return detailDao.getDetailList(detailQuery);
	}
}
