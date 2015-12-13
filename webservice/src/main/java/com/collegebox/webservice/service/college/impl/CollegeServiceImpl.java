package com.collegebox.webservice.service.college.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegebox.webservice.model.elasticsearch.CollegeResponse;
import com.collegebox.webservice.service.college.CollegeService;
import com.collegebox.webservice.service.elasticsearch.SearchService;

@Service
public class CollegeServiceImpl implements CollegeService {
	
	private static final Log log = LogFactory.getLog(CollegeServiceImpl.class);
	
	@Autowired
	private SearchService searchService;

	@Override
	public CollegeResponse searchColleges(String text, int from, int size) throws Exception {
		// TODO Auto-generated method stub
		log.info("rpc request, method:searchColleges, param:String text=" + text);
		return searchService.searchColleges(text, from, size);
	}

}
