package cn.max.core.service.user;

import java.util.List;
import cn.max.core.bean.PageBean;
import cn.max.core.bean.user.Employee;
import cn.max.core.query.user.EmployeeQuery;

/**
 * 
 * @author max
 *
 */
public interface EmployeeService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	Integer addEmployee(Employee employee);

	/**
	 * 根据主键查询
	 */
	Employee getEmployeeByKey(String id);

	/**
	 * 根据主键批量查询
	 */
	List<Employee> getEmployeesByKeys(List<String> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	Integer deleteByKey(String id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	Integer deleteByKeys(List<String> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	Integer updateEmployeeByKey(Employee employee);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param employeeQuery
	 *            查询条件
	 * @return
	 */
	PageBean getEmployeeListWithPage(EmployeeQuery employeeQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param employeeQuery
	 *            查询条件
	 * @return
	 */
	List<Employee> getEmployeeList(EmployeeQuery employeeQuery);
}
