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

@Table(name = "college")
@Entity

public class College {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "college_id")
	private Integer collegeId;
	@Column(name = "college_name")
	private String collegeName;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="institution_id")
	private Institution institution ;
	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	
	
}
	


