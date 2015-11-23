package com.collegebox.webservice.pojo;

import java.util.Date;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "c_follow")
public class Follow {
	
	@Id
	@Column(name = "follow_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "follow_type", nullable = false)
	private FollowType type;
	
	@Column(name = "follow_content", nullable = false, length = 500)
	private String follow_content;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, 
			   fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false, name = "student_create_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	@CreatedDate
	private Date createDate = new Date();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FollowType getType() {
		return type;
	}

	public void setType(FollowType type) {
		this.type = type;
	}

	public String getFollow_content() {
		return follow_content;
	}

	public void setFollow_content(String follow_content) {
		this.follow_content = follow_content;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public enum FollowType {
		PLAN("PLAN"), PROGRESS("PROGRESS");
		private final String value;
		String getValue() {
            return value;
        }
		FollowType(String value) {
			this.value = value;
		}
	}

}
