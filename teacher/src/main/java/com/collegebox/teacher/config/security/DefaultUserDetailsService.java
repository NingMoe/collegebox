package com.collegebox.teacher.config.security;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.collegebox.teacher.pojo.employee.Employee;
import com.collegebox.teacher.service.employee.EmployeeService;

public class DefaultUserDetailsService implements UserDetailsService {
	
	static Logger logger = Logger.getLogger(DefaultUserDetailsService.class);
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Employee employee = null;
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		
		employee = employeeService.findByUsername(username);
		if(employee == null) {
			throw new UsernameNotFoundException(this.messageSource.getMessage(  
                    "UserDetailsService.userNotFount", new Object[]{username}, LocaleContextHolder.getLocale()));
		}
		
		auths = employeeService.loadEmployeeAuthorities(employee);
		if (auths == null || auths.isEmpty()) {
			throw new UsernameNotFoundException(this.messageSource.getMessage(  
                    "UserDetailsService.authsNotFount", new Object[]{username}, LocaleContextHolder.getLocale()));
		}
		employee.setAuthorities(auths);
		
		logger.info("*********************" + username + "*********************");
		logger.info("*********************Authorities*********************");
		logger.info(employee.getAuthorities());
		logger.info("*****************************************************");
		
		return employee;
	}
	
}
