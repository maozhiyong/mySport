package cn.max.core.service.user;

import java.util.List;

import javax.annotation.Resource;

import cn.max.core.bean.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.max.core.bean.user.Addr;
import cn.max.core.dao.user.AddrDao;
import cn.max.core.query.user.AddrQuery;
/**
 * 地址
 * @author max
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class AddrServiceImpl implements AddrService {

	@Resource
	AddrDao addrDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addAddr(Addr addr) {
		return addrDao.addAddr(addr);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Addr getAddrByKey(Integer id) {
		return addrDao.getAddrByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Addr> getAddrsByKeys(List<Integer> idList) {
		return addrDao.getAddrsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return addrDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return addrDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateAddrByKey(Addr addr) {
		return addrDao.updateAddrByKey(addr);
	}
	
	@Transactional(readOnly = true)
	public PageBean getAddrListWithPage(AddrQuery addrQuery) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(addrQuery.getPageNo());
		pageBean.setPageData(addrDao.getAddrListWithPage(addrQuery));
		pageBean.setPageSize(addrQuery.getPageSize());
		pageBean.setTotalCount(addrDao.getAddrListCount(addrQuery));
		return pageBean;
	}
	
	@Transactional(readOnly = true)
	public List<Addr> getAddrList(AddrQuery addrQuery) {
		return addrDao.getAddrList(addrQuery);
	}
}
