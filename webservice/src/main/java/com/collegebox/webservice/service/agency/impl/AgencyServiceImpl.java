package com.collegebox.webservice.service.agency.impl;

import javax.jws.WebService;

import org.apache.cxf.feature.Features;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.collegebox.webservice.exception.CollegeBoxException;
import com.collegebox.webservice.pojo.Agency;
import com.collegebox.webservice.repository.AgencyRepository;
import com.collegebox.webservice.service.agency.AgencyService;
import com.collegebox.webservice.util.AssertUtil;

@Service
@WebService(endpointInterface = "com.collegebox.webservice.service.agency.AgencyService", serviceName = "agencyService")
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class AgencyServiceImpl implements AgencyService {
	
	@Autowired
	AgencyRepository agencyRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public Agency add(Agency agency) throws CollegeBoxException {
		// TODO Auto-generated method stub
		AssertUtil.notNull(agency.getName(), CollegeBoxException.NameRequired);
		AssertUtil.isTrue(agencyRepository.countByName(agency.getName()) == 0, CollegeBoxException.NameInvalid);
		return agencyRepository.save(agency);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public void editBasicInfo(Agency agency) throws CollegeBoxException {
		// TODO Auto-generated method stub
		AssertUtil.notNull(agency.getName(), CollegeBoxException.NameRequired);
		AssertUtil.isTrue(agencyRepository.countByNameAndIdNot(
				agency.getName(), agency.getId()) == 0, 
				CollegeBoxException.NameInvalid);
		agencyRepository.editBasicInfo(agency.getName(), agency.getIntro(), agency.getAddress(), 
				agency.getWebsite(), agency.getLogoUrl(), agency.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,  rollbackFor = Exception.class)
	public void delete(Long id) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(id, CollegeBoxException.IdRequired);
		agencyRepository.delete(id);
	}

	@Override
	public Agency findOne(Long id) {
		// TODO Auto-generated method stub
		AssertUtil.notNull(id, CollegeBoxException.IdRequired);
		return agencyRepository.findOne(id);
	}

}
