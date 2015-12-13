package com.collegebox.webservice.service.employee;

import java.util.List;

import javax.jws.WebService;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.Employee;
import com.collegebox.webservice.pojo.Role;
import com.collegebox.webservice.pojo.TeamDoc;
import com.collegebox.webservice.pojo.User;

@WebService
public interface EmployeeService {
	
	public Employee add(User user) throws CollegeBoxException;
	
	public Employee findOne(Long id);
	
	public void setRoles(Long id, List<Role> roles);
	
	public TeamDoc uploadTeamDoc(TeamDoc teamDoc);
	
	public List<Employee> findAll();

}
