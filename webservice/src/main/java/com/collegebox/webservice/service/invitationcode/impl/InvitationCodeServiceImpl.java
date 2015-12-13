package com.collegebox.webservice.service.invitationcode.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.apache.cxf.feature.Features;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.Agency;
import com.collegebox.webservice.pojo.InvitationCode;
import com.collegebox.webservice.pojo.InvitationCode.InvitationCodeStatus;
import com.collegebox.webservice.pojo.Student;
import com.collegebox.webservice.repository.AgencyRepository;
import com.collegebox.webservice.repository.InvitationCodeRepository;
import com.collegebox.webservice.repository.StudentRepository;
import com.collegebox.webservice.service.invitationcode.InvitationCodeService;
import com.collegebox.webservice.util.AssertUtil;
import com.collegebox.webservice.util.RandomUtil;

@Service
@WebService(endpointInterface = "com.collegebox.webservice.service.invitationcode.InvitationCodeService", serviceName = "invitationCodeService")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class InvitationCodeServiceImpl implements InvitationCodeService {
	
	@Autowired
	InvitationCodeRepository invitationCodeRepository;
	
	@Autowired
	AgencyRepository agencyRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public void gererateInvitaitonCode(Integer counts, Long agencyId) {
		// TODO Auto-generated method stub
		for (int i = 0; i < counts; i++) {
			String codeValue = RandomUtil.getRandom(4);
			while (invitationCodeRepository.countByCodeValue(codeValue) > 0) {
				codeValue = RandomUtil.getRandom(4);
			}
			
			InvitationCode invitationCode = new InvitationCode();
			Agency agency = agencyRepository.findOne(agencyId);
			invitationCode.setAgency(agency);
			invitationCode.setCodeStatus(InvitationCodeStatus.UNUSED);
			invitationCode.setCodeValue(codeValue);
			
			invitationCodeRepository.save(invitationCode);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public void inviteStudent(Long id, Long studentId) throws CollegeBoxException {
		// TODO Auto-generated method stub
		InvitationCode invitationCode = invitationCodeRepository.findOne(id);
		AssertUtil.notNull(invitationCode, CollegeBoxException.InvitationCodeInvalid);
		
		Student student = studentRepository.findOne(studentId);
		AssertUtil.notNull(student, CollegeBoxException.StudentInvalid);
		
		Agency agency = invitationCode.getAgency();
		AssertUtil.notNull(agency, CollegeBoxException.InvitationCodeInvalid);
		AssertUtil.isTrue(invitationCode.getCodeStatus().equals(InvitationCodeStatus.INVITING), 
				CollegeBoxException.InvitationCodeInvalid);
		
		invitationCode.setCodeStatus(InvitationCodeStatus.USED);
		invitationCode.setUsedDate(new Date());
		invitationCode.setStudent(student);
		invitationCodeRepository.save(invitationCode);
		
		List<Agency> agencies = student.getAgencies();
		if (agencies == null) {
			agencies = new ArrayList<Agency>();
		}
		agencies.add(agency);
		
		studentRepository.setAgencies(agencies, studentId);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public void inviting(Long id) throws CollegeBoxException {
		// TODO Auto-generated method stub
		InvitationCode invitationCode = invitationCodeRepository.findOne(id);
		AssertUtil.notNull(invitationCode, CollegeBoxException.InvitationCodeInvalid);
		AssertUtil.isTrue(invitationCode.getCodeStatus().equals(InvitationCodeStatus.UNUSED), 
				CollegeBoxException.InvitationCodeInvalid);
		invitationCode.setCodeStatus(InvitationCodeStatus.INVITING);
		invitationCodeRepository.save(invitationCode);
	}

}
