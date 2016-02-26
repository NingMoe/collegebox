package com.collegebox.webservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.collegebox.webservice.pojo.Student;
import com.collegebox.webservice.pojo.User;
import com.collegebox.webservice.service.student.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class StudentsTest {
	
	@Autowired
	StudentService studentService;
	
	@Test
	public void register() {
		
		User user1 = new User();
		user1.setUsername("tiancaizjzk");
		user1.setPassword("zjzk1234");
		user1.setNickName("桑健斯");
		user1.setFirstName("Jian");
		user1.setLastName("赵");
		user1.setEmail("xiaoyaopalading@sina.com");
		studentService.register(user1);
		
		User user2 = new User();
		user2.setUsername("tiancaizkzj");
		user2.setPassword("zkzj5678");
		user2.setNickName("猴哥");
		user2.setFirstName("NB");
		user2.setLastName("侯");
		user2.setEmail("1181172801@qq.com");
		studentService.register(user2);
		
	}
	
	@Test
	public void editBasicInfo() {
		
		Student student1 = studentService.findOne(Long.valueOf(1));
		student1.setPrimaryCountry("英国");
		student1.setSecondaryCountry("法国");
		student1.setAbordTime("2016年7月");
		student1.setCurrMajor("管理信息系统");
		student1.setCurrCollege("河海大学");
		student1.setCurrGrade("大四");
		student1.setGpa(500.00);
		studentService.editBasicInfo(student1);
		
		Student student2 = studentService.findOne(Long.valueOf(2));
		student2.setPrimaryCountry("美国");
		student2.setSecondaryCountry("日本");
		student2.setAbordTime("2016年9月");
		student2.setCurrMajor("计算机科学与技术");
		student2.setCurrCollege("香港大学");
		student2.setCurrGrade("研二");
		student2.setGpa(610.88);
		studentService.editBasicInfo(student2);
		
	}
	

}
