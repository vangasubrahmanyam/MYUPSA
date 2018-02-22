package com.epam.profile.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="jobs_details")
public class JobDetails {
@Column(name="job_id")	
@GeneratedValue(strategy=GenerationType.AUTO)
@Id
private Integer jobId;
@Column(name="job_name")
private String jobName;
@Column(name="job_level")
private String jobLevel;
@Column(name="primary_skill")
private String primarySkill;
@Column(name="designation")
private String designation;
@Column(name="job_type")
private String jobType;
@Column(name="job_title")
private String jobTitle;
@Column(name="production_category")
private String productionCategory;
@Column(name="role_id")
private String role;

@Column(name="report_manager_id")
private Integer reportManagerId;
@Column(name="unit_id")
private Integer unitId;
@Column(name="unit_manager")
private String unitManager;

@Transient
private HRContact reportTo;
@Column(name="hr_contact_ids")
private String hrContactsIds;
@Transient
private HRContact[] hrContacts = new HRContact[0];
@Transient
private Unit unit;
@Transient
private ReportContact reportContact;

public Integer getJobId() {
	return jobId;
}
public void setJobId(Integer jobId) {
	this.jobId = jobId;
}
public String getJobName() {
	return jobName;
}
public void setJobName(String jobName) {
	this.jobName = jobName;
}
public String getJobLevel() {
	return jobLevel;
}
public void setJobLevel(String jobLevel) {
	this.jobLevel = jobLevel;
}
public String getPrimarySkill() {
	return primarySkill;
}
public void setPrimarySkill(String primarySkill) {
	this.primarySkill = primarySkill;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getJobType() {
	return jobType;
}
public void setJobType(String jobType) {
	this.jobType = jobType;
}
public String getJobTitle() {
	return jobTitle;
}
public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}
public String getProductionCategory() {
	return productionCategory;
}
public void setProductionCategory(String productionCategory) {
	this.productionCategory = productionCategory;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Integer getReportManagerId() {
	return reportManagerId;
}
public void setReportManagerId(Integer reportManagerId) {
	this.reportManagerId = reportManagerId;
}

public String getHrContactsIds() {
	return hrContactsIds;
}
public void setHrContactsIds(String hrContactsIds) {
	this.hrContactsIds = hrContactsIds;
}
public HRContact[] getHrContacts() {
	return hrContacts;
}
public void setHrContacts(HRContact[] hrContacts) {
	this.hrContacts = hrContacts;
}
public HRContact getReportTo() {
	return reportTo;
}
public void setReportTo(HRContact reportTo) {
	this.reportTo = reportTo;
}
public Integer getUnitId() {
	return unitId;
}
public void setUnitId(Integer unitId) {
	this.unitId = unitId;
}
public Unit getUnit() {
	return unit;
}
public void setUnit(Unit unit) {
	this.unit = unit;
}
public String getUnitManager() {
	return unitManager;
}
public void setUnitManager(String unitManager) {
	this.unitManager = unitManager;
}
public ReportContact getReportContact() {
	return reportContact;
}
public void setReportContact(ReportContact reportContact) {
	this.reportContact = reportContact;
}

}
