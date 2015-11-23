package com.collegebox.webservice.service.agency;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.Agency;

public interface AgencyService {
	
	public Agency add(Agency agency) throws CollegeBoxException;
	
	public void editBasicInfo(Agency agency) throws CollegeBoxException;
	
	public void delete(Long id);
	
	public Agency findOne(Long id);

}
