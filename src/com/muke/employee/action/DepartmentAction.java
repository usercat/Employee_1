package com.muke.employee.action;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * ���Ź����action��
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	//ģ������ʹ�õ��ࣺ
	private Department department = new Department();
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	private Integer currPage = 1;
    public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
    //ע�벿�Ź����Service
    private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	//�ṩһ����ѯ�ķ���
	public String findAll(){
		
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//��pageBean���뵽ջ��
		ActionContext.getContext().getValueStack().push(pageBean);
	return "findAll";
	}
	//��ת����Ӳ��ŵķ���
	public String save(){
		
		return "saveui";
	}
	//��Ӳ���ִ�еķ���
	public String saveui(){
		departmentService.save(department);
		return "saveSuccess";
	}
	//�༭����ִ�еķ���
	public String edit(){
		department = departmentService.findId(department.getDid());
		return "editSuccess";
	}
	//�޸Ĳ���ִ�еķ���
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
	//ɾ�����ŵ�ִ�еķ���
	public String delete(){
		department = departmentService.findId(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
