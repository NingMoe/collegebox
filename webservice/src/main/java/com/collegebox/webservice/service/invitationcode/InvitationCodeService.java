package com.collegebox.webservice.service.invitationcode;

import javax.jws.WebService;

import com.collegebox.webservice.exception.CollegeBoxException;

@WebService
public interface InvitationCodeService {
	
	public void gererateInvitaitonCode(Integer counts, Long agencyId);
	
	public void inviting(Long id) throws CollegeBoxException;
	
	public void inviteStudent(Long id, Long studentId) throws CollegeBoxException;

}
