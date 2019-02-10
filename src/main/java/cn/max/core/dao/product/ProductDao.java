package cn.max.core.dao.product;

import java.util.List;

import cn.max.core.bean.product.Product;
import cn.max.core.query.product.ProductQuery;

public interface ProductDao {

	/**
	 * 添加
	 * @param product
	 */
	public Integer addProduct(Product product);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Product getProductByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Product> getProductsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param id
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param idList
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param product
	 */
	public Integer updateProductByKey(Product product);

	/**
	 * 分页查询
	 * @param productQuery
	 */
	public List<Product> getProductListWithPage(ProductQuery productQuery);

	/**
	 * 集合查询
	 * @param productQuery
	 */
	public List<Product> getProductList(ProductQuery productQuery);
	
	/**
	 * 总条数
	 * @param productQuery
	 */
	public int getProductListCount(ProductQuery productQuery);
}
