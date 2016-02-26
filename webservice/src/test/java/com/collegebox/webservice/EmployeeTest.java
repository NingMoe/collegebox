package com.collegebox.webservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.collegebox.webservice.pojo.Role;
import com.collegebox.webservice.pojo.User;
import com.collegebox.webservice.service.employee.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class EmployeeTest {
	
	@Autowired
	EmployeeService employeeService;
	
//	@Test
//	public void add() {
//		
//		User user1 = new User();
//		user1.setUsername("xiaozang");
//		user1.setPassword("888888");
//		user1.setNickName("小臧臧");
//		user1.setFirstName("Yansong");
//		user1.setLastName("臧");
//		user1.setEmail("zangyansong@qq.com");
//		employeeService.add(user1);
//		
//		User user2 = new User();
//		user2.setUsername("chaoge");
//		user2.setPassword("666666");
//		user2.setNickName("超哥");
//		user2.setFirstName("Chao");
//		user2.setLastName("李");
//		user2.setEmail("lichao1@qq.com");
//		employeeService.add(user2);
//		
//	}
	
	@Test
	public void setRoles() {
		
		List<Role> roles1 = new ArrayList<>();
		roles1.add(e)
		
		employeeService.setRoles(id, roles);
		
	}

}
