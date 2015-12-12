package com.collegebox.webservice.service.college;

import javax.jws.WebService;

import com.collegebox.webservice.model.elasticsearch.CollegeResponse;

@WebService
public interface CollegeService {
	
	public CollegeResponse searchColleges(String text, int from, int size) throws Exception;

}
