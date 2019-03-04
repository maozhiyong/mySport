package cn.max.core.dao.product;

import cn.max.core.bean.product.Sku;
import cn.max.core.query.product.SkuQuery;

import java.util.List;


public interface SkuDao {

	/**
	 * 添加
	 * @param sku
	 */
	public Integer addSku(Sku sku);

	/**
	 * 根据主键查找
	 */
	public Sku getSkuByKey(Integer id);

	/**
	 * 根据主键批量查找
	 */
	public List<Sku> getSkusByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 */
	public Integer updateSkuByKey(Sku sku);

	/**
	 * 分页查询
	 * @param skuQuery
	 */
	public List<Sku> getSkuListWithPage(SkuQuery skuQuery);

	/**
	 * 集合查询
	 * @param skuQuery
	 */
	public List<Sku> getSkuList(SkuQuery skuQuery);

	/**
	 * 总条数
	 * @param skuQuery
	 */
	public int getSkuListCount(SkuQuery skuQuery);
	/**
	 * 库存大于>0
	 */
	public List<Sku> getStock(Integer productId);

}
