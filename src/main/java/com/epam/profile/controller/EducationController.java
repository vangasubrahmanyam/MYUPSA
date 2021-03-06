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
import com.epam.profile.service.EducationService;

@Controller
public class EducationController {
	@Autowired
	EducationService educationService;
	
	@RequestMapping(value="education/findEducationByPagination.do",method=RequestMethod.GET)
	public @ResponseBody  List<Education> findEducationByPagination(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize")  int pageSize,@RequestParam("userId")int userId){
		List<Education> educations= educationService.findEducationByPagination(pageNo,pageSize,userId);
		return educations;
	}
	@RequestMapping(value="education/getTotalEducationsSize.do",method=RequestMethod.GET)
	public @ResponseBody  Long findTotalNoOfRecords(@RequestParam("userId")int userId){
		Long count= educationService.findTotalNoOfRecords(userId);
		return count;
	}
	@RequestMapping(value="education/addNewEducation.do",method=RequestMethod.POST)
	public ResponseEntity<Response> addNewEducation(@RequestBody Education education,  UriComponentsBuilder builder) throws IOException{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		educationService.addNewEducationRecord(education);
		Response response = new Response();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Education Record Added Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="education/updateEducationDetails.do",method=RequestMethod.POST)
	public ResponseEntity<Response> updateEducationDetails(@RequestBody(required=false) Education  education,UriComponentsBuilder builder ) throws IOException, ParseException{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		educationService.updateEducationDetails(education);
		Response response = new Response();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Education Details Updated Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="education/deleteEducationRecordById.do",method=RequestMethod.GET)
	public ResponseEntity<Response> deleteEducationRecordById(@RequestParam("educationId") String  educationId,UriComponentsBuilder builder ) throws IOException{
		HttpHeaders headers = new HttpHeaders();
		boolean flag = educationService.deleteEducationRecordById(Integer.parseInt(educationId));
		Response response = new Response();
		if(flag){
		response.setStatusCode(HttpStatus.NO_CONTENT.value());
		response.setMessage("Education Record Deleted Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.NO_CONTENT);
		}else{
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Education Record Deletion Failure");
			return new ResponseEntity<Response>(response, headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping(value="/education/getEducationDetailsById.do",method=RequestMethod.GET)
	public @ResponseBody  Education getEducationDetailsById(@RequestParam("educationId") String educationId ) throws ParseException{
		Education education= educationService.getEducationDetailsById(educationId);
		return education;
	}
	
	@RequestMapping(value="/education/getInstitutions.do",method=RequestMethod.GET)
	public @ResponseBody  List<DropDownDTO> getInstitutions() throws ParseException{
		List<DropDownDTO> list= educationService.getInstitutions();
		return list;
	}
	@RequestMapping(value="/education/getCollegesByInstitutionId.do",method=RequestMethod.GET)
	public @ResponseBody  List<DropDownDTO> getCollegesByInstitution(@RequestParam("institutionId") Integer institutionId ) throws ParseException{
		List<DropDownDTO> list= educationService.getCollegesByInstitutionId(institutionId);
		return list;
	}
	@RequestMapping(value="/education/getDepartmentsByInstitutionId.do",method=RequestMethod.GET)
	public @ResponseBody  List<DropDownDTO> getDepartmentsByInstitutionId(@RequestParam("institutionId") Integer institutionId ) throws ParseException{
		List<DropDownDTO> list= educationService.getDepartmentsByInstitutionId(institutionId);
		return list;
	}
	
}
