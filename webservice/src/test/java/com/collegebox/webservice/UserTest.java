package com.collegebox.webservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.collegebox.webservice.pojo.Employee;
import com.collegebox.webservice.pojo.Role;
import com.collegebox.webservice.pojo.Student;
import com.collegebox.webservice.pojo.User;
import com.collegebox.webservice.repository.UserRepository;
import com.collegebox.webservice.security.Authorities;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void addRolesAndUsers() throws Exception {
		
		Role role1 = new Role();
		role1.setMark(Authorities.ROLE_ADMIN.name());
		role1.setName("管理员");
		
		List<Role> roleList1 = new ArrayList<Role>();
		roleList1.add(role1);
		
		Employee employee = new Employee();
		
		User user1 = new User();
		user1.setEmail("xiaoyaopalading@sina.com");
		user1.setFirstName("健");
		user1.setLastName("赵");
		user1.setMobile("13062566184");
		user1.setNickName("逐日冰凌");
		user1.setPassword("admin");
		user1.setRoles(roleList1);
		user1.setUsername("admin");
		user1.setEmployee(employee);
		
		Role role2 = new Role();
		role2.setMark(Authorities.ROLE_STUDENT.name());
		role2.setName("学生");
		
		List<Role> roleList2 = new ArrayList<Role>();
		roleList2.add(role2);
		
		Student student = new Student();
		
		User user2 = new User();
		user2.setEmail("1181172801@qq.com");
		user2.setFirstName("康");
		user2.setLastName("赵");
		user2.setMobile("13914752619");
		user2.setNickName("deep dark fantasy");
		user2.setPassword("student");
		user2.setRoles(roleList2);
		user2.setUsername("student");
		user2.setStudent(student);
		
		userRepository.save(user1);
		userRepository.save(user2);
		
	}

}
