package com.collegebox.webservice.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c_email_log")
public class EmailLog {
	
	@Id
	@Column(name = "email_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "email_from", length = 100)
	private String from;
	
	@Column(name = "email_subject", length = 100)
	private String subject;
	
	@Column(name = "email_text", length = 1024)
	private String text;
	
	@Column(name = "email_tos", length = 2048)
	private String tos;
	
	@Column(name = "email_ccs", length = 2048)
	private String ccs;
	
	@Column(name = "email_bccs", length = 2048)
	private String bccs;
	
	@Column(name = "email_replyto", length = 2048)
	private String replyTo;
	
	@Column(name = "email_files", length = 2048)
	private String files;
	
	@Column(name = "template_id")
	private Long template_id;
	
	@Column(name = "email_params", length = 2048)
	private String params;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTos() {
		return tos;
	}

	public void setTos(String tos) {
		this.tos = tos;
	}

	public String getCcs() {
		return ccs;
	}

	public void setCcs(String ccs) {
		this.ccs = ccs;
	}

	public String getBccs() {
		return bccs;
	}

	public void setBccs(String bccs) {
		this.bccs = bccs;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public Long getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(Long template_id) {
		this.template_id = template_id;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

}
