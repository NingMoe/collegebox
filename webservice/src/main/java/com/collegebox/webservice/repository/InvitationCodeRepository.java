package com.collegebox.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.collegebox.webservice.pojo.InvitationCode;

@Transactional
public interface InvitationCodeRepository extends JpaRepository<InvitationCode, Long>, JpaSpecificationExecutor<InvitationCode> {
	
	int countByCodeValue(String codeValue);

}
