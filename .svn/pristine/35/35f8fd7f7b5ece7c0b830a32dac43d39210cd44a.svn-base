package com.epam.profile.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
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

import com.epam.profile.exception.Response;
import com.epam.profile.model.Designations;
import com.epam.profile.model.Employee;
import com.epam.profile.model.HRContact;
import com.epam.profile.model.JobLevels;
import com.epam.profile.model.JobNames;
import com.epam.profile.model.Roles;
import com.epam.profile.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	   @Autowired
	    JobLauncher jobLauncher;
	   @Autowired
	   Job exportUsersJob;
	@RequestMapping(value="/registerUser.do",method=RequestMethod.POST)
	public ResponseEntity<Response> registerUser(@RequestBody Employee user,  UriComponentsBuilder builder) throws IOException{
		if(user.getImageData()!=null){
		String imageData[] = user.getImageData().split(",");
		user.setImage(Base64.getDecoder().decode(imageData[1]));
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setLocation(builder.path("/registerUser.do/{userName}").buildAndExpand(user.getUserName()).toUri());
		userService.registerUser(user);
		Response response = new Response();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Registration Succesfull");
		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/getAllUsers.do",method=RequestMethod.GET)
	public @ResponseBody  List<Employee> findUsersByPagination(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize")  int pageSize,@RequestParam("loggedInUserId") int loggedInUserId){
		List<Employee> allProfiles = userService.findUsersByPagination(pageNo,pageSize,loggedInUserId);
		return allProfiles;
	}
	@RequestMapping(value="/getTotalUsersSize.do",method=RequestMethod.GET)
	public @ResponseBody  Long findTotalNoOfUsers(){
		Long count= userService.findTotalNoOfUsers();
		return count;
	}
	@RequestMapping(value="/getMyAccountDetailsByUserId.do",method=RequestMethod.GET)
	public @ResponseBody  Employee getMyAccountDetailsByUserName(@RequestParam() String userId ) throws ParseException{
		if(!userId.equals("0")){
		Employee myAccount= userService.getMyAccountDetailsByUserId(userId);
		if(myAccount.getImage()!=null)
		myAccount.setImageData("data:image/jpeg;base64,"+Base64.getEncoder().encodeToString(myAccount.getImage()));
		return myAccount;
		}else
			return null;
	}
	@RequestMapping(value="/updateMyAccountDetails.do",method=RequestMethod.POST)
	public ResponseEntity<Response> updateMyAccountDetails(@RequestBody(required=false) Employee  user,UriComponentsBuilder builder ) throws IOException, ParseException{
		HttpHeaders headers = new HttpHeaders();
		if(user.getImageData()!=null){
		String imageData[] = user.getImageData().split(",");
		user.setImage(Base64.getDecoder().decode(imageData[1]));
		}
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setLocation(builder.path("/updateMyAccountDetails.do/{userName}").buildAndExpand(user.getUserName()).toUri());
		userService.updateMyAccountDetails(user);
		Response response = new Response();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("MyAccount updated Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="/exportUserToExcel.do",method=RequestMethod.GET)
	public ResponseEntity<InputStreamResource> exportUserToExcel(HttpServletResponse seveletResponse) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException, FileNotFoundException{
		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
		jobLauncher.run(exportUsersJob, jobParametersBuilder.toJobParameters());
		File document = new File("/export_excel_subbu2017.xls");
		seveletResponse.setContentType("application/vnd.ms-excel");
		seveletResponse.setHeader("Content-Disposition", "attachment; filename=All_Users_Excel.xls");
		HttpHeaders respHeaders = new HttpHeaders();
		InputStreamResource isr = new InputStreamResource(new FileInputStream(document));
	    return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);

	}
	@RequestMapping(value="/deleteUserById.do",method=RequestMethod.GET)
	public ResponseEntity<Response> deleteUserById(@RequestParam("userId") String  userId,UriComponentsBuilder builder ) throws IOException{
		HttpHeaders headers = new HttpHeaders();
		boolean flag = userService.deleteUserById(Integer.parseInt(userId));
		Response response = new Response();
		if(flag){
		response.setStatusCode(HttpStatus.NO_CONTENT.value());
		response.setMessage("User Deleted Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.NO_CONTENT);
		}else{
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("User Deletion Failure");
			return new ResponseEntity<Response>(response, headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping(value="/getJobNames.do",method=RequestMethod.GET)
	public @ResponseBody  List<JobNames> getJobNames(){
		List<JobNames> jobNames= userService.getJobNames();
		return jobNames;
	}
	@RequestMapping(value="/getJobLevels.do",method=RequestMethod.GET)
	public @ResponseBody  List<JobLevels> getJobLevels(){
		List<JobLevels> jobLevels= userService.getJobLevels();
		return jobLevels;
	}
	@RequestMapping(value="/getDesignations.do",method=RequestMethod.GET)
	public @ResponseBody  List<Designations> getDesignations(){
		List<Designations> designations= userService.getDesignations();
		return designations;
	}
	@RequestMapping(value="/getRoles.do",method=RequestMethod.GET)
	public @ResponseBody  List<Roles> getRolesByUnit(@RequestParam("unitId") Integer  unitId){
		List<Roles> roles= userService.getRolesByUnit(unitId);
		return roles;
	}
	@RequestMapping(value="/getHRContacts.do",method=RequestMethod.GET)
	public @ResponseBody  Set<HRContact> getHRContacts(@RequestParam("unitId") Integer  unitId){
		Set<HRContact> hrContacts= userService.getHRContacts(unitId);
		return hrContacts;
	}
	@RequestMapping(value="/getReportsToContacts.do",method=RequestMethod.GET)
	public @ResponseBody  List<HRContact> getReportsToByUnit(@RequestParam("unitId") Integer  unitId){
		List<HRContact> hrContacts= userService.getReportsToByUnit(unitId);
		return hrContacts;
	}
	
	@RequestMapping(value="/searchEmployee.do",method=RequestMethod.GET)
	public @ResponseBody  List<Employee> searchEmployee(@RequestParam("searchWord") String  searchWord){
		List<Employee> employees= userService.searchEmployee(searchWord);
		return employees;
	}
	
	
	
}

