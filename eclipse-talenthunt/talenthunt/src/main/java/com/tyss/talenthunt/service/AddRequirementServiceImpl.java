package com.tyss.talenthunt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.talenthunt.dao.AddRequirementDaoImpl;
import com.tyss.talenthunt.dao.AddRequirementDaoInterface;
import com.tyss.talenthunt.dto.AddRequirement;
@Service
public class AddRequirementServiceImpl implements AddRequirementServiceInterface {
    @Autowired
	private AddRequirementDaoInterface dao;
	
	@Override
	public boolean addRequirement(AddRequirement requirement) {
		
		 return dao.addRequirement(requirement);
	}

	@Override
	public boolean updateRequirement(AddRequirement requirement) {
		return false;
	}


}
