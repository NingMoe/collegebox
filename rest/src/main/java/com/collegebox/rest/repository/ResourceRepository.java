package com.collegebox.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.collegebox.rest.pojo.Resource;

public interface ResourceRepository extends PagingAndSortingRepository<Resource, Long> {

}
