package com.collegebox.webservice.service.role;

import java.util.List;

import javax.jws.WebService;

import com.collegebox.webservice.pojo.Role;

@WebService
public interface RoleService {
	
	public void add(Role role);
	
	public void edit(Role role);
	
	public void delete(Long id);
	
	public List<Role> findAll();

}
