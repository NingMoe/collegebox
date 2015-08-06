package com.collegebox.teacher.pojo;

import com.collegebox.teacher.pojo.base.ResponseHead;

public class DefaultResponse {
	
	private ResponseHead responseHead;
	
	private Object responseBody;
	
	public DefaultResponse() {}
	
	public DefaultResponse(String responseCode, String responseDesc) {
		this.setResponseHead(new ResponseHead());
		this.getResponseHead().setResponseCode(responseCode);
		this.getResponseHead().setResponseDesc(responseDesc);
	}
	
	public DefaultResponse(String responseCode, String responseDesc, Object data) {
		this.setResponseHead(new ResponseHead());
		this.getResponseHead().setResponseCode(responseCode);
		this.getResponseHead().setResponseDesc(responseDesc);
		this.setResponseBody(data);
	}

	public ResponseHead getResponseHead() {
		return responseHead;
	}

	public void setResponseHead(ResponseHead responseHead) {
		this.responseHead = responseHead;
	}

	public Object getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(Object responseBody) {
		this.responseBody = responseBody;
	}

}
