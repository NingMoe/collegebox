package com.collegebox.webservice.controller;

import org.apache.cxf.feature.Features;
import org.springframework.stereotype.Controller;

@Controller
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class RestController {

}
