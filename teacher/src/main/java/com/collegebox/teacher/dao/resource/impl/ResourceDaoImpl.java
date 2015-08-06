package com.collegebox.teacher.dao.resource.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.collegebox.teacher.dao.BaseDao;
import com.collegebox.teacher.dao.resource.ResourceDao;
import com.collegebox.teacher.pojo.resource.Resource;
import com.collegebox.teacher.pojo.resource.ResourceList;

@Component
public class ResourceDaoImpl extends BaseDao implements ResourceDao {
	
	static Logger logger = Logger.getLogger(ResourceDaoImpl.class);

	@Override
	public List<Resource> getResources(String url) {
		// TODO Auto-generated method stub
		logger.info("get response from url:" + url);
		ResourceList results = restTemplate.getForObject(url, ResourceList.class);
		if(results != null && results.get_embedded() != null)
			return results.get_embedded().getResources();
		return null;
	}
	
}
