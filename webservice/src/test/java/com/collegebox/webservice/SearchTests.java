package com.collegebox.webservice;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.collegebox.webservice.jsonrpc.elasticsearch.SearchService;
import com.collegebox.webservice.pojo.elasticsearch.College;
import com.collegebox.webservice.pojo.elasticsearch.CollegeResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SearchTests {
	
	@Autowired
	SearchService searchServiceImpl;
	
	@Test
	public void searchTest() throws Exception {
		
		CollegeResponse response = searchServiceImpl.searchColleges("香港大学", 0 ,12);
		
		System.out.println("total:" + response.getTotal());
		System.out.println("max_score:" + response.getMax_score());
		
		List<College> colleges = response.getHits();
		for(College college : colleges) {
			System.out.println("source:" + college.getSource());
			Map<String, List<String>> highlights = college.getHighlight();
			for (Map.Entry<String, List<String>> entry : highlights.entrySet()) {
				System.out.println("field:" + entry.getKey());
				for(String highlight : entry.getValue()) {
					System.out.println("highlight:" + highlight);
				}
			}
		}
		
	}

}
