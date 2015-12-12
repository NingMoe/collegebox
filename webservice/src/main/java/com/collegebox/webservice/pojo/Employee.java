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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "c_employee")
public class Employee {
	
	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
			   fetch = FetchType.LAZY)
	@JoinColumn(name = "agency_id")
	private Agency agency;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
			fetch = FetchType.LAZY)
	@JoinTable(name = "c_employee_team", 
		   joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")},
		   inverseJoinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "team_id")})
	private List<Team> teams;
	
	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<TeamDoc> getTeamDocs() {
		return teamDocs;
	}

	public void setTeamDocs(List<TeamDoc> teamDocs) {
		this.teamDocs = teamDocs;
	}

	

}
