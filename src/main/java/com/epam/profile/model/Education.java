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

@Table(name = "education_details")
@Entity
public class Education {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "education_details_id")
	private Integer educationId;
	@Column(name = "institution")
	private String institution;
	@Column(name = "college")
	private String college;
	@Column(name = "department")
	private String department;
	@Column(name = "degree")
	private String degree;
	@Column(name = "graduation_year")
	private String graduationYear;
	@Column(name = "speciality")
	private String speciality;
	@Column(name = "in_complete")
	private String inComplete;
	@Column(name = "user_id")
	private Integer userId;
	
	
	public Integer getEducationId() {
		return educationId;
	}
	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getInComplete() {
		return inComplete;
	}
	public void setInComplete(String inComplete) {
		this.inComplete = inComplete;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}


