package com.collegebox.webservice.service.elasticsearch;

import com.collegebox.webservice.model.elasticsearch.CollegeResponse;

public interface SearchService {
	
	public CollegeResponse searchColleges(String text, int from, int size) throws Exception;

}
