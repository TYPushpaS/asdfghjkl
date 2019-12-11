package com.tyss.talenthunt.dto;

import java.util.List;

import org.hibernate.annotations.Loader;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class RequirementResponse {
	private int statusCode;
	private String message;
	private String description;
	//private String requirmentId;
	private  List<AddRequirement> requirment;
}
