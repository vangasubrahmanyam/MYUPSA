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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="skillset_skills")
public class SkillSetSkills {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name = "skill_id")
private Integer skillId;
@Column(name="skill_name")
private String skillName;
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="skillset_id")
@JsonBackReference
private SkillSet skillSet;
@Transient
@JsonManagedReference
private EmployeeSkills employeeSkills;


public Integer getSkillId() {
	return skillId;
}
public void setSkillId(Integer skillId) {
	this.skillId = skillId;
}
public String getSkillName() {
	return skillName;
}
public void setSkillName(String skillName) {
	this.skillName = skillName;
}
public SkillSet getSkillSet() {
	return skillSet;
}
public void setSkillSet(SkillSet skillSet) {
	this.skillSet = skillSet;
}
public EmployeeSkills getEmployeeSkills() {
	return employeeSkills;
}
public void setEmployeeSkills(EmployeeSkills employeeSkills) {
	this.employeeSkills = employeeSkills;
}


}
