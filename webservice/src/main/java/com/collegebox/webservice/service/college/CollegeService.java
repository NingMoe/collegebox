package com.collegebox.webservice.service.college;

import com.collegebox.webservice.model.elasticsearch.CollegeResponse;
import com.googlecode.jsonrpc4j.JsonRpcParamName;
import com.googlecode.jsonrpc4j.JsonRpcService;

@SuppressWarnings("deprecation")
@JsonRpcService("/rpc/CollegeService")
public interface CollegeService {
	
	public CollegeResponse searchColleges(@JsonRpcParamName("text") String text, 
			@JsonRpcParamName("from") int from, @JsonRpcParamName("size") int size) throws Exception;

}
