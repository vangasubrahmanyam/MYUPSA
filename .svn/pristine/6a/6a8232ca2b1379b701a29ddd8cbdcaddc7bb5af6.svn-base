package com.epam.profile.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="employee_skills")
public class EmployeeSkills {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name = "skill_id")
private Integer skillId;
@Column(name="skill_level")
private String skillLevel;
@Column(name="last_used")
private String lastUsed;
@Column(name="experience")
private String experience;
@Column(name="user_id")
private Integer userId ;
@OneToOne(fetch=FetchType.EAGER,cascade={	CascadeType.MERGE})
@JoinColumn(name="skillset_skill_id")
@JsonBackReference
private SkillSetSkills skillSetSkills;
public Integer getSkillId() {
	return skillId;
}
public void setSkillId(Integer skillId) {
	this.skillId = skillId;
}
public String getSkillLevel() {
	return skillLevel;
}
public void setSkillLevel(String skillLevel) {
	this.skillLevel = skillLevel;
}
public String getLastUsed() {
	return lastUsed;
}
public void setLastUsed(String lastUsed) {
	this.lastUsed = lastUsed;
}
public String getExperience() {
	return experience;
}
public void setExperience(String experience) {
	this.experience = experience;
}

public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public SkillSetSkills getSkillSetSkills() {
	return skillSetSkills;
}
public void setSkillSetSkills(SkillSetSkills skillSetSkills) {
	this.skillSetSkills = skillSetSkills;
}


}
