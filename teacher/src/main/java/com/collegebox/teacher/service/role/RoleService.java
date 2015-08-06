package com.collegebox.teacher.service.role;

import java.util.List;

import com.collegebox.teacher.pojo.role.Role;

public interface RoleService {
	
	List<Role> getRoles(String url);
	
	long count();
	
	List<Role> getAllRoles();
	
	List<Role> loadResources(List<Role> roles);

}
