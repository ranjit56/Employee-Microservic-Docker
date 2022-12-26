package com.employee.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.microservice.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findEmployeeById(Long id);

}
