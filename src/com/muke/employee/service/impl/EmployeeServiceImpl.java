package com.muke.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.domain.Employee;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.EmployeeService;

/*
 * Ա�������ҵ����ʵ����
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
 * ҵ����ҳ��ѯԱ���ķ���(non-Javadoc)
 * @see com.muke.employee.service.EmployeeService#findAll(java.lang.Integer)
 */
	public PageBean<Employee> findAll(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//��װ��ǰ��ҳ��
		pageBean.setCurrPage(currPage);
		//��װôÿҳ��������
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ�ܵ�ҳ��
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
//����Ա����ID��ѯԱ���ķ���
	public Employee findById(Integer eid) {
		
		 return employeeDao.findById(eid);
	}
//ҵ��㱣��Ա���ķ���
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		 employeeDao.save(employee);
	}
//ҵ����޸�Ա���ķ���
	public void update(Employee employee) {
         employeeDao.update(employee);		
	}
//ҵ���ɾ����Ա���ķ���
	public void delete(Employee employee) {
        employeeDao.delete(employee);		
	}

	}
	
