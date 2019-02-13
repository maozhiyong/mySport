package cn.max.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import cn.max.core.bean.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.max.core.bean.product.Type;
import cn.max.core.dao.product.TypeDao;
import cn.max.core.query.product.TypeQuery;
/**
 * 商品类型
 * @author max
 *
 */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {

	@Resource
	TypeDao typeDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addType(Type type) {
		return typeDao.addType(type);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Type getTypeByKey(Integer id) {
		return typeDao.getTypeByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Type> getTypesByKeys(List<Integer> idList) {
		return typeDao.getTypesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return typeDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return typeDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateTypeByKey(Type type) {
		return typeDao.updateTypeByKey(type);
	}
	
	@Transactional(readOnly = true)
	public PageBean getTypeListWithPage(TypeQuery typeQuery) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(typeQuery.getPageNo());
		pageBean.setPageData(typeDao.getTypeListWithPage(typeQuery));
		pageBean.setPageSize(typeQuery.getPageSize());
		pageBean.setTotalCount(typeDao.getTypeListCount(typeQuery));
		return pageBean;
	}
	
	@Transactional(readOnly = true)
	public List<Type> getTypeList(TypeQuery typeQuery) {
		return typeDao.getTypeList(typeQuery);
	}
}
