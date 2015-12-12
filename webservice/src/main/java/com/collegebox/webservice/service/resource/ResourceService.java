package com.collegebox.webservice.service.resource;

import java.util.List;

import javax.jws.WebService;

import com.collegebox.webservice.pojo.Resource;

@WebService
public interface ResourceService {
	
	public void add(Resource resource);
	
	public void edit(Resource resource);
	
	public void delete(Long id);
	
	public List<Resource> findAll();

}
