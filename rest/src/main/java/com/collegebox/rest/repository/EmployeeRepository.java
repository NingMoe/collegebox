package com.collegebox.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.collegebox.rest.pojo.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
	Employee findByUsername(@Param("username") String username);

}
