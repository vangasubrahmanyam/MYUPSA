package com.epam.profile.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.epam.profile.model.Employee;
import com.epam.profile.model.JobDetails;
@Repository
public class LoginDAOImpl implements LoginDAO
{
	@PersistenceContext
	EntityManager entityManager; 
	@Override
	public void checkLogin(Employee employee) {
 	   	Query query = entityManager.createQuery("SELECT e.userId,r.primaryRole,e.firstName,e.lastName FROM Employee e,Roles r where e.userName=:userName and e.password=:password and e.jobDetails.role = r.roleId");
 	    query.setParameter("userName", employee.getUserName());
 	    query.setParameter("password", employee.getPassword());
 	    
    	@SuppressWarnings("unchecked")
		List<Object[]> list = query.getResultList();
		Object[]result = list.get(0);
		employee.setUserId(Integer.parseInt(result[0].toString()));
		JobDetails details = new JobDetails();
		details.setRole(result[1].toString());
		employee.setFirstName(result[2].toString());
		employee.setLastName(result[3].toString());
		employee.setJobDetails(details);
	}

}
