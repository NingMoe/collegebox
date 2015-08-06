package com.collegebox.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.collegebox.rest.pojo.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
	
}
