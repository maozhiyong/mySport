package cn.max.core.service.order;

import java.util.List;

import cn.max.core.bean.PageBean;
import cn.max.core.bean.order.Order;
import cn.max.core.query.order.OrderQuery;

/**
 * 
 * @author max
 * @Date [2014-3-28 下午01:50:28]
 */
public interface OrderService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addOrder(Order order);

	/**
	 * 根据主键查询
	 */
	public Order getOrderByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Order> getOrdersByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateOrderByKey(Order order);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param orderQuery
	 *            查询条件
	 * @return
	 */
	public PageBean getOrderListWithPage(OrderQuery orderQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param orderQuery
	 *            查询条件
	 * @return
	 */
	public List<Order> getOrderList(OrderQuery orderQuery);
}
