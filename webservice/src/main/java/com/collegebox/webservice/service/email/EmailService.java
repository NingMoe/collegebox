package com.collegebox.webservice.service.email;

import java.util.Map;

import com.collegebox.webservice.model.email.Email;
import com.collegebox.webservice.pojo.User;

public interface EmailService {
	
	public void sendEmail(Email email, Map<String,String> fileMap, Map<String,Object> model);
	
	public void sendStudentRegisterEmail(String email, String url);
	
	public void sendForgotPasswordEmail(User user, String url);
	
	public void sendSuccessRegisterEmail(User user);

}
