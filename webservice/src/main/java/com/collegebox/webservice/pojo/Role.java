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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "c_role")
public class Role {
	
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "role_mark", unique = true, nullable = false, length = 32)
	private String mark;
	
	@Column(name = "role_name", unique = true, nullable = false, length = 32)
	private String name;
	
	@Column(name = "role_desc", length = 200)
	private String desc;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
				fetch = FetchType.LAZY)
	@JoinTable(name = "c_user_role", 
		   	   joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
		   	   inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")})
	@JsonIgnore
	private List<User> users;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
				fetch = FetchType.LAZY)
	@JoinTable(name = "c_role_resource", 
		   	   joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
		   	   inverseJoinColumns = {@JoinColumn(name = "resource_id", referencedColumnName = "resource_id")})
	private List<Resource> resources;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

}
