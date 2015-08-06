package com.collegebox.teacher.dao.role.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.collegebox.teacher.dao.BaseDao;
import com.collegebox.teacher.dao.role.RoleDao;
import com.collegebox.teacher.pojo.role.Role;
import com.collegebox.teacher.pojo.role.RoleList;

@Component
public class RoleDaoImpl extends BaseDao implements RoleDao {
	
	static Logger logger = Logger.getLogger(RoleDaoImpl.class);

	@Override
	public List<Role> getRoles(String url) {
		// TODO Auto-generated method stub
		logger.info("get response from url:" + url);
		RoleList result = restTemplate.getForObject(url, RoleList.class);
		return result.get_embedded().getRoles();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		String url = restUrl + "/roles";
		logger.info("get response from url:" + url);
		RoleList result = restTemplate.getForObject(url, RoleList.class);
		return result.getPage().getTotalElements();
	}

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		String url = restUrl + "/roles" + "?size=" + this.count();
		logger.info("get response from url:" + url);
		RoleList result = restTemplate.getForObject(url, RoleList.class);
		return result.get_embedded().getRoles();
	}
	
}
