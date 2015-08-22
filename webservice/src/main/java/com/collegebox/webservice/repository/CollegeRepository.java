package com.collegebox.webservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.collegebox.webservice.pojo.College;

public interface CollegeRepository extends PagingAndSortingRepository<College, Long> {

}
