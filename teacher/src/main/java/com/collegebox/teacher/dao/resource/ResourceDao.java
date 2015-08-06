package com.collegebox.teacher.dao.resource;

import java.util.List;

import com.collegebox.teacher.pojo.resource.Resource;

public interface ResourceDao {
	
	List<Resource> getResources(String url);

}
