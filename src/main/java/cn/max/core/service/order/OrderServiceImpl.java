package cn.max.core.service.order;

import java.util.List;

import javax.annotation.Resource;

import cn.max.core.bean.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.max.core.bean.order.Order;
import cn.max.core.dao.order.OrderDao;
import cn.max.core.query.order.OrderQuery;
/**
 * 订单主
 * @author max
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Resource
	OrderDao orderDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addOrder(Order order) {
		return orderDao.addOrder(order);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Order getOrderByKey(Integer id) {
		return orderDao.getOrderByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Order> getOrdersByKeys(List<Integer> idList) {
		return orderDao.getOrdersByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return orderDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return orderDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateOrderByKey(Order order) {
		return orderDao.updateOrderByKey(order);
	}
	
	@Transactional(readOnly = true)
	public PageBean getOrderListWithPage(OrderQuery orderQuery) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(orderQuery.getPageNo());
		pageBean.setPageData(orderDao.getOrderListWithPage(orderQuery));
		pageBean.setPageSize(orderQuery.getPageSize());
		pageBean.setTotalCount(orderDao.getOrderListCount(orderQuery));
		return pageBean;
	}
	
	@Transactional(readOnly = true)
	public List<Order> getOrderList(OrderQuery orderQuery) {
		return orderDao.getOrderList(orderQuery);
	}
}
