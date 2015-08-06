package com.collegebox.teacher.service.employee.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.collegebox.teacher.dao.employee.EmployeeDao;
import com.collegebox.teacher.dao.role.RoleDao;
import com.collegebox.teacher.pojo.employee.Employee;
import com.collegebox.teacher.pojo.role.Role;
import com.collegebox.teacher.service.employee.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public Employee findByUsername(String username) {
		// TODO Auto-generated method stub
		return employeeDao.findByUsername(username);
	}

	@Override
	public Collection<GrantedAuthority> loadEmployeeAuthorities(Employee employee) {
		// TODO Auto-generated method stub
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		List<Role> roleList = roleDao.getRoles(employee.get_links().getRoles().getHref());
		
		for(Role role : roleList) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getMark());
			auths.add(grantedAuthority);
		}
		
		return auths;
	}

}
