package com.collegebox.teacher.dao.employee.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.collegebox.teacher.dao.BaseDao;
import com.collegebox.teacher.dao.employee.EmployeeDao;
import com.collegebox.teacher.pojo.employee.Employee;
import com.collegebox.teacher.pojo.employee.EmployeeList;

@Component
public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
	
	static Logger logger = Logger.getLogger(EmployeeDaoImpl.class);

	@Override
	public Employee findByUsername(String username) {
		// TODO Auto-generated method stub
		String url = restUrl + "/employees/search/findByUsername?username=" + username;
		logger.info("get response from url:" + url);
		EmployeeList result = restTemplate.getForObject(url, EmployeeList.class);
		return result.get_embedded().getEmployees().get(0);
	}

}
