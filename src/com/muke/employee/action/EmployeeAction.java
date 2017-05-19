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
 * 员工管理的action
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
   //模型驱动使用的对象
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
  * 登录执行的方法
  */
	public String login(){
		Employee existEmployee = employeeService.login(employee);
    System.out.println("login方法执行了。。。");
    if(existEmployee == null){
     //登录失败
    	this.addActionError("用户名或密码错误！");
    	return INPUT;
    }else{
    	ActionContext.getContext().getSession().put("existEmployee", existEmployee);
    	return SUCCESS;
       }
  
	}
	//接受当前的页数
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	/*
	 * 分页查询员工执行的方法
	 */
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findAll(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	//添加员工的方法
	public String saveUi(){
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUi";
	}
	//保存员工执行的方法
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	/*
	 * 编辑员工执行的方法
	 */
	public String edit(){
		//根据员工id查询员工
		employee = employeeService.findById(employee.getEid());
		//查询所有的部门
		List<Department> list =  departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	/*修改员工执行的方法
	 * 
	 */
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
/*
 * 删除员工的方法
 */
	public String delete(){
		
	
		employeeService.delete(employee);
		return "deleteSuc";
	}
}
