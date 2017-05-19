package com.muke.employee.dao.impl;
/*
 * 员工管理DAO层的实现类
 */
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.domain.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
	public void save(){
		
	}

	public Employee findUsernamePassword(Employee employee) {
		// TODO Auto-generated method stub
		String hql = "from Employee where username=? and password=?";
		List<Employee> list = this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	public int findCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
		return list.get(0).intValue();	
		}
		return 0;
	}

	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
//dao中根据员工的id查询员工的方法
	public Employee findById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}
//dao中保存员工的方法
	public void save(Employee employee) {
 this.getHibernateTemplate().save(employee);	
	}
//dao中更新员工的方法
	public void update(Employee employee) {
 this.getHibernateTemplate().update(employee);		
	}
//dao中删除员工的方法
	public void delete(Employee employee) {
		
		this.getHibernateTemplate().delete(employee);
		
	}
}
