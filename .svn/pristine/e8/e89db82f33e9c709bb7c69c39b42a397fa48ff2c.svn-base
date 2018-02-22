package com.epam.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.profile.dao.LoginDAO;
import com.epam.profile.model.Employee;

@Service
@Transactional
public class LoginService {
	@Autowired
	LoginDAO loginDAO;
	public void checkLogin(Employee employee){
		loginDAO.checkLogin(employee);	
	}
	
}
