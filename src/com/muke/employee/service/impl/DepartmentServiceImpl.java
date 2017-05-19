package com.muke.employee.service.impl;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
/*
 * ���Ź���ҵ����ʵ����
 */
import com.muke.employee.service.DepartmentService;
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
//ע�벿�Ź����Dao
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
//��ҳ��ѯ���ŵķ���
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ�ļ�¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalCount(num.intValue());
		//��װÿҳ��ʾ������
		int begin = (currPage-1)*pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	//ҵ��㱣�沿�ŵķ���
	public void save(Department department) {
 		departmentDao.save(department);
	}
	//ҵ������id��ѯ���ŵķ���
	public Department findId(Integer did) {
		return  departmentDao.findByid(did);
	}
	//�޸Ĳ��ŵ�ִ�еķ���
	public void update(Department department) {
		departmentDao.update(department);
	}
	//ҵ���ɾ�����ŵķ���
	public void delete(Department department) {
        departmentDao.delete(department);		
	}
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}

}
