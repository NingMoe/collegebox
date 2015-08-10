package com.collegebox.webservice.jsonrpc.employee;

import com.collegebox.webservice.pojo.Employee;
import com.googlecode.jsonrpc4j.JsonRpcParamName;
import com.googlecode.jsonrpc4j.JsonRpcService;

@SuppressWarnings("deprecation")
@JsonRpcService("/rpc/EmployeeService")
public interface EmployeeService {
	
	public Employee findOne(@JsonRpcParamName("id") long id);

}
