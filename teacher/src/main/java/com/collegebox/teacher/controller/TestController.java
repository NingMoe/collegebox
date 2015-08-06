package com.collegebox.teacher.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collegebox.teacher.dao.employee.EmployeeDao;
import com.collegebox.teacher.pojo.DefaultResponse;

@RestController
public class TestController {
	
	static Logger logger = Logger.getLogger(TestController.class);
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value ="/test/employees/search/findByUsername", method = RequestMethod.GET)
    public DefaultResponse getEmployee(String username) {
        return new DefaultResponse("0", "Success", employeeDao.findByUsername(username));
    }

}
