package com.muke.employee.action;

import java.util.List;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.Employee;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.muke.employee.service.EmployeeService;
import com.muke.employee.service.impl.DepartmentServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * Ա�������action
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
   //ģ������ʹ�õĶ���
   private Employee employee = new Employee();
   public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
   private EmployeeService employeeService;
 public void setEmployeeServiceImpl(EmployeeService employeeService) {
	this.employeeService = employeeService;
}
 private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
	this.departmentService = departmentService;
}
	/*
  * ��¼ִ�еķ���
  */
	public String login(){
		Employee existEmployee = employeeService.login(employee);
    System.out.println("login����ִ���ˡ�����");
    if(existEmployee == null){
     //��¼ʧ��
    	this.addActionError("�û������������");
    	return INPUT;
    }else{
    	ActionContext.getContext().getSession().put("existEmployee", existEmployee);
    	return SUCCESS;
       }
  
	}
	//���ܵ�ǰ��ҳ��
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	/*
	 * ��ҳ��ѯԱ��ִ�еķ���
	 */
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findAll(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	//���Ա���ķ���
	public String saveUi(){
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUi";
	}
	//����Ա��ִ�еķ���
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	/*
	 * �༭Ա��ִ�еķ���
	 */
	public String edit(){
		//����Ա��id��ѯԱ��
		employee = employeeService.findById(employee.getEid());
		//��ѯ���еĲ���
		List<Department> list =  departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	/*�޸�Ա��ִ�еķ���
	 * 
	 */
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
/*
 * ɾ��Ա���ķ���
 */
	public String delete(){
		
	
		employeeService.delete(employee);
		return "deleteSuc";
	}
}
