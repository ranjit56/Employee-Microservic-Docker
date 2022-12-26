package com.employee.microservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.microservice.entity.Employee;
import com.employee.microservice.repository.EmployeeRepository;
import com.employee.microservice.vo.EmployeeDepartment;
import com.employee.microservice.vo.ResponseTempleteVo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.transaction.Transactional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	public List<Employee> getAllEmployees() {
		List<Employee> employee = employeeRepository.findAll();
		System.out.println("Getting the data from the Test: "+ employee );
		return employee;
	}

	@Transactional
	public Employee saveEmployee(Employee employee) {
		logger.info("Employee Data is cteated");
	return employeeRepository.saveAndFlush(employee);
	}

	@Transactional
	public Employee getEmployeeById(long id) {
		logger.info("Employee Data is getbyid");
		return employeeRepository.findById(id).orElse(null);

	}

	@Transactional
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}
	
//	@Value("${microservice.employeedepartment-microservice.endpoints.endpoint.url}")
//	private String ENDPOINT_URL;
	

	public ResponseTempleteVo getEmployeeWithDeptments(Long id) {
		logger.info("Employee Data is getEmployeeWithDeptments");
		ResponseTempleteVo responseTempleteVo = new ResponseTempleteVo();
		Employee employee = employeeRepository.findEmployeeById(id);
		EmployeeDepartment employeeDepartment = restTemplate.getForObject("http://EMPLOYEEDEPARTMENT-MICROSERVICE/departments/"+ employee.getDepartmentId(), EmployeeDepartment.class);
		
		responseTempleteVo.setEmployee(employee);
		responseTempleteVo.setEmployeeDepartment(employeeDepartment);
		return responseTempleteVo;
				
	}

	
}
