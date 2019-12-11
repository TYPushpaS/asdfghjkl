package com.tyss.talunthunt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.talunthunt.dao.ScheduleInterviewDAO;
import com.tyss.talunthunt.dto.ScheduleInterview;

@Service
public class ScheduleServiceDAOImpl implements ScheduleServiceDAO {
	@Autowired
	private ScheduleInterviewDAO dao;

	@Override
	public ScheduleInterview scheduleInterview(ScheduleInterview si) {
		return dao.scheduleInterview(si);
	}

	@Override
	public List<ScheduleInterview> getAllInterviews() {
		return dao.getAllInterviews();
	}

}
