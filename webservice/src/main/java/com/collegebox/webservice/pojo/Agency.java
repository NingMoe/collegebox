package com.collegebox.webservice.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "c_agency")
public class Agency {
	
	@Id
	@Column(name = "agency_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "agency_name", unique = true, nullable = false, length = 50)
	private String name;
	
	@Column(name = "agency_intro", length = 500)
	private String intro;
	
	@Column(name = "agency_address", length = 200)
	private String address;
	
	@Column(name = "agency_website", length = 200)
	private String website;
	
	@Column(name = "agency_logo_url", length = 500)
	private String logoUrl;
	
	@OneToMany(mappedBy="agency", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Employee> employees;
	
	@OneToMany(mappedBy="agency", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<InvitationCode> invitationCodes;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
			fetch = FetchType.LAZY)
	@JoinTable(name = "c_student_agency", 
	   	   joinColumns = {@JoinColumn(name = "agency_id", referencedColumnName = "agency_id")},
	   	   inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "student_id")})
	private List<Student> students;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public List<InvitationCode> getInvitationCodes() {
		return invitationCodes;
	}

	public void setInvitationCodes(List<InvitationCode> invitationCodes) {
		this.invitationCodes = invitationCodes;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
