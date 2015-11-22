package com.collegebox.webservice;

import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.collegebox.webservice.repository.EmployeeRepository;
import com.collegebox.webservice.repository.RoleRepository;
import com.collegebox.webservice.Application;
import com.collegebox.webservice.pojo.Employee;
import com.collegebox.webservice.pojo.Resource;
import com.collegebox.webservice.pojo.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class EmployeeTests {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Test
	public void employeeTest() {
		
//		Employee employee = new Employee();
//		employee.setUsername("tiancaizjzk");
//		employee.setPassword("zjzk1234");
//		employee.setFirstName("健");
//		employee.setLastName("赵");
//		employee.setEmail("xiaoyaopalading@sina.com");
//		
//		Role role1 = new Role();
//		role1.setMark("SUPER");
//		role1.setName("超级管理员");
//		role1.setDesc("拥有一切权限");
//		
//		Set<Role> set = new HashSet<Role>();
//		set.add(role1);
//		employee.setRoles(set);
//		
//		employeeRepository.save(employee);
//		
//		Employee employee2 = new Employee();
//		employee2.setUsername("tiancaizkzj");
//		employee2.setPassword("zkzj5678");
//		employee2.setFirstName("康");
//		employee2.setLastName("赵");
//		employee2.setEmail("dberzi@163.com");
//		
//		Role role2 = new Role();
//		role2.setMark("ADMIN");
//		role2.setName("管理员");
//		role2.setDesc("管理系统");
//		
//		Resource resource1 = new Resource();
//		resource1.setName("首页");
//		resource1.setPath("/index");
//		resource1.setType(Resource.ResourceType.URL);
//		resource1.setDesc("首页即首页");
//		
//		Set<Resource> resourceSet1 = new HashSet<Resource>();
//		resourceSet1.add(resource1);
//		role2.setResources(resourceSet1);
//		
//		Role role3 = new Role();
//		role3.setMark("TEACHER");
//		role3.setName("教师");
//		role3.setDesc("管理学生");
//		
//		Set<Role> set2 = new HashSet<Role>();
//		set2.add(role2);
//		set2.add(role3);
//		employee2.setRoles(set2);
//		
//		employeeRepository.save(employee2);
		
		long id = 1;
		Employee curr_employee = employeeRepository.findOne(id);
		System.out.println(curr_employee.getUsername());
		List<Role> curr_set = curr_employee.getRoles();
		for(Role role : curr_set) {
			System.out.println("Mark:" + role.getMark());
		}
		
		id = 2;
		Employee curr_employee2 = employeeRepository.findOne(id);
		System.out.println(curr_employee2.getUsername());
		List<Role> curr_set2 = curr_employee2.getRoles();
		for(Role role : curr_set2) {
			System.out.println("Mark:" + role.getMark());
		}
		
//		Role role3 = new Role();
//		role3.setMark("TEACHER");
//		role3.setName("教师");
//		role3.setDesc("管理学生");
//		
//		curr_employee.getRoles().add(role3);
//		employeeRepository.save(curr_employee);
		
//		Set<Role> new_set = new HashSet<Role>();
//		
//		Role new_role = roleRepository.findOne(id);
//		new_set.add(new_role);
//		
//		curr_employee.setRoles(new_set);
//		curr_employee = employeeRepository.save(curr_employee);
//		
//		curr_set = curr_employee.getRoles();
//		for(Role role : curr_set) {
//			System.out.println("Mark:" + role.getMark());
//		}
		
	}

}
