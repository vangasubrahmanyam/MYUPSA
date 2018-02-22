/**
 * 
 */
package com.epam.profile.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.epam.profile.model.Education;
import com.epam.profile.model.PastProject;
import com.epam.profile.model.ProfileSummary;

/**
 * @author HOME
 *
 */
@Repository
public class PastProjectDAOImpl implements PastProjectDAO {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void addProjectDetails(PastProject pastProject) {
		entityManager.persist(pastProject);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PastProject> getAllProjectDetails(int userId) {
		Query query = entityManager.createQuery("From PastProject where userId=:userId");
		query.setParameter("userId", userId);
		return query.getResultList();
	}
	
	@Override
	public PastProject getProjectDetailsById(Integer projectId) {
		TypedQuery<PastProject> query = entityManager.createQuery("From PastProject where projectId=:projectId",PastProject.class);
		query.setParameter("projectId", projectId);
		List<PastProject> projectDetails = query.getResultList();
		return projectDetails.size()>0?projectDetails.get(0):new PastProject();
	}

	@Override
	public void updateProjectDetails(PastProject pastProject) {
		PastProject projectObj = entityManager.find(PastProject.class,pastProject.getProjectId());
		projectObj.setCompanyName(pastProject.getCompanyName());
		projectObj.setCompanyUrl(pastProject.getCompanyUrl());
		projectObj.setCurrentCompanyProject(pastProject.getCurrentCompanyProject());
		projectObj.setCustomerName(pastProject.getCustomerName());
		projectObj.setDatabaseInfo(pastProject.getDatabaseInfo());
		projectObj.setDescription(pastProject.getDescription());
		projectObj.setEndDate(pastProject.getEndDate());
		projectObj.setJobPosition(pastProject.getJobPosition());
		projectObj.setParticipationInfo(pastProject.getParticipationInfo());
		projectObj.setProjectRoles(pastProject.getProjectRoles());
		projectObj.setStartDate(pastProject.getStartDate());
		projectObj.setTeamInfo(pastProject.getTeamInfo());
		projectObj.setTechnologiesInfo(pastProject.getTechnologiesInfo());
		projectObj.setToolsInfo(pastProject.getToolsInfo());
	}

	@Override
	public void addProfileSummary(ProfileSummary summary) {
		entityManager.persist(summary);		
	}

	@Override
	public void updateProfileSummary(ProfileSummary summary) {
		if(summary.getSummaryId()!=null && summary.getSummaryId()!=0){
		ProfileSummary summaryObj = entityManager.find(ProfileSummary.class,summary.getSummaryId());
		summaryObj.setSummaryDescription(summary.getSummaryDescription());
		}
		else
			entityManager.persist(summary);	
			
	}
	@Override
	public ProfileSummary getProfileSummaryDetailsById(Integer userId) {
		TypedQuery<ProfileSummary> query = entityManager.createQuery("From ProfileSummary where userId=:userId",ProfileSummary.class);
		query.setParameter("userId", userId);
		List<ProfileSummary> profileSummaries = query.getResultList();
		return profileSummaries.size()>0?profileSummaries.get(0):new ProfileSummary();
	}
}
