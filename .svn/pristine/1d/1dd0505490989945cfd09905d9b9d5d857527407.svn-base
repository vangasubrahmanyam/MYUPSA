package com.epam.profile.dao;

import java.util.List;

import com.epam.profile.model.ChangePassword;
import com.epam.profile.model.EmployeeSkills;
import com.epam.profile.model.Roles;
import com.epam.profile.model.SkillSet;
import com.epam.profile.model.SkillSetSkills;

public interface AdminDAO {
	void createRole(Roles role);
	void updateRoles(Roles roles);
	boolean deleteRoleById(Integer roleId);
	List<Roles> getRoles(int pageNo, int pageSize);
	List<Roles> findRolesByPagination(int pageNo, int pageSize);
	Long findTotalNoOfRoles();
	Roles getRoleDetailsByRoleId(Integer roleId);
	void changePassword(ChangePassword changePassword);
	void addNewSkillSet(SkillSet skillSet);
	Long findTotalNoOfSkillSets();
	List<SkillSet> findSkillSetsByPagination(int pageNo, int pageSize);
	List<SkillSetSkills> getSkillsBySkillSetId(Integer skillSetId,int userId);
	void updateSkills(EmployeeSkills skills);
	EmployeeSkills findEmployeeSkillsById(Integer skillId);
	List<EmployeeSkills> getEmployeeSkills(Integer userId,String []skillLevel);
	List<SkillSet> getSkillSets(String orderBy);
	SkillSet getSkillSetById(int skillSetId);
	void updateSkillSet(SkillSet skillSet);
	boolean deleteSkillSetById(Integer skillSetId);
	
}
