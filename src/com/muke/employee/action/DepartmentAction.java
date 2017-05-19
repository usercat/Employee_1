package com.muke.employee.action;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 部门管理的action类
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	//模型驱动使用的类：
	private Department department = new Department();
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	private Integer currPage = 1;
    public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
    //注入部门管理的Service
    private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	//提供一个查询的方法
	public String findAll(){
		
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//将pageBean存入到栈中
		ActionContext.getContext().getValueStack().push(pageBean);
	return "findAll";
	}
	//跳转到添加部门的方法
	public String save(){
		
		return "saveui";
	}
	//添加部门执行的方法
	public String saveui(){
		departmentService.save(department);
		return "saveSuccess";
	}
	//编辑部门执行的方法
	public String edit(){
		department = departmentService.findId(department.getDid());
		return "editSuccess";
	}
	//修改部门执行的方法
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
	//删除部门的执行的方法
	public String delete(){
		department = departmentService.findId(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
