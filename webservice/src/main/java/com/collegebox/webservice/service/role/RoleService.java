package com.collegebox.webservice.service.role;

import java.util.List;

import com.collegebox.webservice.pojo.Role;

public interface RoleService {
	
	public Role add(Role role);
	
	public Role edit(Role role);
	
	public void delete(Long id);
	
	public List<Role> findAll();

}
