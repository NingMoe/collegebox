package com.collegebox.webservice.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "c_template")
public class Template {
	
	@Id
	@Column(name = "template_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "template_name", unique = true, nullable = false, length = 50)
	private String name;
	
	@Column(name = "template_url", unique = true, nullable = false, length = 500)
	private String url;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "template_type", nullable = false)
	private TemplateType type;
	
	@Column(name = "template_enabled", nullable = false)
	private Boolean enabled;
	
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TemplateType getType() {
		return type;
	}

	public void setType(TemplateType type) {
		this.type = type;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public enum TemplateType {
		EMAIL("EMAIL");
		private final String value;
		String getValue() {
            return value;
        }
		TemplateType(String value) {
			this.value = value;
		}
	}

}
