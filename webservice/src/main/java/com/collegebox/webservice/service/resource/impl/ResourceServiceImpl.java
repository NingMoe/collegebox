package com.collegebox.webservice.service.resource.impl;

import java.util.List;

import javax.jws.WebService;

import org.apache.cxf.feature.Features;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.Resource;
import com.collegebox.webservice.repository.ResourceRepository;
import com.collegebox.webservice.service.resource.ResourceService;
import com.collegebox.webservice.util.AssertUtil;

@Service
@WebService(endpointInterface = "com.collegebox.webservice.service.resource.ResourceService", serviceName = "resourceService")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	ResourceRepository resourceRepository;

	@Override
	public void add(Resource resource) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(resource.getName(), CollegeBoxException.NameRequired);
		AssertUtil.notNull(resource.getPath(), CollegeBoxException.PathRequired);
		AssertUtil.notNull(resource.getType(), CollegeBoxException.TypeRequired);
		
		resourceRepository.save(resource);
	}

	@Override
	public void edit(Resource resource) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(resource.getId(), CollegeBoxException.IdRequired);
		AssertUtil.notNull(resource.getName(), CollegeBoxException.NameRequired);
		AssertUtil.notNull(resource.getPath(), CollegeBoxException.PathRequired);
		AssertUtil.notNull(resource.getType(), CollegeBoxException.TypeRequired);
		
		resourceRepository.save(resource);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(id, CollegeBoxException.IdRequired);
		resourceRepository.delete(id);
	}

	@Override
	public List<Resource> findAll() {
		// TODO Auto-generated method stub
		return resourceRepository.findAll();
	}

}
