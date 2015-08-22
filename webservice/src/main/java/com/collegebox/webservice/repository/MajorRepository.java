package com.collegebox.webservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.collegebox.webservice.pojo.Major;

public interface MajorRepository extends PagingAndSortingRepository<Major, Long> {

}
