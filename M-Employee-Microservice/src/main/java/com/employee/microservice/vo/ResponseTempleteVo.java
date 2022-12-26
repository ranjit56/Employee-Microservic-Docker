package com.employee.microservice.vo;

import com.employee.microservice.entity.Employee;

public class ResponseTempleteVo {
	
	private String message;
	
	private Employee employee;
	
	private EmployeeDepartment employeeDepartment;
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeDepartment getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(EmployeeDepartment employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public ResponseTempleteVo(String message, Employee employee, EmployeeDepartment employeeDepartment) {
		super();
		this.message = message;
		this.employee = employee;
		this.employeeDepartment = employeeDepartment;
	}

	public ResponseTempleteVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	

}
