package com.tyss.talunthunt.service;

import java.util.List;

import com.tyss.talunthunt.dto.ScheduleInterview;

public interface ScheduleServiceDAO {
	public ScheduleInterview scheduleInterview(ScheduleInterview si);
	public List<ScheduleInterview> getAllInterviews();
}
