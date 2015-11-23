package com.collegebox.webservice.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "c_college")
public class College {
	
	@Id
	@Column(name = "college_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "college_name", unique = true, nullable = false, length = 50)
	private String name;
	
	@Column(name = "college_country", length = 50)
	private String country;
	
	@Column(name = "college_area", length = 50)
	private String area;
	
	@Column(name = "college_ranking")
	private int ranking = 9999;
	
	@Column(name = "college_intro", length = 500)
	private String intro;
	
	@Column(name = "college_website", length = 200)
	private String website;
	
	@Column(name = "college_surrounding", length = 200)
	private String surrounding;
	
	@Column(name = "college_logo_url", length = 500)
	private String logoUrl;
	
	@OneToMany(mappedBy="college", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<School> schools;
	
	@OneToMany(mappedBy="college", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<TargetCollege> targetColleges;

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
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

	public String getSurrounding() {
		return surrounding;
	}

	public void setSurrounding(String surrounding) {
		this.surrounding = surrounding;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}

	public List<TargetCollege> getTargetColleges() {
		return targetColleges;
	}

	public void setTargetColleges(List<TargetCollege> targetColleges) {
		this.targetColleges = targetColleges;
	}

}
