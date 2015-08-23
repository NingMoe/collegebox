package com.collegebox.webservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.collegebox.webservice.pojo.jpa.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
	Employee findByUsername(@Param("username") String username);

}
