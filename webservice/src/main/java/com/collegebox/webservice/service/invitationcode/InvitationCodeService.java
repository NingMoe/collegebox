package com.collegebox.webservice.service.invitationcode;

import java.util.List;

import com.collegebox.webservice.pojo.InvitationCode;

public interface InvitationCodeService {
	
	public List<InvitationCode> gererateInvitaitonCode(Integer counts, Long agencyId);
	
	public void inviteStudent(Long id, Long studentId);

}
