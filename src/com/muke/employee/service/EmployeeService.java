package com.muke.employee.service;

import com.muke.employee.domain.Employee;
import com.muke.employee.domain.PageBean;

/*
 * Ա�������ҵ���ӿ�
 */
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findAll(Integer currPage);

	Employee findById(Integer eid);

	void save(Employee employee);

	void update(Employee employee);

	void delete(Employee employee);

}
