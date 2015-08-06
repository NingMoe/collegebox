package com.collegebox.teacher.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.collegebox.teacher.pojo.DefaultResponse;
import com.collegebox.teacher.util.GenerateImageCode;

@Controller
public class LoginController {
	
	static Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value = "/getCode", method = RequestMethod.GET)
	public void getCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//禁止缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		//指定生成的响应是图片
		response.setContentType("image/jpeg");
		
		//返回验证码
		GenerateImageCode.generateRandomCode(request, response);
	}
	
	@RequestMapping(value ="/index", method = RequestMethod.GET)
    public String home(Model model) {
		model.addAttribute("welcomeMsg", "Welcome to College Box!");
        return "index.jsp";
    }
	
	@RequestMapping(path = "/sessiontimeout", produces = {"application/json", "application/hal+json"})
	public DefaultResponse timeOutForAjax() {
		return new DefaultResponse("001", "Session time out");
	}
	
	@RequestMapping(path = "/sessiontimeout", produces = {"text/html", "text/plain"})
	public String timeOut() {
		return "/login.jsp?login_error=2";
	}

}
