package com.collegebox.teacher.config.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.collegebox.teacher.exception.CaptchaException;

public class CaptchaAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	public static final String SPRING_SECURITY_FORM_CAPTCHA_KEY = "j_captcha";
	public static final String SESSION_GENERATED_CAPTCHA_KEY = "captcha";
	
	private String captchaParameter = SPRING_SECURITY_FORM_CAPTCHA_KEY;
	
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		
		String genCode = this.obtainGeneratedCaptcha(request);
		String inputCode = this.obtainCaptcha(request);
		if(genCode == null)
			throw new CaptchaException(this.messages.getMessage("LoginAuthentication.captchaInvalid"));
		if(!genCode.equalsIgnoreCase(inputCode)){
			throw new CaptchaException(this.messages.getMessage("LoginAuthentication.captchaNotEquals"));
		}
		
		return super.attemptAuthentication(request, response);
	}
	
	protected String obtainCaptcha(HttpServletRequest request) {
		return request.getParameter(this.captchaParameter);
	}
	
	protected String obtainGeneratedCaptcha (HttpServletRequest request) {
		return (String)request.getSession().getAttribute(SESSION_GENERATED_CAPTCHA_KEY);
	}
	
}
