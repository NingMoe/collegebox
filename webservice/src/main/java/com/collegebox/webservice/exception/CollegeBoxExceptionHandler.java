package com.collegebox.webservice.exception;

import java.util.Locale;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CollegeBoxExceptionHandler implements ExceptionMapper<CollegeBoxException> {

	@Override
	public Response toResponse(CollegeBoxException ex) {
		// TODO Auto-generated method stub
		StackTraceElement[] trace = new StackTraceElement[1];  
        trace[0] = ex.getStackTrace()[0];  
        ex.setStackTrace(trace);
        ex.printStackTrace();
        ResponseBuilder rb = Response.status(Response.Status.ACCEPTED);
        rb.entity(ex.getFaultInfo());
        rb.type("application/json;charset=UTF-8");
        rb.language(Locale.SIMPLIFIED_CHINESE);
        Response r = rb.build();
		return r;
	}

}
