package com.muke.employee.service.impl;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
/*
 * 部门管理业务层的实现类
 */
import com.muke.employee.service.DepartmentService;
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
//注入部门管理的Dao
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
//分页查询部门的方法
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalCount(num.intValue());
		//封装每页显示的数据
		int begin = (currPage-1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	//业务层保存部门的方法
	public void save(Department department) {
 		departmentDao.save(department);
	}
	//业务层根据id查询部门的方法
	public Department findId(Integer did) {
		return  departmentDao.findByid(did);
	}
	//修改部门的执行的方法
	public void update(Department department) {
		departmentDao.update(department);
	}
	//业务层删除部门的方法
	public void delete(Department department) {
        departmentDao.delete(department);		
	}
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}

}
