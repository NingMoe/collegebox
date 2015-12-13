package com.collegebox.webservice.service.student.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.cxf.feature.Features;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.Follow;
import com.collegebox.webservice.pojo.Role;
import com.collegebox.webservice.pojo.Student;
import com.collegebox.webservice.pojo.StudentDoc;
import com.collegebox.webservice.pojo.TargetCollege;
import com.collegebox.webservice.pojo.TeamDoc;
import com.collegebox.webservice.pojo.User;
import com.collegebox.webservice.repository.RoleRepository;
import com.collegebox.webservice.repository.StudentRepository;
import com.collegebox.webservice.repository.UserRepository;
import com.collegebox.webservice.security.Authorities;
import com.collegebox.webservice.service.email.EmailService;
import com.collegebox.webservice.service.student.StudentService;
import com.collegebox.webservice.util.AssertUtil;

@Service
@WebService(endpointInterface = "com.collegebox.webservice.service.student.StudentService", serviceName = "studentService")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public void register(User user) throws CollegeBoxException {
		// TODO Auto-generated method stub
		AssertUtil.notNull(user.getUsername(), CollegeBoxException.UsernameRequired);
		AssertUtil.notNull(user.getPassword(), CollegeBoxException.PasswordRequired);
		AssertUtil.notNull(user.getFirstName(), CollegeBoxException.FirstNameRequired);
		AssertUtil.notNull(user.getLastName(), CollegeBoxException.LastNameRequired);
		AssertUtil.notNull(user.getNickName(), CollegeBoxException.NickNameRequired);
		AssertUtil.notNull(user.getEmail(), CollegeBoxException.EmailRequired);
		
		AssertUtil.isTrue(userRepository.countByUsername(user.getUsername()) == 0, CollegeBoxException.UsernameInvalid);
		AssertUtil.isTrue(userRepository.countByEmail(user.getEmail()) == 0, CollegeBoxException.EmailInvalid);
		
		// set role
		Role role = roleRepository.findByMark(Authorities.ROLE_STUDENT.name());
		if (role == null) {
			role = new Role();
			role.setName("学生");
			role.setMark("Authorities.ROLE_STUDENT.name()");
			role.setDesc("学生");
			role = roleRepository.save(role);
		}
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		user.setRoles(roles);
		
		Student student = new Student();
		student.setUser(user);
		
		Student registeredStudent = studentRepository.save(student);
		emailService.sendSuccessRegisterEmail(registeredStudent.getUser());
		
	}

	@Override
	public void registerEmail(String email, String url) throws CollegeBoxException {
		// TODO Auto-generated method stub
		AssertUtil.notNull(email, CollegeBoxException.EmailRequired);
		AssertUtil.notNull(url, CollegeBoxException.UrlRequired);
		
		emailService.sendStudentRegisterEmail(email, url);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public void editBasicInfo(Student student) throws CollegeBoxException {
		// TODO Auto-generated method stub
		AssertUtil.notNull(student.getId(), CollegeBoxException.IdRequired);
		studentRepository.editBasicInfo(student);
	}

	@Override
	public Student findOne(Long id) throws CollegeBoxException {
		// TODO Auto-generated method stub
		AssertUtil.notNull(id, CollegeBoxException.IdRequired);
		return studentRepository.findOne(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public StudentDoc uploadStudentDoc(StudentDoc studentDoc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public TeamDoc uploadTeamDoc(TeamDoc teamDoc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public void setTargetColleges(List<TargetCollege> targetColleges) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public void setFollows(List<Follow> follows) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	
}
