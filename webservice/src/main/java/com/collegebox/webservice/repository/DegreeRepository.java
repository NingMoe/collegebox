package com.collegebox.webservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.collegebox.webservice.pojo.jpa.Degree;

public interface DegreeRepository extends PagingAndSortingRepository<Degree, Long> {

}
