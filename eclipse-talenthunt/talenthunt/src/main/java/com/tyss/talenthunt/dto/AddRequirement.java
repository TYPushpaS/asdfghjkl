package com.tyss.talenthunt.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Data
@Entity
@Table
public class AddRequirement {
	@Id
	@GenericGenerator(name = "string_based_custom_sequence", strategy = "com.tyss.talenthunt.dto.CustomIdGenerator")
	@GeneratedValue(generator = "string_based_custom_sequence")
	
	@Column
	private String requirmentId;
	@Column
	private String client;
	@Column
	private String technology;
	@Column
	private double yoe;
	@Column
	private String location;
	@Column
	private int nop;
	@Column
	private Date odate;
	@Column
	private Date cdate;
	@Column
	private String role;
	@Column
	private double rate; // salary
	private String poc;
	@Column
	private String jd; // job description
}
