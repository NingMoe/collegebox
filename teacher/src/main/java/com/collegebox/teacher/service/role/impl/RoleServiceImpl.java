package com.collegebox.teacher.service.role.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegebox.teacher.dao.resource.ResourceDao;
import com.collegebox.teacher.dao.role.RoleDao;
import com.collegebox.teacher.pojo.resource.Resource;
import com.collegebox.teacher.pojo.role.Role;
import com.collegebox.teacher.service.role.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	static Logger logger = Logger.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private ResourceDao resourceDao;

	@Override
	public List<Role> getRoles(String url) {
		// TODO Auto-generated method stub
		return roleDao.getRoles(url);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return roleDao.count();
	}

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleDao.getAllRoles();
	}
	
	@Override
	public List<Role> loadResources(List<Role> roles) {
		// TODO Auto-generated method stub
		for(Role role : roles) {
			List<Resource> resources = resourceDao.getResources(role.get_links().getResources().getHref());
			role.setResources(resources);
		}
		return roles;
	}
	
}
