package com.collegebox.webservice.pojo;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "c_student")
public class Student {
	
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "student_name", unique = true, nullable = false, length = 32)
	private String username;
	
	@Column(name = "student_password", nullable = false, length = 32)
	private String password;
	
	@Column(name = "student_firstname", nullable = false, length = 32)
	private String firstName;
	
	@Column(name = "student_lastname", nullable = false, length = 32)
	private String lastName;
	
	@Column(name = "student_nickname", nullable = false, length = 32)
	private String nickName;
	
	@Column(name = "student_email", nullable = false, length = 200)
	private String email;
	
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
	private Float gpa;
	
	@Column(name = "student_portrait", length = 500)
	private String portrait;
	
	@Column(name = "student_mobile", length = 20)
	private String mobile;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, name = "student_create_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	@CreatedDate
	private Date createDate = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "student_last_modified_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	@LastModifiedDate
	private Date lastModifiedDate;
	
	@Column(name = "student_enabled", nullable = false)
	private boolean enabled = true;
	
	@Column(name = "student_account_non_expired", nullable = false)
	private boolean accountNonExpired = true;
	
	@Column(name = "student_account_non_locked", nullable = false)
	private boolean accountNonLocked = true;
	
	@Column(name = "student_credentials_non_expired", nullable = false)
	private boolean credentialsNonExpired = true;
	
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
	public List<TargetCollege> targetColleges;
	
	@OneToMany(mappedBy="student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<StudentDoc> studentDocs;
	
	@OneToMany(mappedBy="student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<TeamDoc> teamDocs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public List<Agency> getAgencies() {
		return agencies;
	}

	public void setAgencies(List<Agency> agencies) {
		this.agencies = agencies;
	}

	public List<InvitationCode> getInvitationCodes() {
		return invitationCodes;
	}

	public void setInvitationCodes(List<InvitationCode> invitationCodes) {
		this.invitationCodes = invitationCodes;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
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

	public Float getGpa() {
		return gpa;
	}

	public void setGpa(Float gpa) {
		this.gpa = gpa;
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