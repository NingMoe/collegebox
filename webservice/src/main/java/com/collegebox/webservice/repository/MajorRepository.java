package com.collegebox.webservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.collegebox.webservice.pojo.jpa.Major;

public interface MajorRepository extends PagingAndSortingRepository<Major, Long> {

}
