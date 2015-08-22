package com.collegebox.webservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.collegebox.webservice.pojo.School;

public interface SchoolRepository extends PagingAndSortingRepository<School, Long> {

}
