package com.collegebox.webservice.service.student;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.Student;

public interface StudentService {
	
	public void registerEmail(String email, String url) throws CollegeBoxException;
	
	public Student register(Student student) throws CollegeBoxException;
	
	public void editBasicInfo(Student student) throws CollegeBoxException;
	
	public void delete(Long id);
	
	public void editPassword(String currPassword, String newPassword) throws CollegeBoxException;
	
	public void forgetPasswordEmail(String username, String url);
	
	public void resetPassword(String newPassword);
	
	public Student findOne(Long id) throws CollegeBoxException;

}
