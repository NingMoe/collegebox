package com.collegebox.webservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.collegebox.webservice.pojo.Resource;

public interface ResourceRepository extends PagingAndSortingRepository<Resource, Long> {

}
