package cn.max.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import cn.max.core.bean.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.max.core.bean.product.Color;
import cn.max.core.dao.product.ColorDao;
import cn.max.core.query.product.ColorQuery;
/**
 * 颜色
 * @author max
 *
 */
@Service
@Transactional
public class ColorServiceImpl implements ColorService {

	@Resource
	ColorDao colorDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addColor(Color color) {
		return colorDao.addColor(color);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Color getColorByKey(Integer id) {
		return colorDao.getColorByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Color> getColorsByKeys(List<Integer> idList) {
		return colorDao.getColorsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return colorDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return colorDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateColorByKey(Color color) {
		return colorDao.updateColorByKey(color);
	}
	
	@Transactional(readOnly = true)
	public PageBean getColorListWithPage(ColorQuery colorQuery) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(colorQuery.getPageNo());
		pageBean.setPageData(colorDao.getColorListWithPage(colorQuery));
		pageBean.setPageSize(colorQuery.getPageSize());
		pageBean.setTotalCount(colorDao.getColorListCount(colorQuery));
		return pageBean;
	}
	
	@Transactional(readOnly = true)
	public List<Color> getColorList(ColorQuery colorQuery) {
		return colorDao.getColorList(colorQuery);
	}
}
