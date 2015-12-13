package com.collegebox.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.collegebox.webservice.pojo.Agency;
import com.collegebox.webservice.pojo.Student;

@Transactional
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {
	
	@Modifying
	@Query("update Student u set u.primaryCountry = :#{#student.primaryCountry}, u.secondaryCountry = :#{#student.secondaryCountry},"
			+ "u.abordTime = :#{#student.abordTime}, u.currMajor = :#{#student.currMajor}, u.currCollege = :#{#student.currCollege},"
			+ "u.currGrade = :#{#student.currGrade}, u.gpa = :#{#student.gpa} where u.id = :#{#student.id}")
	int editBasicInfo(@Param("student") Student student);
	
	@Modifying
	@Query("update Student u set u.agencies = ?1 where u.id = ?2")
	int setAgencies(List<Agency> agencies, Long id);

}
