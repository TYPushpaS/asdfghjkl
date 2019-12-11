package com.tyss.talunthunt.dto;


import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name ="schedule_interview")

public class ScheduleInterview {
	@Column
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String skills;

	@Column
	private Date idate;
	@Column
	private String ilocation;
	@Column
	private String itype;
	@Column
	private String status;
	@Column
	private String remarks;
	@Column
	private String interviewer;
//	@Column
//	private String requirementId;
//	@Column
//	private int candidateId;
}
