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

@Table(name = "department")
@Entity

public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "department_id")
	private Integer departmentId;
	@Column(name = "department_name")
	private String departmentName;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="institution_id")
	private Institution institution ;
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
		
	
}
	


