package com.tyss.talunthunt.dao;

import java.util.List;

import com.tyss.talunthunt.dto.ScheduleInterview;

public interface ScheduleInterviewDAO {
public ScheduleInterview scheduleInterview(ScheduleInterview si);
public List<ScheduleInterview> getAllInterviews();
}
