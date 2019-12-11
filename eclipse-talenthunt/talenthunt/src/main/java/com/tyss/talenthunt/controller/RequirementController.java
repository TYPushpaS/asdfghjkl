package com.tyss.talenthunt.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.talenthunt.dao.AddRequirementDaoInterface;
import com.tyss.talenthunt.dto.AddRequirement;
import com.tyss.talenthunt.dto.CustomIdGenerator;
import com.tyss.talenthunt.dto.RequirementResponse;
import com.tyss.talenthunt.service.AddRequirementServiceImpl;

@RestController
@RequestMapping("/addRequirement")
public class RequirementController {

	@Autowired
	private AddRequirementDaoInterface service;
	
	@Autowired
	private RequirementResponse response;
	@Autowired
	private CustomIdGenerator generator;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@PostMapping(path="/register",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public RequirementResponse addRequirement(@RequestBody AddRequirement requirement) {
		
		if(generator.generator(requirement)) {
			
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("User is added successfully");
			return response;
		}else {
			response.setStatusCode(400);
			response.setMessage("Failure");
			response.setDescription("User is not added");
			return response;
		}
	}
	

	/*@PutMapping(path="/update",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public RequirementResponse updateUser(@RequestBody AddRequirement requirement,HttpServletRequest request) {
		if(service.updateRequirement(requirement)) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("User is updated successfully");
			return response;
		}else {
			response.setStatusCode(400);
			response.setMessage("Failure");
			response.setDescription("User is not updated");
			return response;
		}
		
	}*/
}
