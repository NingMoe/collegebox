package com.collegebox.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.collegebox.webservice.pojo.Role;

@Transactional
public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
	
	@Transactional(readOnly = true)
	Role findByMark(String mark);
	
	@Transactional(readOnly = true)
	int countByMark(String mark);
	
	@Transactional(readOnly = true)
	int countByName(String name);
	
}
