package com.epam.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.profile.model.Employee;
import com.epam.profile.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	ResponseEntity<Employee> checkLogin(@RequestBody Employee employee){
		loginService.checkLogin(employee);
		if(employee.getUserId()!=0){
			return  new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}else{
			return  new ResponseEntity<Employee>(employee,HttpStatus.UNAUTHORIZED);
		}
	}
}
