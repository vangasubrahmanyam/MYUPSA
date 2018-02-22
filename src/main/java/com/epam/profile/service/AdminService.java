package com.epam.profile.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.epam.profile.dao.AdminDAO;
import com.epam.profile.model.Address;
import com.epam.profile.model.ChangePassword;
import com.epam.profile.model.Children;
import com.epam.profile.model.EmployeeSkills;
import com.epam.profile.model.Roles;
import com.epam.profile.model.SkillSet;
import com.epam.profile.model.SkillSetSkills;

@Service
@Transactional
public class AdminService {
	@Autowired
	AdminDAO adminDAO;
	public List<Roles> findRolesByPagination(int pageNo,int pageSize){
		List<Roles> roles = adminDAO.findRolesByPagination(pageNo,pageSize);
		for(Roles role:roles){
			role.setUnitName(role.getUnit().getUnitName());
		}
	return	roles;	
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public void addNewRole(Roles role) {
		adminDAO.createRole(role);
	}
	public Long findTotalNoOfRoles() {
		return adminDAO.findTotalNoOfRoles();
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public void updateRoleDetails(Roles roles) throws ParseException {
		adminDAO.updateRoles(roles);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public boolean deleteRoleById(Integer roleId) {
		return adminDAO.deleteRoleById(roleId);
	}
	public Roles getRolesDetailsByRoleId(String roleId) {
		return adminDAO.getRoleDetailsByRoleId(Integer.parseInt(roleId));
	}
	public void changePassword(ChangePassword changePassword) {
		adminDAO.changePassword(changePassword);
		
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public void addNewSkillSet(SkillSet skillSet) {
		adminDAO.addNewSkillSet(skillSet);
	}
	public List<SkillSet> getSkillSets() {
		return adminDAO.getSkillSets("desc");
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public List<SkillSet> getAllSkillSets(Integer userId,String skillFilter) {
		List<SkillSet> skillSets= adminDAO.getSkillSets("desc");
		List<EmployeeSkills> employeeSkills= adminDAO.getEmployeeSkills(userId,null);
		Map<Integer,EmployeeSkills> empSkillsMap = new HashMap<Integer, EmployeeSkills>();
		for(EmployeeSkills skills:employeeSkills){
			empSkillsMap.put(skills.getSkillSetSkills().getSkillId(), skills);
		}
		Map<Integer,SkillSet> map = new HashMap<Integer, SkillSet>();
		for(SkillSet skillSet:skillSets){
			if(map.containsKey(skillSet.getParentSkillSet())){
				SkillSet parent =  map.get(skillSet.getParentSkillSet());
				skillSet.setSkillSetHeirachyPath(parent.getSkillSetHeirachyPath()+"."+skillSet.getSkillSetName());
			}else{
				skillSet.setSkillSetHeirachyPath(skillSet.getSkillSetName());
			}
	}
		for(SkillSet skillSet:skillSets){
			List<SkillSetSkills> skills= adminDAO.getSkillsBySkillSetId(skillSet.getSkillSetId(),userId);
			for (Iterator<SkillSetSkills> iterator = skills.iterator(); iterator.hasNext();) {
				SkillSetSkills skillsSetSkills = iterator.next();
				EmployeeSkills skills2 =  empSkillsMap.get(skillsSetSkills.getSkillId());
				if(skills2!=null){
					skillsSetSkills.setEmployeeSkills(skills2);
				}else{
					if(skillFilter.equalsIgnoreCase("MySkills"))
					iterator.remove();
				}
			}
			skillSet.setSkills(skills);
			
			
			
			SkillSet skillSetChild;
			if(map.containsKey(skillSet.getSkillSetId())){
				skillSetChild = map.get(skillSet.getSkillSetId());
			}else{
				skillSetChild = new SkillSet();
				map.put(skillSet.getSkillSetId(), skillSetChild);
			}
			skillSetChild.setSkillSetId(skillSet.getSkillSetId());
			skillSetChild.setSkillSetName(skillSet.getSkillSetName());
			skillSetChild.setSkills(skillSet.getSkills());
			skillSetChild.setSkillSetHeirachyPath(skillSet.getSkillSetHeirachyPath());
			skillSetChild.setParentSkillSet(skillSet.getParentSkillSet());
			
			SkillSet skillSetParent;
			if(map.containsKey(skillSet.getParentSkillSet())){
				skillSetParent = map.get(skillSet.getParentSkillSet());
			}else{
				skillSetParent = new SkillSet();
				map.put(skillSet.getParentSkillSet(), skillSetParent);
			}
			skillSetParent.setSkillSetId(skillSet.getParentSkillSet());
			skillSetParent.setSkillSetName(skillSet.getSkillSetName());
			skillSetParent.setSkills(skillSet.getSkills());
			skillSetParent.setSkillSetHeirachyPath(skillSet.getSkillSetHeirachyPath());
			skillSetParent.setParentSkillSet(0);
			skillSetParent.getParentskillSets().add(skillSetChild);
		}
		 List<SkillSet> finalSkillSets = new ArrayList<SkillSet>(); 
	        for(SkillSet mmd : map.values()){
	            if(mmd.getParentSkillSet().intValue()==0 && mmd.getParentskillSets()!=null && !mmd.getParentskillSets().isEmpty())
	   
	            	finalSkillSets.add(mmd);
	        }
	        return finalSkillSets.subList(1, finalSkillSets.size());	
	}
	
	public Long findTotalNoOfSkillSets() {
		return adminDAO.findTotalNoOfSkillSets();
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public List<SkillSet> findSkillSetsByPagination(int pageNo,int pageSize){
		List<SkillSet> skillSets = adminDAO.findSkillSetsByPagination(pageNo,pageSize);
		List<SkillSet> allSkillSets = adminDAO.getSkillSets("desc");
		Map<Integer,String> map = new HashMap<Integer, String>();
		for(SkillSet skillSet:allSkillSets){
			map.put(skillSet.getSkillSetId(), skillSet.getSkillSetName());
		}
		for(SkillSet skillSet:skillSets){
			skillSet.setParentSkillSetName(map.get(skillSet.getParentSkillSet()));
		}
	return	skillSets;	
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public void updateSkills(EmployeeSkills skills) {
		EmployeeSkills employeeSkills =  adminDAO.findEmployeeSkillsById(skills.getSkillId());
		if(employeeSkills==null)
		adminDAO.updateSkills(skills);
		else{
		employeeSkills.setSkillLevel(skills.getSkillLevel());
		employeeSkills.setLastUsed(skills.getLastUsed());
		employeeSkills.setExperience(skills.getExperience());
		}
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public List<SkillSet> getAllSkillSetsForView(Integer userId,String []skillLevel) {
		List<SkillSet> list = adminDAO.getSkillSets("asc");
	Map<Integer,SkillSet> map = new HashMap<Integer, SkillSet>();
	List<EmployeeSkills> employeeSkills= adminDAO.getEmployeeSkills(userId,skillLevel);
	Map<Integer,EmployeeSkills> empSkillsMap = new HashMap<Integer, EmployeeSkills>();
	for(EmployeeSkills skills:employeeSkills){
		switch(skills.getSkillLevel()){
		case "Begin":
			skills.setSkillLevel("0");
			break;
		case "Intermediate":
			skills.setSkillLevel("1");
			break;
		case "Advanced":
			skills.setSkillLevel("2");
			break;
		case "Expert":
			skills.setSkillLevel("3");
			break;
		}
		empSkillsMap.put(skills.getSkillSetSkills().getSkillId(), skills);
	}
	for(SkillSet skillSet:list){
		map.put(skillSet.getSkillSetId(), skillSet);
		List<SkillSetSkills> skills= adminDAO.getSkillsBySkillSetId(skillSet.getSkillSetId(),userId);
		skillSet.setSkills(skills);
		for(SkillSetSkills skillSetSkills:skills){
			EmployeeSkills skills2 =  empSkillsMap.get(skillSetSkills.getSkillId());
			skillSetSkills.setEmployeeSkills(skills2);
		}
	}
	
		for(SkillSet skillSet:list){
			if(map.containsKey(skillSet.getParentSkillSet())){
				SkillSet parent =  map.get(skillSet.getParentSkillSet());
				skillSet.setSkillSetHeirachyPath(parent.getSkillSetHeirachyPath()+"."+skillSet.getSkillSetName());
			}else{
				skillSet.setSkillSetHeirachyPath(skillSet.getSkillSetName());
			}
	}
		List<SkillSet> finalList = new ArrayList<SkillSet>();
		for(SkillSet skillSet:list){
			List<SkillSetSkills> skillSetSkilList= skillSet.getSkills();
			boolean flag= false;
			for (Iterator<SkillSetSkills> iterator = skillSetSkilList.iterator(); iterator.hasNext();) {
				SkillSetSkills skills = iterator.next();
				if(skills.getEmployeeSkills()!=null){
					flag=true;
				}else{
					iterator.remove();
				}
			}
			if(flag)
				finalList.add(skillSet);
	
	}
		return finalList;
	}
	
	public SkillSet getSkillSetById(int skillSetId){
		return adminDAO.getSkillSetById(skillSetId);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public void updateSkillSet(SkillSet skillSet) {
		adminDAO.updateSkillSet(skillSet);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public boolean deleteSkillSetById(Integer skillSetId) {
		return adminDAO.deleteSkillSetById(skillSetId);
	}
}
