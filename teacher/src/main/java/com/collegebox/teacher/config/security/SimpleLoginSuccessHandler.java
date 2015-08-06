package com.collegebox.teacher.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class SimpleLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler implements InitializingBean {
	
	protected Log logger = LogFactory.getLog(getClass());
	
	private String defaultTargetUrl;
	
	private boolean forwardToDestination = false;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		if(this.forwardToDestination){
			logger.info("Login success,Forwarding to "+this.defaultTargetUrl);
			
			request.getRequestDispatcher(this.defaultTargetUrl).forward(request, response);
		}else{
			logger.info("Login success,Redirecting to "+this.defaultTargetUrl);
			this.redirectStrategy.sendRedirect(request, response, this.defaultTargetUrl);
		}
	}

	public void setDefaultTargetUrl(String defaultTargetUrl) {
		this.defaultTargetUrl = defaultTargetUrl;
	}

	public void setForwardToDestination(boolean forwardToDestination) {
		this.forwardToDestination = forwardToDestination;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(null == defaultTargetUrl || "".equals(defaultTargetUrl.trim()))
			throw new Exception("You must configure defaultTargetUrl");
	}

}
