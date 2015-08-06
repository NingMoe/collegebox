package com.collegebox.teacher.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.collegebox.teacher.pojo.employee.Employee;

import net.sf.json.JSONObject;

public class ControllerTools {
	
	public static PrintWriter getWriter(HttpServletResponse response) {
	    PrintWriter out = null;
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/json");
	    try {
	      out = response.getWriter();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return out;
	}
	
	public static void print(HttpServletResponse response, JSONObject json) {
	    PrintWriter out = getWriter(response);
	    out.print(json.toString());
	}
	
	public static void print(HttpServletResponse response, String str) {
	    PrintWriter out = getWriter(response);
	    out.print(str);
	}
	
	public static boolean isAjaxRequest(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		return requestType != null;
	}
	
	//获取用户信息
	public static Employee getEmployeeDetails() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof Employee) {
			return (Employee)principal;
		} else {
			return null;
		}
	}
	
	//获取用户权限
	public static Collection<GrantedAuthority> getEmployeeAuths() {
		Employee employee = getEmployeeDetails();
		if(employee != null) {
			return employee.getAuthorities();
		} else {
			return null;
		}
	}

}
