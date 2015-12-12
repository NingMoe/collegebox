package com.collegebox.webservice.service.role.impl;

import java.util.List;

import javax.jws.WebService;

import org.apache.cxf.feature.Features;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.Role;
import com.collegebox.webservice.repository.RoleRepository;
import com.collegebox.webservice.service.role.RoleService;
import com.collegebox.webservice.util.AssertUtil;

@Service
@WebService(endpointInterface = "com.collegebox.webservice.service.role.RoleService", serviceName = "roleService")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public void add(Role role) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(role.getName(), CollegeBoxException.NameRequired);
		AssertUtil.notNull(role.getMark(), CollegeBoxException.MarkRequired);
		
		roleRepository.save(role);
	}

	@Override
	public void edit(Role role) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(role.getId(), CollegeBoxException.IdRequired);
		AssertUtil.notNull(role.getName(), CollegeBoxException.NameRequired);
		AssertUtil.notNull(role.getMark(), CollegeBoxException.MarkRequired);
		
		roleRepository.save(role);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(id, CollegeBoxException.IdRequired);
		roleRepository.delete(id);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

}
