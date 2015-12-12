package com.collegebox.webservice.service.employee.impl;

import java.util.List;

import javax.jws.WebService;

import org.apache.cxf.feature.Features;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.Employee;
import com.collegebox.webservice.pojo.Role;
import com.collegebox.webservice.pojo.TeamDoc;
import com.collegebox.webservice.repository.EmployeeRepository;
import com.collegebox.webservice.service.email.EmailService;
import com.collegebox.webservice.service.employee.EmployeeService;
import com.collegebox.webservice.util.AssertUtil;

@Service
@WebService(endpointInterface = "com.collegebox.webservice.service.employee.EmployeeService", serviceName = "employeeService")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	private EmailService emailService;

	@Override
	public Employee add(Employee employee) throws CollegeBoxException {
		// TODO Auto-generated method stub
		AssertUtil.notNull(employee.getUser().getUsername(), CollegeBoxException.UsernameRequired);
		AssertUtil.notNull(employee.getUser().getPassword(), CollegeBoxException.PasswordRequired);
		AssertUtil.notNull(employee.getUser().getFirstName(), CollegeBoxException.FirstNameRequired);
		AssertUtil.notNull(employee.getUser().getLastName(), CollegeBoxException.LastNameRequired);
		AssertUtil.notNull(employee.getUser().getNickName(), CollegeBoxException.NickNameRequired);
		AssertUtil.notNull(employee.getUser().getEmail(), CollegeBoxException.EmailRequired);
		
//		AssertUtil.isTrue(employeeRepository.countByUsername(employee.getUser().getUsername()) == 0, 
//				CollegeBoxException.UsernameInvalid);
		
		Employee registeredEmployee = employeeRepository.save(employee);
		emailService.sendEmployeeRegisterEmail(registeredEmployee);
		
		return registeredEmployee;
	}

	@Override
	public void editBasicInfo(Employee employee) throws CollegeBoxException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editPassword(String currPassword, String newPassword) throws CollegeBoxException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void forgetPasswordEmail(String username, String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetPassword(String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRoles(List<Role> roles) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TeamDoc uploadTeamDoc(TeamDoc teamDoc) {
		// TODO Auto-generated method stub
		return null;
	}

}
