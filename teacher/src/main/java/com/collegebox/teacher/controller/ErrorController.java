package com.collegebox.teacher.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.collegebox.teacher.pojo.DefaultResponse;

@Controller
public class ErrorController {
	
	static Logger logger = Logger.getLogger(ErrorController.class);
	
	@RequestMapping(path = "/error", produces = {"application/json", "application/hal+json"})
    @ResponseBody
    public DefaultResponse handleJson(HttpServletRequest request) {
		
		String status_code = String.valueOf(request.getAttribute("javax.servlet.error.status_code"));
		String message = String.valueOf(request.getAttribute("javax.servlet.error.message"));
		
		logger.error("status_code：" + status_code);
		logger.error("message" + message);
		
		DefaultResponse resp = new DefaultResponse(status_code, message);
		
		return resp;
	}
	
	@RequestMapping(path = "/error", produces = {"text/html", "text/plain"})
	public String handleHtml(HttpServletRequest request, Model model) {
		
		String status_code = String.valueOf(request.getAttribute("javax.servlet.error.status_code"));
		String message = String.valueOf(request.getAttribute("javax.servlet.error.message"));
		
		logger.error("status_code：" + status_code);
		logger.error("message" + message);
		
		model.addAttribute("status_code", status_code);
		model.addAttribute("message", message);
		
		return "error.jsp";
	}

}
