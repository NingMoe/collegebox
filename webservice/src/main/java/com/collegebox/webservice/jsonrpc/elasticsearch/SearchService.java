package com.collegebox.webservice.jsonrpc.elasticsearch;

import com.collegebox.webservice.pojo.elasticsearch.CollegeResponse;
import com.googlecode.jsonrpc4j.JsonRpcParamName;
import com.googlecode.jsonrpc4j.JsonRpcService;

@SuppressWarnings("deprecation")
@JsonRpcService("/rpc/SearchService")
public interface SearchService {
	
	public CollegeResponse searchColleges(@JsonRpcParamName("text") String text, 
			@JsonRpcParamName("from") int from, @JsonRpcParamName("size") int size) throws Exception;

}
