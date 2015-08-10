package com.collegebox.webservice.jsonrpc.employee.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegebox.webservice.pojo.Employee;
import com.collegebox.webservice.repository.EmployeeRepository;
import com.collegebox.webservice.jsonrpc.employee.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Log log = LogFactory.getLog(EmployeeService.class);
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee findOne(long id) {
		log.info("rpc request, method:findOne, param:long id=" + id);
		return employeeRepository.findOne(id);
	}

}
