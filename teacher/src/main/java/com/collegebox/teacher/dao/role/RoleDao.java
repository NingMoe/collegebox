package com.collegebox.teacher.dao.role;

import java.util.List;

import com.collegebox.teacher.pojo.role.Role;

public interface RoleDao {
	
	List<Role> getRoles(String url);
	
	long count();
	
	List<Role> getAllRoles();
	
}
