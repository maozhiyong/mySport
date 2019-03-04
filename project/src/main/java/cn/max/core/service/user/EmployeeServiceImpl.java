package cn.max.core.service.user;

import java.util.List;

import javax.annotation.Resource;
import cn.max.core.bean.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.max.core.bean.user.Employee;
import cn.max.core.dao.user.EmployeeDao;
import cn.max.core.query.user.EmployeeQuery;
/**
 * 员工
 * @author max
 *
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	EmployeeDao employeeDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Employee getEmployeeByKey(String id) {
		return employeeDao.getEmployeeByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Employee> getEmployeesByKeys(List<String> idList) {
		return employeeDao.getEmployeesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(String id) {
		return employeeDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<String> idList) {
		return employeeDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateEmployeeByKey(Employee employee) {
		return employeeDao.updateEmployeeByKey(employee);
	}
	
	@Transactional(readOnly = true)
	public PageBean getEmployeeListWithPage(EmployeeQuery employeeQuery) {
		PageBean pageBean = new PageBean();
		pageBean.setTotalCount(employeeDao.getEmployeeListCount(employeeQuery));
		pageBean.setPageSize(employeeQuery.getPageSize());
		pageBean.setCurrentPage(employeeQuery.getPageNo());
		pageBean.setPageData(employeeDao.getEmployeeListWithPage(employeeQuery));
		return pageBean;
	}
	
	@Transactional(readOnly = true)
	public List<Employee> getEmployeeList(EmployeeQuery employeeQuery) {
		return employeeDao.getEmployeeList(employeeQuery);
	}
}
