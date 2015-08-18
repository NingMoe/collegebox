package com.collegebox.webservice.pojo;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "role_mark", unique = true, nullable = false, length = 32)
	private String mark;
	
	@Column(name = "role_name", unique = true, nullable = false, length = 32)
	private String name;
	
	@Column(name = "role_desc", length = 200)
	private String desc;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
				fetch = FetchType.LAZY)
	@JoinTable(name = "employee_role", 
		   	   joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
		   	   inverseJoinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")})
	@JsonIgnore
	private Set<Employee> employees;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
				fetch = FetchType.LAZY)
	@JoinTable(name = "role_resource", 
		   	   joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
		   	   inverseJoinColumns = {@JoinColumn(name = "resource_id", referencedColumnName = "resource_id")})
	private Set<Resource> resources;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

}
