package com.collegebox.webservice.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.feature.Features;
import org.springframework.stereotype.Controller;

@Controller
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class RestController {
	
	static final Log log = LogFactory.getLog(RestController.class);
	
	@GET
	@Path("/hello")
	@Produces({MediaType.TEXT_HTML})
	public String hello() {
		return "Hello!";
	}

}
