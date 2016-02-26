package com.collegebox.webservice.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.feature.Features;
import org.springframework.stereotype.Controller;

@Controller
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class UserController {
	
	static final Log log = LogFactory.getLog(UserController.class);
	
	

}
