package com.tyss.talunthunt.dto;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Data
@Entity
@Table(name="register_candidate")
public class CreateCandidate {
	@Id
	@Column
	@GeneratedValue
    private int cid;
	@Column
	private String cname;
	@Column
	private String email;
	@Column
	private String govtId;
	@Column
	private long number;
	@Column
	private File uploadResume;
	@Column
	private String reLocate;
	@Column
	private String fresher;
	@Column
	private String experience;
	
	

}