package com.collegebox.webservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.collegebox.webservice.pojo.jpa.School;

public interface SchoolRepository extends PagingAndSortingRepository<School, Long> {

}
