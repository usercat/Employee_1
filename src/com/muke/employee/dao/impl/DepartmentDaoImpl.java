package com.muke.employee.dao.impl;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;





/*
 * ���Ź���dao���ʵ����
 */
import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{ 
/*
 * ��ҳ��ѯ����
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
   //dao�б��沿�ŵķ���
	public void save(Department department) {
    this.getHibernateTemplate().save(department);		
	}
   //dao�и��ݲ��ŵ�ID��ѯ���ŵķ���
	public Department findByid(Integer did) {
		return this.getHibernateTemplate().get(Department.class,did);
	}
  //dao���޸Ĳ��ŵķ���
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}
  //dao��ɾ�����ŵķ���
	public void delete(Department department) {
        this.getHibernateTemplate().delete(department);		
	}

  //��ѯ���в��ŵķ���
	public List<Department> findAll() {
		
		return this.getHibernateTemplate().find("from Department");
	}
}
