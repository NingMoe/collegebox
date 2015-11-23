package com.collegebox.webservice.service.team;

import com.collegebox.webservice.pojo.Team;

public interface TeamService {
	
	public Team add(Team team);
	
	public void editBasicInfo(Team team);
	
	public Team findOne(Team team);
	
	public void addStudent(Long studentId);
	
	public void deleteStudent(Long studentId);
	
	public void addEmployee(Long employeeId);
	
	public void deleteEmployee(Long employeeId);
	
	public void delete(Long id);

}
