package com.collegebox.webservice.pojo;

import java.util.List;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "resource")
public class Resource {
	
	@Id
	@Column(name = "resource_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "resource_name", unique = true, nullable = false, length = 32)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "resource_type", nullable = false, length = 32)
	private ResourceType type;
	
	@Column(name = "resource_path", unique = true, nullable = false, length = 100)
	private String path;
	
	@Column(name = "resource_desc", length = 200)
	private String desc;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
				fetch = FetchType.LAZY)
	@JoinTable(name = "role_resource", 
			   joinColumns = {@JoinColumn(name = "resource_id", referencedColumnName = "resource_id")},
			   inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
	@JsonIgnore
	private List<Role> roles;
	
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

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public enum ResourceType {
		URL, METHOD
	}

}
