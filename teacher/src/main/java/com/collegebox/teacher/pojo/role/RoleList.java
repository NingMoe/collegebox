package com.collegebox.teacher.pojo.role;

import com.collegebox.teacher.pojo.base.Page;
import com.collegebox.teacher.pojo.base.BaseLinks;

public class RoleList {
	
	private BaseLinks _links;
	
	private Embedded _embedded;
	
	private Page page;

	public BaseLinks get_links() {
		return _links;
	}

	public void set_links(BaseLinks _links) {
		this._links = _links;
	}

	public Embedded get_embedded() {
		return _embedded;
	}

	public void set_embedded(Embedded _embedded) {
		this._embedded = _embedded;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
