package com.collegebox.teacher.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BaseDao {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	@Value("${collegebox.restfulservice.url}")
	protected String restUrl;

}
