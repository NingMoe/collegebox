package com.collegebox.webservice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.collegebox.webservice.util.HttpRequestUtils;

import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class RpcTests {
	
	private static final Log log = LogFactory.getLog(RpcTests.class);
	
	@Test
	public void rpcTest() {
		
//		String query = "{\"jsonrpc\":\"2.0\", \"id\":10, \"method\":\"findOne\", \"params\":{\"id\": 1}}";
//		String url = "http://127.0.0.1:8082:/rpc/EmployeeService";
		
		String query = "{\"jsonrpc\":\"2.0\", \"id\":10, \"method\":\"searchColleges\", "
				+ "\"params\":{\"text\":\"香港大学\", \"from\":0, \"size\":12}}";
		String url = "http://127.0.0.1:8082:/rpc/SearchService";
		
		JSONObject jsonParam = JSONObject.fromObject(query);
		JSONObject result = HttpRequestUtils.httpPost(url, jsonParam);
		log.info("result:" + result.toString());
		
	}

}
