package com.collegebox.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.collegebox.webservice.pojo.Major;

@Transactional
public interface MajorRepository extends JpaRepository<Major, Long>, JpaSpecificationExecutor<Major> {

}
