package com.tyss.talunthunt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.tyss.talunthunt.dto.AddRequirements;
import com.tyss.talunthunt.dto.CreateCandidate;
import com.tyss.talunthunt.dto.RequirementIdGenerator;
import com.tyss.talunthunt.dto.Response;
import com.tyss.talunthunt.dto.ScheduleInterview;
import com.tyss.talunthunt.service.CreateCandidateService;
import com.tyss.talunthunt.service.ScheduleServiceDAO;
import com.tyss.talunthunt.service.ServiceDAO;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/talenthunt")
public class AddRequirementController {

	@Autowired
	private ServiceDAO service;
	@Autowired
	private ScheduleServiceDAO ser;
	@Autowired
	private CreateCandidateService candidateService;
	@Autowired
	private RequirementIdGenerator generator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@PostMapping(path = "/addrequirement", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response registerAddrequirement(@RequestBody AddRequirements reqinfo) {
		Response response = new Response();

		if (generator.generate(reqinfo)) {
			AddRequirements info = service.addrequirement(reqinfo);
			response.setStatusCode(200);
			response.setMessage("Requirement has been registered successfully");

		} else {
			response.setStatusCode(400);
			response.setMessage(" adding requirement  failed");
		}

		return response;
	}

	@PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response updateAddRequirment(@RequestBody AddRequirements reqinfo) {
		Response response = new Response();
		if (service.updateRequirment(reqinfo)) {
			response.setStatusCode(200);
			response.setMessage("Requirment has been updated successfully");
		} else {
			response.setStatusCode(400);
			response.setMessage(" updating requirement  failed");
		}
		return response;
	}

	@GetMapping(path = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Response getAllRequirment(HttpServletRequest request) {
		Response response = new Response();

		List<AddRequirements> req = service.getAllRequirements();
		if (req != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setAdd(req);
			return response;
		} else {
			response.setStatusCode(400);
			response.setMessage("Failure");
			return response;
		}
	}

	@PostMapping(path = "/scheduleinterview", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response scheduleInterview(@RequestBody ScheduleInterview si) {
		Response response = new Response();
		System.out.println(si.getIdate());
		System.out.println(si.getIlocation());
		if (si != null) {
			ScheduleInterview interview = ser.scheduleInterview(si);
			response.setStatusCode(200);
			response.setMessage("scheduled successfully");
			return response;

		} else {
			response.setStatusCode(400);
			response.setMessage("schedulimg interview is failed");
			return response;
		}

	}

	@PostMapping(path = "/createCandidate", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response createCandidates(@RequestHeader String cname, @RequestHeader String email,
			@RequestHeader String govtId, @RequestHeader long number, @RequestParam("file") MultipartFile file,
			@RequestHeader String reLocate, @RequestHeader String fresher, @RequestHeader String experience)
			throws IOException {
		Response response = new Response();
		System.out.println(cname);
		System.out.println(email);
		System.out.println(file);
		File confile = new File(file.getOriginalFilename());
		FileOutputStream fout = new FileOutputStream(confile);
		fout.write(file.getBytes());
		fout.close();

		CreateCandidate candidate = new CreateCandidate();
		candidate.setCname(cname);
		candidate.setEmail(email);
		candidate.setGovtId(govtId);
		candidate.setNumber(number);
		candidate.setUploadResume(confile);
		candidate.setReLocate(reLocate);
		candidate.setFresher(fresher);
		candidate.setExperience(experience);

		CreateCandidate can = candidateService.createCandidates(candidate);
		if (can != null) {
			response.setStatusCode(200);
			response.setMessage("candidate registered successfully");
		} else {
			response.setStatusCode(400);
			response.setMessage("not able to register");
		}
		return response;
	}

}
