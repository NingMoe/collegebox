package com.collegebox.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.collegebox.webservice.pojo.Student;

@Transactional
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

}
