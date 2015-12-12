package com.collegebox.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.collegebox.webservice.pojo.Student;

@Transactional
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {
	
	@Modifying
	@Query("update Student u set u.primaryCountry = ?1.primaryCountry, u.secondaryCountry = ?1.secondaryCountry,"
			+ "u.student_abord_time = ?1.student_abord_time, u.currMajor = ?1.currMajor, u.currCollege = ?1.currCollege,"
			+ "u.currGrade = ?1.currGrade, u.gpa = ?1.gpa where u.id = ?1.id")
	int editBasicInfo(Student student);

}
