package com.collegebox.teacher.config.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.collegebox.teacher.pojo.resource.Resource;
import com.collegebox.teacher.pojo.role.Role;
import com.collegebox.teacher.service.role.RoleService;
import com.collegebox.teacher.util.ControllerTools;

public class URLSecurityMetadataSource implements FilterInvocationSecurityMetadataSource, 
	InitializingBean {
	
	static Logger logger = Logger.getLogger(URLSecurityMetadataSource.class);
	
	@Autowired
	private RoleService roleService;
	
	// 权限集合，目前存于内存
	private static Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();  
		  
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {  
            allAttributes.addAll(entry.getValue());  
        }  
  
        return allAttributes;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		final HttpServletRequest request = ((FilterInvocation)arg0).getRequest();
        
        Collection<GrantedAuthority> auths = ControllerTools.getEmployeeAuths();
        if(auths != null) {
        	for(GrantedAuthority auth : auths) {
            	if("SUPER".equals(auth.getAuthority())) {
            		//如果是超级管理员,则放行所有权限
                	logger.info(ControllerTools.getEmployeeDetails().getUsername() + 
                			"_具有权限:SUPER");
                	return this.getAllConfigAttributes();
            	}
            }
        }
          
        Collection<ConfigAttribute> returnCollection = new ArrayList<ConfigAttribute>(); 
        returnCollection.add(new SecurityConfig("VISITOR")); 
          
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
        	if (entry.getKey().matches(request)) {  
            	returnCollection =  entry.getValue();  
                break;  
            }
        }  
        logger.info("URL：" + request.getRequestURI() + " -> " + returnCollection);
        return returnCollection;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return FilterInvocation.class.isAssignableFrom(arg0);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		requestMap = this.bindRequestMap();
		logger.info("Role-Resource Map:" + requestMap);
	}
	
	public void refreshResuorceMap() {
		logger.info("Reload Role-Resource Map......start");
		requestMap = this.bindRequestMap();
		logger.info("Role-Resource Map:" + requestMap);
		logger.info("Reload Role-Resource Map......success");
	}
	
	private Map<String,String> loadResuorce() {
		// 读取角色--资源配置
		Map<String,String> map = new LinkedHashMap<String,String>();
		List<Role> roles = roleService.getAllRoles();
		roles = roleService.loadResources(roles);
		for(Role role : roles) {
			String mark = role.getMark();
			if(null != role.getResources()) {
				for(Resource resource : role.getResources()) {
					String path = resource.getPath();
					if(map.containsKey(path)) {
						String existsMarks = map.get(path);
						map.put(path, existsMarks + "," + mark);
					} else {
						map.put(path, mark);
					}
				}
			}
		}
		return map;
	}
	
	protected Map<RequestMatcher, Collection<ConfigAttribute>> bindRequestMap(){  
        Map<RequestMatcher, Collection<ConfigAttribute>> map =   
                new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();  
          
        Map<String,String> resMap = this.loadResuorce();  
        for(Map.Entry<String,String> entry:resMap.entrySet()){  
            String key = entry.getKey();  
            Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();  
            atts = SecurityConfig.createListFromCommaDelimitedString(entry.getValue());  
            map.put(new AntPathRequestMatcher(key), atts); 
        }  
          
        return map;
    }

}
