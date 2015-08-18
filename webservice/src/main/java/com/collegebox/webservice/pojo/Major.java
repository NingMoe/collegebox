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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "major")
public class Major {
	
	@Id
	@Column(name = "major_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "major_name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "major_intro", length = 500)
	private String intro;
	
	@Column(name = "major_website", length = 200)
	private String website;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "school_id")
	private School school;
	
	@OneToMany(mappedBy="major", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Degree> degrees;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Set<Degree> getDegrees() {
		return degrees;
	}

	public void setDegrees(Set<Degree> degrees) {
		this.degrees = degrees;
	}

}
