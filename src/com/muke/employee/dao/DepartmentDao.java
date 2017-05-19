package com.muke.employee.dao;

import java.util.List;

import com.muke.employee.domain.Department;

/*
 * ���Ź���Dao��Ľӿ�
 */
public interface DepartmentDao {


	List<Department> findByPage(int begin, int pageSize);

	int findCount();

	void save(Department department);

	Department findByid(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
