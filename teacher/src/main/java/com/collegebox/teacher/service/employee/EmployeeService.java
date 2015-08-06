package com.collegebox.teacher.service.employee;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.collegebox.teacher.pojo.employee.Employee;

public interface EmployeeService {
	
	Employee findByUsername(String username);
	
	Collection<GrantedAuthority> loadEmployeeAuthorities(Employee employee);

}
