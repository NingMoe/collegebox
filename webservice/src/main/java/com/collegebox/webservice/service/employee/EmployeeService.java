package com.collegebox.webservice.service.employee;

import java.util.List;

import javax.jws.WebService;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.Employee;
import com.collegebox.webservice.pojo.Role;
import com.collegebox.webservice.pojo.TeamDoc;
import com.googlecode.jsonrpc4j.JsonRpcService;

@JsonRpcService("/rpc/EmployeeService")
@WebService
public interface EmployeeService {
	
	public Employee add(Employee employee) throws CollegeBoxException;
	
	public void editBasicInfo(Employee employee) throws CollegeBoxException;
	
	public void delete(Long id);
	
	public void editPassword(String currPassword, String newPassword) throws CollegeBoxException;
	
	public void forgetPasswordEmail(String username, String url);
	
	public void resetPassword(String newPassword);
	
	public Employee findOne(Long id);
	
	public void setRoles(List<Role> roles);
	
	public TeamDoc uploadTeamDoc(TeamDoc teamDoc);

}
