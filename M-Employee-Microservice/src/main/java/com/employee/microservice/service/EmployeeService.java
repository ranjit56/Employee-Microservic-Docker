package com.employee.microservice.service;

import java.util.List;

import com.employee.microservice.entity.Employee;
import com.employee.microservice.vo.ResponseTempleteVo;




public interface EmployeeService {
	List<Employee> getAllEmployees();
	public Employee saveEmployee(Employee employee);
	public Employee getEmployeeById(long id);
	public void deleteEmployeeById(long id);
	public ResponseTempleteVo getEmployeeWithDeptments(Long id);
}
