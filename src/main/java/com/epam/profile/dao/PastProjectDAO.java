package com.epam.profile.dao;

import java.util.List;

import com.epam.profile.model.PastProject;
import com.epam.profile.model.ProfileSummary;

public interface PastProjectDAO {
	void addProjectDetails(PastProject pastProject);

	List<PastProject> getAllProjectDetails(int userId);

	PastProject getProjectDetailsById(Integer parseInt);

	void updateProjectDetails(PastProject pastProject);
	
	void addProfileSummary(ProfileSummary summary);

	void updateProfileSummary(ProfileSummary summary);

	ProfileSummary getProfileSummaryDetailsById(Integer summaryId);
	
	
}
