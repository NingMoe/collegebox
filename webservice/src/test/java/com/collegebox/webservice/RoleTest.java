package com.collegebox.webservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.collegebox.webservice.pojo.Role;
import com.collegebox.webservice.security.Authorities;
import com.collegebox.webservice.service.role.RoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RoleTest {
	
	@Autowired
	RoleService roleService;
	
	@Test
	public void add() {
		
		Role role1 = new Role();
		role1.setName("管理员");
		role1.setMark(Authorities.ROLE_ADMIN.name());
		role1.setDesc("管理员");
		roleService.add(role1);
		
		Role role2 = new Role();
		role2 = new Role();
		role2.setName("职员");
		role2.setMark(Authorities.ROLE_EMPLOYEE.name());
		role2.setDesc("职员");
		roleService.add(role2);
		
		Role role3 = new Role();
		role3 = new Role();
		role3.setName("测试");
		role3.setMark("TEST");
		role3.setDesc("测试");
		roleService.add(role3);
		
	}
	
	@Test
	public void edit() {
		Role role = roleService.findByMark("TEST");
		role.setName("测试2");
		role.setDesc("测试2");
		roleService.edit(role);
	}
	
	@Test
	public void delete() {
		roleService.delete(Long.valueOf(4));
	}

}
