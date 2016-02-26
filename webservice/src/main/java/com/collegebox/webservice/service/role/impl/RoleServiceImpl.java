package com.collegebox.webservice.service.role.impl;

import java.util.List;

import javax.jws.WebService;

import org.apache.cxf.feature.Features;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public void add(Role role) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(role.getName(), CollegeBoxException.NameRequired);
		AssertUtil.notNull(role.getMark(), CollegeBoxException.MarkRequired);
		
		AssertUtil.isTrue(roleRepository.countByMark(role.getMark()) == 0, CollegeBoxException.MarkInvalid);
		AssertUtil.isTrue(roleRepository.countByMark(role.getName()) == 0, CollegeBoxException.NameInvalid);
		
		roleRepository.save(role);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public void edit(Role role) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(role.getId(), CollegeBoxException.IdRequired);
		AssertUtil.notNull(role.getName(), CollegeBoxException.NameRequired);
		AssertUtil.notNull(role.getMark(), CollegeBoxException.MarkRequired);
		
		Role db_role = roleRepository.findOne(role.getId());
		
		int countByMark = roleRepository.countByMark(role.getMark());
		AssertUtil.isTrue(
				countByMark == 0 || countByMark > 0 && db_role.getMark().equals(role.getMark()), 
				CollegeBoxException.MarkInvalid);
		
		int countByName = roleRepository.countByName(role.getName());
		AssertUtil.isTrue(
				countByName == 0 || countByName > 0 && db_role.getName().equals(role.getName()), 
				CollegeBoxException.NameInvalid);
		
		roleRepository.save(role);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
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

	@Override
	public Role findOne(Long id) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(id, CollegeBoxException.IdRequired);
		return roleRepository.findOne(id);
	}

	@Override
	public Role findByMark(String mark) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(mark, CollegeBoxException.MarkRequired);
		return roleRepository.findByMark(mark);
	}

}
