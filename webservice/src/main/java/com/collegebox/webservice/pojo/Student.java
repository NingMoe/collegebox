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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "c_student")
public class Student {
	
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "student_primary_country", length = 50)
	private String primaryCountry;
	
	@Column(name = "student_secondary_country", length = 50)
	private String secondaryCountry;
	
	@Column(name = "student_abord_time", length = 50)
	private String abordTime;
	
	@Column(name = "student_curr_major", length = 50)
	private String currMajor;
	
	@Column(name = "student_curr_college", length = 50)
	private String currCollege;
	
	@Column(name = "student_curr_grade", length = 50)
	private String currGrade;
	
	@Column(name = "student_gpa")
	private Double gpa;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
			fetch = FetchType.LAZY)
	@JoinTable(name = "c_student_agency", 
		   joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "student_id")},
		   inverseJoinColumns = {@JoinColumn(name = "agency_id", referencedColumnName = "agency_id")})
	private List<Agency> agencies;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
			fetch = FetchType.LAZY)
	@JoinTable(name = "c_student_team", 
		   joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "student_id")},
		   inverseJoinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "team_id")})
	private List<Team> teams;
	
	@OneToMany(mappedBy="student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<InvitationCode> invitationCodes;
	
	@OneToMany(mappedBy="student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Follow> follows;
	
	@OneToMany(mappedBy="student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TargetCollege> targetColleges;
	
	@OneToMany(mappedBy="student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<StudentDoc> studentDocs;
	
	@OneToMany(mappedBy="student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TeamDoc> teamDocs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPrimaryCountry() {
		return primaryCountry;
	}

	public void setPrimaryCountry(String primaryCountry) {
		this.primaryCountry = primaryCountry;
	}

	public String getSecondaryCountry() {
		return secondaryCountry;
	}

	public void setSecondaryCountry(String secondaryCountry) {
		this.secondaryCountry = secondaryCountry;
	}

	public String getAbordTime() {
		return abordTime;
	}

	public void setAbordTime(String abordTime) {
		this.abordTime = abordTime;
	}

	public String getCurrMajor() {
		return currMajor;
	}

	public void setCurrMajor(String currMajor) {
		this.currMajor = currMajor;
	}

	public String getCurrCollege() {
		return currCollege;
	}

	public void setCurrCollege(String currCollege) {
		this.currCollege = currCollege;
	}

	public String getCurrGrade() {
		return currGrade;
	}

	public void setCurrGrade(String currGrade) {
		this.currGrade = currGrade;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public List<Agency> getAgencies() {
		return agencies;
	}

	public void setAgencies(List<Agency> agencies) {
		this.agencies = agencies;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<InvitationCode> getInvitationCodes() {
		return invitationCodes;
	}

	public void setInvitationCodes(List<InvitationCode> invitationCodes) {
		this.invitationCodes = invitationCodes;
	}

	public List<Follow> getFollows() {
		return follows;
	}

	public void setFollows(List<Follow> follows) {
		this.follows = follows;
	}

	public List<TargetCollege> getTargetColleges() {
		return targetColleges;
	}

	public void setTargetColleges(List<TargetCollege> targetColleges) {
		this.targetColleges = targetColleges;
	}

	public List<StudentDoc> getStudentDocs() {
		return studentDocs;
	}

	public void setStudentDocs(List<StudentDoc> studentDocs) {
		this.studentDocs = studentDocs;
	}

	public List<TeamDoc> getTeamDocs() {
		return teamDocs;
	}

	public void setTeamDocs(List<TeamDoc> teamDocs) {
		this.teamDocs = teamDocs;
	}

}
