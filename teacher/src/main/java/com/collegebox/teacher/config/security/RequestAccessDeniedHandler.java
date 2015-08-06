package com.collegebox.teacher.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import com.collegebox.teacher.pojo.employee.Employee;
import com.collegebox.teacher.util.ControllerTools;

public class RequestAccessDeniedHandler implements AccessDeniedHandler {

    protected static final Log logger = LogFactory.getLog(AccessDeniedHandlerImpl.class);

    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
    	Employee employee = ControllerTools.getEmployeeDetails();
    	logger.info(employee.getUsername() + " 没有权限访问：" + request.getRequestURI());
    	response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
    }

}
