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
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="skill_set")
public class SkillSet{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="skillset_Id")
private Integer skillSetId;
@Column(name="skillset_Name")
private String skillSetName;
@Column(name="parent_SkillSet")
private Integer parentSkillSet;
@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "skillSet")
@Fetch(value=FetchMode.SUBSELECT)
@JsonManagedReference
private List<SkillSetSkills> skills = new ArrayList<>(0);
@Transient
private List<SkillSet> parentskillSets = new ArrayList<>(0);
@Transient
private String parentSkillSetName;
@Transient
private String skillSetHeirachyPath;



public String getSkillSetHeirachyPath() {
	return skillSetHeirachyPath;
}
public void setSkillSetHeirachyPath(String skillSetHeirachyPath) {
	this.skillSetHeirachyPath = skillSetHeirachyPath;
}
public List<SkillSet> getParentskillSets() {
	return parentskillSets;
}
public void setParentskillSets(List<SkillSet> parentskillSets) {
	this.parentskillSets = parentskillSets;
}
public Integer getSkillSetId() {
	return skillSetId;
}
public void setSkillSetId(Integer skillSetId) {
	this.skillSetId = skillSetId;
}
public String getSkillSetName() {
	return skillSetName;
}
public void setSkillSetName(String skillSetName) {
	this.skillSetName = skillSetName;
}
public Integer getParentSkillSet() {
	return parentSkillSet;
}
public void setParentSkillSet(Integer parentSkillSet) {
	this.parentSkillSet = parentSkillSet;
}
public List<SkillSetSkills> getSkills() {
	return skills;
}
public void setSkills(List<SkillSetSkills> skills) {
	this.skills = skills;
}
public String getParentSkillSetName() {
	return parentSkillSetName;
}
public void setParentSkillSetName(String parentSkillSetName) {
	this.parentSkillSetName = parentSkillSetName;
}


}
