package com.employee.microservice.vo;

public class EmployeeDepartment {
	
   private Long departmentId;
	
	private String deptName;

	

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public EmployeeDepartment(Long departmentId, String deptName) {
		super();
		this.departmentId = departmentId;
		this.deptName = deptName;
	}

	public EmployeeDepartment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
