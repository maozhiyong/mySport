package cn.max.core.service.product;

import java.util.List;

import cn.max.core.bean.PageBean;
import cn.max.core.bean.product.Product;
import cn.max.core.query.product.ProductQuery;

/**
 * 
 * @author max
 * @Date [2014-3-28 下午01:50:28]
 */
public interface ProductService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addProduct(Product product);

	/**
	 * 根据主键查询
	 */
	public Product getProductByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Product> getProductsByKeys(List<Integer> idList);

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
	public Integer updateProductByKey(Product product);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param productQuery
	 *            查询条件
	 * @return
	 */
	public PageBean getProductListWithPage(ProductQuery productQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param productQuery
	 *            查询条件
	 * @return
	 */
	public List<Product> getProductList(ProductQuery productQuery);
}
