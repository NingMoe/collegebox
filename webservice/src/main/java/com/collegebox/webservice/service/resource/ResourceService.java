package com.collegebox.webservice.service.resource;

import java.util.List;

import com.collegebox.webservice.pojo.Resource;

public interface ResourceService {
	
	public Resource add(Resource resource);
	
	public Resource edit(Resource resource);
	
	public void delete(Long id);
	
	public List<Resource> findAll();

}
