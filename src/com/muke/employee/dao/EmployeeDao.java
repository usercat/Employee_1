package com.muke.employee.dao;

import java.util.List;

import com.muke.employee.domain.Employee;

/*
 * 员工管理的DAO的接口
 */
public interface EmployeeDao {

	Employee findUsernamePassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	Employee findById(Integer eid);

	void save(Employee employee);

	void update(Employee employee);

	void delete(Employee employee);

}
