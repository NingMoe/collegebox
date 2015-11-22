package com.collegebox.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.collegebox.webservice.pojo.Agency;

@Transactional
public interface AgencyRepository extends JpaRepository<Agency, Long>, JpaSpecificationExecutor<Agency> {
	
	Long countByName(String name);
	
	Long countByNameAndIdNot(String name, Long id);
	
	@Modifying
	@Query("update Agency u set u.name = ?1, u.intro = ?2, u.address = ?3, u.website = ?4, u.logoUrl = ?5 where u.id = ?6")
	int editBasicInfo(String name, String intro, String address, String website, String logoUrl, Long id);

}
