package com.epam.profile.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.epam.profile.dao.PastProjectDAO;
import com.epam.profile.model.PastProject;
import com.epam.profile.model.ProfileSummary;

@Service
public class PastProjectService {
	@Autowired
	PastProjectDAO pastProjectDAO;
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public void addProjectDetails(PastProject pastProject) {
		pastProjectDAO.addProjectDetails(pastProject);
	}
	@Transactional(readOnly=true)
	public List<PastProject> getAllProjectDetails(int userId) throws ParseException{
		List<PastProject> allProjects = pastProjectDAO.getAllProjectDetails(userId);
		DateFormat from = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat to = new SimpleDateFormat("MMMM/dd/yyyy");
		for(PastProject project:allProjects ){
			project.setStartDate(to.format(from.parse(project.getStartDate())));
			project.setEndDate((to.format(from.parse(project.getEndDate()))));
		}
		return	allProjects;	
	}
	public PastProject getProjectDetailsById(String projectId) {
		return pastProjectDAO.getProjectDetailsById(Integer.parseInt(projectId));
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public void updateProjectDetails(PastProject pastProject) {
		pastProjectDAO.updateProjectDetails(pastProject);
		
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public void updateProfileSummary(ProfileSummary summary) {
		pastProjectDAO.updateProfileSummary(summary);
		
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public void addProfileSummary(ProfileSummary summary) {
		pastProjectDAO.addProfileSummary(summary);
	}
	public ProfileSummary getProfileSummaryDetailsById(String summaryId) {
		return pastProjectDAO.getProfileSummaryDetailsById(Integer.parseInt(summaryId));
	}
	
	
}
