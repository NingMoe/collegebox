package com.collegebox.teacher.pojo.role;

import com.collegebox.teacher.pojo.base.BaseLinks;

public class Links extends BaseLinks {
	
	private Resources resources;
	
	private Employees employees;

	public Resources getResources() {
		return resources;
	}

	public void setResources(Resources resources) {
		this.resources = resources;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

}
