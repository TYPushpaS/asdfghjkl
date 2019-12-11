package com.tyss.talunthunt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.talunthunt.dao.CreateCandidateDAO;
import com.tyss.talunthunt.dto.CreateCandidate;

@Service
public class CreateCandidateServiceImpl implements CreateCandidateService {
	@Autowired
	private CreateCandidateDAO dao;

	@Override
	public CreateCandidate createCandidates(CreateCandidate candidates) {
		return dao.createCandidates(candidates);
	}

}
