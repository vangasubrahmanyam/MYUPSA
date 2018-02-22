package com.epam.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.profile.dao.UserDAO;

@Service
public class MyUserService implements UserDetailsService{
	@Autowired
	UserDAO userDAO;
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		return userDAO.getUserDetailsByUserName(userName);
	}
	
}
