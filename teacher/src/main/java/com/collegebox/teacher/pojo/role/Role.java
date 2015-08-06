package com.collegebox.teacher.pojo.role;

import java.util.List;

import com.collegebox.teacher.pojo.resource.Resource;

public class Role {
	
	private String mark;
	
	private String name;
	
	private String desc;
	
	private Links _links;
	
	private List<Resource> resources;

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

	public Links get_links() {
		return _links;
	}

	public void set_links(Links _links) {
		this._links = _links;
	}
	
	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

}
