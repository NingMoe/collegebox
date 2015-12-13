package com.collegebox.webservice.service.user;

import java.util.List;

import javax.jws.WebService;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.User;

@WebService
public interface UserService {
	
	public void delete(Long id);
	
	public void editPassword(Long id, String currPassword, String newPassword) throws CollegeBoxException;
	
	public void forgetPasswordEmail(String username, String url);
	
	public void resetPassword(Long id, String newPassword);
	
	public int countByUsername(String username);
	
	public int countByEmail(String email);
	
	public void editBasicInfo(User user);
	
	public List<User> findAll();

}
