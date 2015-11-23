package com.collegebox.webservice.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "c_invitation_code")
public class InvitationCode {
	
	@Id
	@Column(name = "code_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "code_value", unique = true, nullable = false, length = 6)
	private String codeValue;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "code_status")
	private InvitationCodeStatus codeStatus;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
			   fetch = FetchType.LAZY)
	@JoinColumn(name = "agency_id")
	private Agency agency;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
			   fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "code_inviting_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date invitingDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "code_used_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date usedDate;
	
	public enum InvitationCodeStatus {
		UNUSED("UNUSED"), INVITING("INVITING"), USED("USED"), DISABLED("DISABLED");
		private final String value;
		String getValue() {
            return value;
        }
		InvitationCodeStatus(String value) {
			this.value = value;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public InvitationCodeStatus getCodeStatus() {
		return codeStatus;
	}

	public void setCodeStatus(InvitationCodeStatus codeStatus) {
		this.codeStatus = codeStatus;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getInvitingDate() {
		return invitingDate;
	}

	public void setInvitingDate(Date invitingDate) {
		this.invitingDate = invitingDate;
	}

	public Date getUsedDate() {
		return usedDate;
	}

	public void setUsedDate(Date usedDate) {
		this.usedDate = usedDate;
	}
	

}
