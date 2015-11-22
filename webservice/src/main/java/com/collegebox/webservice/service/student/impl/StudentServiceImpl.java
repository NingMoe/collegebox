package com.collegebox.webservice.service.student.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.Student;
import com.collegebox.webservice.repository.StudentRepository;
import com.collegebox.webservice.service.email.EmailService;
import com.collegebox.webservice.service.student.StudentService;
import com.collegebox.webservice.util.AssertUtil;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmailService emailService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public Student register(Student student) throws CollegeBoxException {
		// TODO Auto-generated method stub
		AssertUtil.notNull(student.getUsername(), CollegeBoxException.UsernameRequired);
		AssertUtil.notNull(student.getPassword(), CollegeBoxException.PasswordRequired);
		AssertUtil.notNull(student.getFirstName(), CollegeBoxException.FirstNameRequired);
		AssertUtil.notNull(student.getLastName(), CollegeBoxException.LastNameRequired);
		AssertUtil.notNull(student.getNickName(), CollegeBoxException.NickNameRequired);
		AssertUtil.notNull(student.getEmail(), CollegeBoxException.EmailRequired);
		
		AssertUtil.isTrue(studentRepository.countByUsername(student.getUsername()) == 0, 
				CollegeBoxException.UsernameInvalid);
		
		Student registeredStudent = studentRepository.save(student);
		emailService.sendStudentRegisterEmail(registeredStudent);
		
		return registeredStudent;
	}

	@Override
	public void registerEmail(String email, String url) throws CollegeBoxException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editBasicInfo(Student student) throws CollegeBoxException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editPassword(String currPassword, String newPassword) throws CollegeBoxException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void forgetPasswordEmail(String username, String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetPassword(String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student findOne(Long id) throws CollegeBoxException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
