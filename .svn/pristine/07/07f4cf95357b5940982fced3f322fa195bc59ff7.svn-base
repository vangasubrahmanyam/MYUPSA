package com.epam.profile.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Table(name = "unit_master")
@Entity
public class Unit {

	@Id
	@Column(name = "unit_id")
	private Integer unitId;
	@Column(name = "unit_name")
	private String unitName;
	@Column(name = "unit_level")
	private Integer unitLevel;
	@Column(name = "unit_desc")
	private String unitDesc;
	@Column(name = "unit_category")
	private String unitCategory;
	@Column(name = "superior_unit")
	private Integer superiorUnit;
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "unit")
	@Fetch(value=FetchMode.SUBSELECT)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="roleId")
	private List<Roles> roles = new ArrayList<>(0);
	
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public Integer getUnitLevel() {
		return unitLevel;
	}
	public void setUnitLevel(Integer unitLevel) {
		this.unitLevel = unitLevel;
	}
	public String getUnitDesc() {
		return unitDesc;
	}
	public void setUnitDesc(String unitDesc) {
		this.unitDesc = unitDesc;
	}
	public String getUnitCategory() {
		return unitCategory;
	}
	public void setUnitCategory(String unitCategory) {
		this.unitCategory = unitCategory;
	}
	public Integer getSuperiorUnit() {
		return superiorUnit;
	}
	public void setSuperiorUnit(Integer superiorUnit) {
		this.superiorUnit = superiorUnit;
	}
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
		
	

}


