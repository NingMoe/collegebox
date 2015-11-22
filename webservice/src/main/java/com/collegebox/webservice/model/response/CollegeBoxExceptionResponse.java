package com.collegebox.webservice.model.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.collegebox.webservice.exception.CollegeBoxException;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://response.model.webservice.collegebox.com/", 
	name = "com.collegebox..webservicemodel.response.CollegeBoxExceptionResponse", propOrder = {"code", "message"})
public class CollegeBoxExceptionResponse {
	
	private int code;
	
	private String message;
	
	public CollegeBoxExceptionResponse() {}
	
	public CollegeBoxExceptionResponse(CollegeBoxException ex) {
		this.code = ex.getCode();
		this.message = ex.getMessage();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
