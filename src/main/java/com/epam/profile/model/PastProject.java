package com.epam.profile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table(name = "project_details")
@Entity
public class PastProject {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "project_id")
	private Integer projectId;
	@Column(name = "start_date")
	private String startDate;
	@Column(name = "end_date")
	private String endDate;
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "company_url")
	private String companyUrl;
	@Column(name = "current_company_project")
	private String currentCompanyProject;
	@Column(name = "description")
	private String description;
	@Column(name = "job_position")
	private String jobPosition;
	@Column(name = "project_roles")
	private String projectRoles;
	@Column(name = "team_info")
	private String teamInfo;
	@Column(name = "database_info")
	private String databaseInfo;
	@Column(name = "tools_info")
	private String toolsInfo;
	@Column(name = "technologies_info")
	private String technologiesInfo;
	@Column(name = "participation_info")
	private String participationInfo;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "user_id")
	private Integer userId;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyUrl() {
		return companyUrl;
	}
	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}
	public String getCurrentCompanyProject() {
		return currentCompanyProject;
	}
	public void setCurrentCompanyProject(String currentCompanyProject) {
		this.currentCompanyProject = currentCompanyProject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJobPosition() {
		return jobPosition;
	}
	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}
	public String getProjectRoles() {
		return projectRoles;
	}
	public void setProjectRoles(String projectRoles) {
		this.projectRoles = projectRoles;
	}
	public String getTeamInfo() {
		return teamInfo;
	}
	public void setTeamInfo(String teamInfo) {
		this.teamInfo = teamInfo;
	}
	public String getDatabaseInfo() {
		return databaseInfo;
	}
	public void setDatabaseInfo(String databaseInfo) {
		this.databaseInfo = databaseInfo;
	}
	public String getToolsInfo() {
		return toolsInfo;
	}
	public void setToolsInfo(String toolsInfo) {
		this.toolsInfo = toolsInfo;
	}
	public String getTechnologiesInfo() {
		return technologiesInfo;
	}
	public void setTechnologiesInfo(String technologiesInfo) {
		this.technologiesInfo = technologiesInfo;
	}
	public String getParticipationInfo() {
		return participationInfo;
	}
	public void setParticipationInfo(String participationInfo) {
		this.participationInfo = participationInfo;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
		
	
}


