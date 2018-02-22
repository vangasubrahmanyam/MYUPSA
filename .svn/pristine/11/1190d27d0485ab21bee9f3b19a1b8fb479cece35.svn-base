package com.epam.profile.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.epam.profile.dto.DropDownDTO;
import com.epam.profile.exception.Response;
import com.epam.profile.model.Education;
import com.epam.profile.model.PastProject;
import com.epam.profile.model.ProfileSummary;
import com.epam.profile.service.EducationService;
import com.epam.profile.service.PastProjectService;

@Controller
public class PastProjectController {
	@Autowired
	PastProjectService pastProjectService;
	
	@RequestMapping(value="pastProject/addProjectDetails.do",method=RequestMethod.POST)
	public ResponseEntity<Response> addProjectDetails(@RequestBody PastProject pastProject,  UriComponentsBuilder builder) throws IOException{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		pastProjectService.addProjectDetails(pastProject);
		Response response = new Response();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Education Record Added Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="pastProject/getAllProjectDetails.do",method=RequestMethod.GET)
	public @ResponseBody  List<PastProject> getAllProjectDetails(@RequestParam("userId")int userId) throws ParseException{
		List<PastProject> projects= pastProjectService.getAllProjectDetails(userId);
		return projects;
	}
	@RequestMapping(value="/pastProject/getProjectDetailsById.do",method=RequestMethod.GET)
	public @ResponseBody  PastProject getProjectDetailsById(@RequestParam("projectId") String projectId ) throws ParseException{
		PastProject pastProject= pastProjectService.getProjectDetailsById(projectId);
		return pastProject;
	}
	@RequestMapping(value="pastProject/updateProjectDetails.do",method=RequestMethod.POST)
	public ResponseEntity<Response> updateProjectDetails(@RequestBody(required=false) PastProject  pastProject,UriComponentsBuilder builder ) throws IOException, ParseException{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		pastProjectService.updateProjectDetails(pastProject);
		Response response = new Response();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Project Details Updated Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="pastProject/addProfileSummaryDetails.do",method=RequestMethod.POST)
	public ResponseEntity<Response> addProfileSummaryDetails(@RequestBody ProfileSummary summary,  UriComponentsBuilder builder) throws IOException{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		pastProjectService.addProfileSummary(summary);
		Response response = new Response();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Profile Summary Record Added Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="pastProject/updateProfileDetails.do",method=RequestMethod.POST)
	public ResponseEntity<Response> updateProfileDetails(@RequestBody(required=false) ProfileSummary  summary,UriComponentsBuilder builder ) throws IOException, ParseException{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		pastProjectService.updateProfileSummary(summary);
		Response response = new Response();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Project Details Updated Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/pastProject/getProfileSummaryDetailsById.do",method=RequestMethod.GET)
	public @ResponseBody  ProfileSummary getProfileSummaryDetailsById(@RequestParam("userId") String userId ) throws ParseException{
		ProfileSummary summary= pastProjectService.getProfileSummaryDetailsById(userId);
		return summary;
	}
}
