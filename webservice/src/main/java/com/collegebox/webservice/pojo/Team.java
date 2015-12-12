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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "c_team")
public class Team {
	
	@Id
	@Column(name = "team_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "team_name", unique = true, nullable = false, length = 50)
	private String name;
	
	@Column(name = "team_remark", length = 500)
	private String remark;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, name = "student_create_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	@CreatedDate
	private Date createDate = new Date();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
			fetch = FetchType.LAZY)
	@JoinTable(name = "c_student_team", 
	   	   joinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "team_id")},
	   	   inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "student_id")})
	private List<Student> students;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
			fetch = FetchType.LAZY)
	@JoinTable(name = "c_employee_team", 
	   	   joinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "team_id")},
	   	   inverseJoinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")})
	private List<Employee> employees;
	
	@OneToMany(mappedBy="team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TeamDoc> teamDocs;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<TeamDoc> getTeamDocs() {
		return teamDocs;
	}

	public void setTeamDocs(List<TeamDoc> teamDocs) {
		this.teamDocs = teamDocs;
	}

}
