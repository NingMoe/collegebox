package com.collegebox.teacher.dao.employee;

import com.collegebox.teacher.pojo.employee.Employee;

public interface EmployeeDao {
	
	Employee findByUsername(String username);

}
