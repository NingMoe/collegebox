package com.collegebox.webservice.service.teamdoc;

import java.util.List;

import com.collegebox.webservice.pojo.TeamDoc;

public interface TeamDocService {
	
	public List<TeamDoc> findByStudent(Long id);
	
	public List<TeamDoc> findByEmployee(Long id);
	
	public List<TeamDoc> findAll();
	
	public void delete(Long id);

}
