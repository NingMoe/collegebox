package com.collegebox.webservice.service.student;

import java.util.List;

import javax.jws.WebService;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.Follow;
import com.collegebox.webservice.pojo.Student;
import com.collegebox.webservice.pojo.StudentDoc;
import com.collegebox.webservice.pojo.TargetCollege;
import com.collegebox.webservice.pojo.TeamDoc;
import com.collegebox.webservice.pojo.User;

@WebService
public interface StudentService {
	
	public void registerEmail(String email, String url) throws CollegeBoxException;
	
	public void register(User user) throws CollegeBoxException;
	
	public void editBasicInfo(Student student) throws CollegeBoxException;
	
	public Student findOne(Long id) throws CollegeBoxException;
	
	public StudentDoc uploadStudentDoc(StudentDoc studentDoc);
	
	public TeamDoc uploadTeamDoc(TeamDoc teamDoc);
	
	public void joinAgency(String codeValue);
	
	public void setTargetColleges(List<TargetCollege> targetColleges);
	
	public void setFollows(List<Follow> follows);

}
