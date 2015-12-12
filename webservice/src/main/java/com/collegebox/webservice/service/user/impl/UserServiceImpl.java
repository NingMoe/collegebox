package com.collegebox.webservice.service.user.impl;

import javax.jws.WebService;

import org.apache.cxf.feature.Features;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.User;
import com.collegebox.webservice.repository.UserRepository;
import com.collegebox.webservice.service.email.EmailService;
import com.collegebox.webservice.service.user.UserService;
import com.collegebox.webservice.util.AssertUtil;

@Service
@WebService(endpointInterface = "com.collegebox.webservice.service.user.UserService", serviceName = "userService")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmailService emailService;

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

	@Override
	public void editPassword(Long id, String currPassword, String newPassword) throws CollegeBoxException {
		// TODO Auto-generated method stub
		AssertUtil.notNull(id, CollegeBoxException.IdRequired);
		AssertUtil.notNull(currPassword, CollegeBoxException.PasswordRequired);
		AssertUtil.notNull(newPassword, CollegeBoxException.NewPasswordRequired);
		
		if (currPassword.equals(userRepository.findPasswordById(id))) {
			userRepository.editPassword(id, newPassword);
		} else {
			throw new CollegeBoxException(CollegeBoxException.PasswordInvalid);
		}
		
	}

	@Override
	public void forgetPasswordEmail(String email, String url) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(email, CollegeBoxException.EmailRequired);
		AssertUtil.notNull(url, CollegeBoxException.UrlRequired);
		
		User user = userRepository.findByEmail(email);
		if (user != null) {
			emailService.sendForgotPasswordEmail(user, url);
		} else {
			throw new CollegeBoxException(CollegeBoxException.EmailInvalid);
		}
		
	}

	@Override
	public void resetPassword(Long id, String newPassword) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(id, CollegeBoxException.IdRequired);
		AssertUtil.notNull(newPassword, CollegeBoxException.NewPasswordRequired);
		
		userRepository.editPassword(id, newPassword);
		
	}

	@Override
	public int countByUsername(String username) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(username, CollegeBoxException.UsernameRequired);
		return userRepository.countByUsername(username);
	}

	@Override
	public int countByEmail(String email) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(email, CollegeBoxException.EmailRequired);
		return userRepository.countByEmail(email);
	}

	@Override
	public void editBasicInfo(User user) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(user.getId(), CollegeBoxException.IdRequired);
		userRepository.editBasicInfo(user);
	}

}
