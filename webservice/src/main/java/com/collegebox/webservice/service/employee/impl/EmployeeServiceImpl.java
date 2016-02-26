package com.collegebox.webservice.service.employee.impl;

import java.util.List;

import javax.jws.WebService;

import org.apache.cxf.feature.Features;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.Employee;
import com.collegebox.webservice.pojo.Role;
import com.collegebox.webservice.pojo.TeamDoc;
import com.collegebox.webservice.pojo.User;
import com.collegebox.webservice.repository.EmployeeRepository;
import com.collegebox.webservice.repository.UserRepository;
import com.collegebox.webservice.service.employee.EmployeeService;
import com.collegebox.webservice.util.AssertUtil;

@Service
@WebService(endpointInterface = "com.collegebox.webservice.service.employee.EmployeeService", serviceName = "employeeService")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public Employee add(User user) throws CollegeBoxException {
		// TODO Auto-generated method stub
		AssertUtil.notNull(user.getUsername(), CollegeBoxException.UsernameRequired);
		AssertUtil.notNull(user.getPassword(), CollegeBoxException.PasswordRequired);
		AssertUtil.notNull(user.getFirstName(), CollegeBoxException.FirstNameRequired);
		AssertUtil.notNull(user.getLastName(), CollegeBoxException.LastNameRequired);
		AssertUtil.notNull(user.getNickName(), CollegeBoxException.NickNameRequired);
		AssertUtil.notNull(user.getEmail(), CollegeBoxException.EmailRequired);
		
		AssertUtil.isTrue(userRepository.countByUsername(user.getUsername()) == 0, CollegeBoxException.UsernameInvalid);
		AssertUtil.isTrue(userRepository.countByEmail(user.getEmail()) == 0, CollegeBoxException.EmailInvalid);
		
		Employee employee = new Employee();
		employee.setUser(user);
		
		Employee registeredEmployee = employeeRepository.save(employee);
		
		return registeredEmployee;
		
	}

	@Override
	public Employee findOne(Long id) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(id, CollegeBoxException.IdRequired);
		return employeeRepository.findOne(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public void setRoles(Long employeeId, List<String> roleIds) {
		// TODO Auto-generated method stub
		if (roles != null && roles.size() > 0) {
			for (Role role : roles) {
				AssertUtil.notNull(role.getName(), CollegeBoxException.NameRequired);
				AssertUtil.notNull(role.getMark(), CollegeBoxException.MarkRequired);
			}
		}
		Employee employee = employeeRepository.findOne(id);
		employee.getUser().setRoles(roles);
		employeeRepository.save(employee);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public TeamDoc uploadTeamDoc(TeamDoc teamDoc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

}
