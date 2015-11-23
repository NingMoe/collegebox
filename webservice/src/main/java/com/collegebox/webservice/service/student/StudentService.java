package com.collegebox.webservice.service.student;

import java.util.List;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.Follow;
import com.collegebox.webservice.pojo.Student;
import com.collegebox.webservice.pojo.StudentDoc;
import com.collegebox.webservice.pojo.TargetCollege;
import com.collegebox.webservice.pojo.TeamDoc;

public interface StudentService {
	
	public void registerEmail(String email, String url) throws CollegeBoxException;
	
	public Student register(Student student) throws CollegeBoxException;
	
	public void editBasicInfo(Student student) throws CollegeBoxException;
	
	public void delete(Long id);
	
	public void editPassword(String currPassword, String newPassword) throws CollegeBoxException;
	
	public void forgetPasswordEmail(String username, String url);
	
	public void resetPassword(String newPassword);
	
	public Student findOne(Long id) throws CollegeBoxException;
	
	public StudentDoc uploadStudentDoc(StudentDoc studentDoc);
	
	public TeamDoc uploadTeamDoc(TeamDoc teamDoc);
	
	public void joinAgency(String codeValue);
	
	public void setTargetColleges(List<TargetCollege> targetColleges);
	
	public void setFollows(List<Follow> follows);

}
