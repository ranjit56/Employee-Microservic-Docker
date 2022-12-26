package com.employee.microservice.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee.microservice.entity.Employee;
import com.employee.microservice.service.EmployeeService;
import com.employee.microservice.vo.ResponseTempleteVo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	RestTemplate restTemplate;

	private static final String Employee_Microservice = "employee-microservice";
	/**
	 * @apiNote save the details
	 */
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		logger.info("Employee data is created");
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/{id}")
	@CircuitBreaker(name = Employee_Microservice, fallbackMethod = "employeeServiceFallBackMethod")
//	@Retry(name = Employee_Microservice)
//	@RateLimiter(name = Employee_Microservice)
	public ResponseTempleteVo getEmployeeWithDepartment(@PathVariable("id") Long id) {
		logger.info("Employee data is Fetch");
		int count = 1;
		System.out.println("Retry method is called " + count++ + "time at " + new Date());
		return employeeService.getEmployeeWithDeptments(id);

	}

	public ResponseTempleteVo employeeServiceFallBackMethod(Exception e) {
		ResponseTempleteVo responseTempleteVo = new ResponseTempleteVo();
		String message = "Service is Down, Please try again later";
		responseTempleteVo.setMessage(message);
		return responseTempleteVo;
	}

}
