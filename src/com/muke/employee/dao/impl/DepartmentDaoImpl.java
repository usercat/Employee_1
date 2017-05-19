package com.muke.employee.dao.impl;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;





/*
 * 部门管理dao层的实现类
 */
import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{ 
/*
 * 分页查询部门
 * (non-Javadoc)
 * @see com.muke.employee.dao.DepartmentDao#findByPage(int, int)
 */
	
	public List<Department> findByPage(int begin, int pageSize) {
	    DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
	    List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	public int findCount() {
	String hql = "select count(*) from Department";
	List<Long> list = this.getHibernateTemplate().find(hql);
	if(list.size() > 0){
		return list.get(0).intValue();
	}
		return 0;
	}
   //dao中保存部门的方法
	public void save(Department department) {
    this.getHibernateTemplate().save(department);		
	}
   //dao中根据部门的ID查询部门的方法
	public Department findByid(Integer did) {
		return this.getHibernateTemplate().get(Department.class,did);
	}
  //dao中修改部门的方法
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}
  //dao中删除部门的方法
	public void delete(Department department) {
        this.getHibernateTemplate().delete(department);		
	}

  //查询所有部门的方法
	public List<Department> findAll() {
		
		return this.getHibernateTemplate().find("from Department");
	}
}
