package com.muke.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.domain.Employee;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.EmployeeService;

/*
 * 员工管理的业务层的实现类
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
 
	private EmployeeDao employeeDao;

	public void setEmployeeDaoImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee existEmployee = employeeDao.findUsernamePassword(employee);
		return existEmployee;
	}
/*
 * 业务层分页查询员工的方法(non-Javadoc)
 * @see com.muke.employee.service.EmployeeService#findAll(java.lang.Integer)
 */
	public PageBean<Employee> findAll(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装么每页的数据数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总的页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
//根据员工的ID查询员工的方法
	public Employee findById(Integer eid) {
		
		 return employeeDao.findById(eid);
	}
//业务层保存员工的方法
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		 employeeDao.save(employee);
	}
//业务层修改员工的方法
	public void update(Employee employee) {
         employeeDao.update(employee);		
	}
//业务层删除与员工的方法
	public void delete(Employee employee) {
        employeeDao.delete(employee);		
	}

	}
	
