package com.epam.profile.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Table(name = "institution")
@Entity

public class Institution {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "institution_id")
	private Integer institutionId;
	@Column(name = "institution_name")
	private String institutionName;
	@Column(name = "desc")
	private String desc;
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "institution")
	@Fetch(value=FetchMode.SUBSELECT)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="collegeId")
	private List<College> colleges = new ArrayList<>(0);
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "institution")
	@Fetch(value=FetchMode.SUBSELECT)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="departmentId")
	private List<College> departments = new ArrayList<>(0);
	
	
	public Integer getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(Integer institutionId) {
		this.institutionId = institutionId;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<College> getColleges() {
		return colleges;
	}
	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}
	public List<College> getDepartments() {
		return departments;
	}
	public void setDepartments(List<College> departments) {
		this.departments = departments;
	}
	
	
}
	


