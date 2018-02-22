package com.epam.profile.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
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
import com.epam.profile.model.ChangePassword;
import com.epam.profile.model.Employee;
import com.epam.profile.model.EmployeeSkills;
import com.epam.profile.model.Roles;
import com.epam.profile.model.SkillSet;
import com.epam.profile.model.SkillSetSkills;
import com.epam.profile.model.Unit;
import com.epam.profile.service.AdminService;
import com.epam.profile.service.UserService;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="admin/getRoles.do",method=RequestMethod.GET)
	public @ResponseBody  List<Roles> findRolesByPagination(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize")  int pageSize){
		List<Roles> roles= adminService.findRolesByPagination(pageNo,pageSize);
		return roles;
	}
	@RequestMapping(value="admin/getTotalRolesSize.do",method=RequestMethod.GET)
	public @ResponseBody  Long findTotalNoOfRoles(){
		Long count= adminService.findTotalNoOfRoles();
		return count;
	}
	@RequestMapping(value="/getUnitNames.do",method=RequestMethod.GET)
	public @ResponseBody  List<Unit> getUnits(){
		List<Unit> units= userService.getUnits();
		return units;
	}
	
	@RequestMapping(value="admin/addNewRole.do",method=RequestMethod.POST)
	public ResponseEntity<Response> registerUser(@RequestBody Roles role,  UriComponentsBuilder builder) throws IOException{
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setLocation(builder.path("/addNewRole.do/").buildAndExpand(role.getPrimaryRole()).toUri());
		adminService.addNewRole(role);
		Response response = new Response();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("New Role Added Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="admin/updateRoleDetails.do",method=RequestMethod.POST)
	public ResponseEntity<Response> updateMyAccountDetails(@RequestBody(required=false) Roles  roles,UriComponentsBuilder builder ) throws IOException, ParseException{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setLocation(builder.path("/updateMyAccountDetails.do/{userName}").buildAndExpand(roles.getPrimaryRole()).toUri());
		adminService.updateRoleDetails(roles);
		Response response = new Response();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Role Details Updated Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="admin/deleteRolesById.do",method=RequestMethod.GET)
	public ResponseEntity<Response> deleteUserById(@RequestParam("roleId") String  roleId,UriComponentsBuilder builder ) throws IOException{
		HttpHeaders headers = new HttpHeaders();
		boolean flag = adminService.deleteRoleById(Integer.parseInt(roleId));
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
	@RequestMapping(value="/admin/getRolesDetailsByRoleId.do",method=RequestMethod.GET)
	public @ResponseBody  Roles getRolesDetailsByRoleId(@RequestParam("roleId") String roleId ) throws ParseException{
		Roles roles= adminService.getRolesDetailsByRoleId(roleId);
		return roles;
	}
	@RequestMapping(value="/admin/changePassword.do",method=RequestMethod.POST)
	public ResponseEntity<Response> changePassword(@RequestBody ChangePassword changePassword){
		adminService.changePassword(changePassword);
		HttpHeaders headers = new HttpHeaders();
		Response response = new Response();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("ChangePassword Updated Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="admin/addSkillSet.do",method=RequestMethod.POST)
	public ResponseEntity<Response> addSkillSet(@RequestBody(required=false) SkillSet  skillSet,UriComponentsBuilder builder ) throws IOException, ParseException{
		adminService.addNewSkillSet(skillSet);
		Response response = new Response();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setLocation(builder.path("/addNewRole.do/").buildAndExpand(skillSet.getSkillSetId()).toUri());
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("New Role Added Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="admin/getSkillSetNames.do",method=RequestMethod.GET)
	public @ResponseBody  List<SkillSet> getSkillSets(){
		List<SkillSet> units= adminService.getSkillSets();
		return units;
	}
	@RequestMapping(value="admin/getAllSkillSets.do",method=RequestMethod.GET)
	public @ResponseBody  List<SkillSet> getAllSkillSets(@RequestParam("userId") int userId,@RequestParam("skillFilter")String skillFilter){
		List<SkillSet> skillSets= adminService.getAllSkillSets(userId,skillFilter);
		System.out.println(skillSets);
		return skillSets;
	}
	@RequestMapping(value="admin/getTotalSkillSetsSize.do",method=RequestMethod.GET)
	public @ResponseBody  Long findTotalNoOfSkillSets(){
		Long count= adminService.findTotalNoOfSkillSets();
		return count;
	}
	@RequestMapping(value="admin/getSkillSetsByPagination.do",method=RequestMethod.GET)
	public @ResponseBody  List<SkillSet> findSkillSetsByPagination(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize")  int pageSize){
		List<SkillSet> skillSets= adminService.findSkillSetsByPagination(pageNo,pageSize);
		return skillSets;
	}
	@RequestMapping(value="admin/updateSkills.do",method=RequestMethod.POST)
	public ResponseEntity<Response> updateSkills (@RequestBody(required=false) EmployeeSkills  skills,UriComponentsBuilder builder ) throws IOException, ParseException{
		adminService.updateSkills(skills);
		Response response = new Response();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setLocation(builder.path("/addNewRole.do/").buildAndExpand(skills.getSkillId()).toUri());
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("New Role Added Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="admin/viewSkillSetDetails.do",method=RequestMethod.GET)
	public @ResponseBody  List<SkillSet> viewSkillSetDetails(@RequestParam("userId") int userId,@RequestParam("skillLevel") String[] skillLevels){
		List<SkillSet> skillSets= adminService.getAllSkillSetsForView(userId,skillLevels);
		System.out.println(skillSets);
		return skillSets;
	}
	@RequestMapping(value="admin/getSkillSetByIdUrl.do",method=RequestMethod.GET)
	public @ResponseBody  SkillSet getSkillSetById(@RequestParam("skillSetId") int skillSetId){
		SkillSet skillSet = adminService.getSkillSetById(skillSetId);
		return skillSet;
	}
	@RequestMapping(value="admin/updateSkillSet.do",method=RequestMethod.POST)
	public ResponseEntity<Response> updateSkillSet (@RequestBody(required=false) SkillSet  skillSet,UriComponentsBuilder builder ) throws IOException, ParseException{
		adminService.updateSkillSet(skillSet);
		Response response = new Response();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setLocation(builder.path("/addNewRole.do/").buildAndExpand(skillSet.getSkillSetId()).toUri());
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("New Role Added Succesfully");
		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}
	@RequestMapping(value="admin/deleteSkillSet.do",method=RequestMethod.GET)
	public ResponseEntity<Response> deleteSkillSet(@RequestParam("skillSetId") Integer  skillSetId,UriComponentsBuilder builder ) throws IOException{
		HttpHeaders headers = new HttpHeaders();
		boolean flag = adminService.deleteSkillSetById(skillSetId);
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
	
}