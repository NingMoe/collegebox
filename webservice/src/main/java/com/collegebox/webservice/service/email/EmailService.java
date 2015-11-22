package com.collegebox.webservice.service.email;

import java.util.Map;

import com.collegebox.webservice.model.email.Email;
import com.collegebox.webservice.pojo.Employee;
import com.collegebox.webservice.pojo.Student;

public interface EmailService {
	
	public void sendEmail(Email email, Map<String,String> fileMap, Map<String,Object> model);
	
	public void sendStudentRegisterEmail(Student student);
	
	public void sendEmployeeRegisterEmail(Employee employee);

}
