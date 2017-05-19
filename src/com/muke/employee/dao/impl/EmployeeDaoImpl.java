package com.muke.employee.dao.impl;
/*
 * Ա������DAO���ʵ����
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
//dao�и���Ա����id��ѯԱ���ķ���
	public Employee findById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}
//dao�б���Ա���ķ���
	public void save(Employee employee) {
 this.getHibernateTemplate().save(employee);	
	}
//dao�и���Ա���ķ���
	public void update(Employee employee) {
 this.getHibernateTemplate().update(employee);		
	}
//dao��ɾ��Ա���ķ���
	public void delete(Employee employee) {
		
		this.getHibernateTemplate().delete(employee);
		
	}
}
