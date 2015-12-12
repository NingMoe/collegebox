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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "c_user")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(optional = true, cascade = CascadeType.ALL, mappedBy = "user")
	private Employee employee;
	
	@OneToOne(optional = true, cascade = CascadeType.ALL, mappedBy = "user")
	private Student student;
	
	@Column(name = "user_name", unique = true, nullable = false, length = 32)
	private String username;
	
	@Column(name = "user_password", nullable = false, length = 32)
	private String password;
	
	@Column(name = "user_firstname", nullable = false, length = 32)
	private String firstName;
	
	@Column(name = "user_lastname", nullable = false, length = 32)
	private String lastName;
	
	@Column(name = "user_nickname", nullable = false, length = 32)
	private String nickName;
	
	@Column(name = "user_email", unique = true, nullable = false, length = 200)
	private String email;
	
	@Column(name = "user_portrait", length = 500)
	private String portrait;
	
	@Column(name = "user_mobile", length = 20)
	private String mobile;
	
	@Column(name = "user_activationkey", length = 100)
	private String activationKey;
	
	@Column(name = "user_resetpasswordkey", length = 100)
	private String resetPasswordKey;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
			fetch = FetchType.LAZY)
	@JoinTable(name = "c_user_role", 
		   joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
		   inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
	private List<Role> roles;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, name = "user_create_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	@CreatedDate
	private Date createDate = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_last_modified_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	@LastModifiedDate
	private Date lastModifiedDate;
	
	@Column(name = "user_activated", nullable = false)
	private boolean activated = true;
	
	@Column(name = "user_account_non_expired", nullable = false)
	private boolean accountNonExpired = true;
	
	@Column(name = "user_account_non_locked", nullable = false)
	private boolean accountNonLocked = true;
	
	@Column(name = "user_credentials_non_expired", nullable = false)
	private boolean credentialsNonExpired = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
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

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
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

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public String getResetPasswordKey() {
		return resetPasswordKey;
	}

	public void setResetPasswordKey(String resetPasswordKey) {
		this.resetPasswordKey = resetPasswordKey;
	}

}
