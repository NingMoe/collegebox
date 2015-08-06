package com.collegebox.rest.pojo;

import java.util.Date;
import java.util.Set;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "employee_name", unique = true, nullable = false, length = 32)
	private String username;
	
	@Column(name = "employee_password", nullable = false, length = 32)
	private String password;
	
	@Column(name = "employee_firstname", nullable = false, length = 32)
	private String firstName;
	
	@Column(name = "employee_lastname", nullable = false, length = 32)
	private String lastName;
	
	@Column(name = "employee_email", length = 200)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, name = "employee_create_date")
	private Date createDate = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "employee_last_modified_date")
	private Date lastModifiedDate =  new Date();
	
	@Column(name = "employee_enabled", nullable = false)
	private boolean enabled = true;
	
	@Column(name = "employee_account_non_expired", nullable = false)
	private boolean accountNonExpired = true;
	
	@Column(name = "employee_account_non_locked", nullable = false)
	private boolean accountNonLocked = true;
	
	@Column(name = "employee_credentials_non_expired", nullable = false)
	private boolean credentialsNonExpired = true;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
				fetch = FetchType.EAGER)
	@JoinTable(name = "employee_role", 
			   joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")},
			   inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
	private Set<Role> roles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
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

}
