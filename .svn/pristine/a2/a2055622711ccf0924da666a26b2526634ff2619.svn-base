package com.epam.profile.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.epam.profile.model.ChangePassword;
import com.epam.profile.model.Children;
import com.epam.profile.model.Employee;
import com.epam.profile.model.EmployeeSkills;
import com.epam.profile.model.Roles;
import com.epam.profile.model.SkillSet;
import com.epam.profile.model.SkillSetSkills;
import com.epam.profile.model.Unit;
@Repository
public class AdminDAOImpl implements AdminDAO {
	@PersistenceContext
	EntityManager entityManager; 
	
	@Override
	public void createRole(Roles role) {
		entityManager.persist(role);
	}

	@Override
	public void updateRoles(Roles roles) {
		Roles rolesObj = entityManager.find(Roles.class,roles.getRoleId());
		rolesObj.setPrimaryRole(roles.getPrimaryRole());
		rolesObj.setSubRole(roles.getSubRole());
		rolesObj.setRoleDesc(roles.getRoleDesc());
		rolesObj.setUnit(roles.getUnit());
	}

	@Override
	public boolean deleteRoleById(Integer roleId) {
		Query query = entityManager.createQuery("DELETE From Roles where upper(roleId)=upper(:roleId)");
		query.setParameter("roleId", roleId);
		int count  = query.executeUpdate();
		return count>0?true:false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> findRolesByPagination(int pageNo,int pageSize) {
			Query query = entityManager.createQuery("From Roles");
			query.setFirstResult((pageNo-1) * pageSize);
			query.setMaxResults(pageSize);
			return query.getResultList();
	}

	@Override
	public List<Roles> getRoles(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findTotalNoOfRoles(){
		  Query query = entityManager.createQuery("SELECT count(*) FROM Roles");
		  Long count = (Long) query.getSingleResult();
          return count>0?count-1:count;
	}
	@Override
	public Roles getRoleDetailsByRoleId(Integer roleId) {
		TypedQuery<Roles> query = entityManager.createQuery("From Roles where roleId=:roleId",Roles.class);
		query.setParameter("roleId", roleId);
		List<Roles> rolesList = query.getResultList();
		return rolesList.size()>0?rolesList.get(0):new Roles();
	}

	@Override
	public void changePassword(ChangePassword changePassword) {
		Query query = entityManager.createQuery("UPDATE Employee set password=:password where userId=:userId)");
		query.setParameter("userId", Integer.parseInt(changePassword.getUserId()));
		query.setParameter("password", changePassword.getNewPassword());
		query.executeUpdate();
	}

	@Override
	public void addNewSkillSet(SkillSet skillSet) {
		entityManager.persist(skillSet);
	}
	@Override
	public List<SkillSet> getSkillSets(String orderBy) {
			Query query = entityManager.createQuery("From SkillSet order by skillSetId "+orderBy);
			@SuppressWarnings("unchecked")
			List<SkillSet>  skillSets= query.getResultList();
			return skillSets;
	}
	@Override
	public Long findTotalNoOfSkillSets(){
		  Query query = entityManager.createQuery("SELECT count(*) FROM SkillSet");
		  Long count = (Long) query.getSingleResult();
          return count>0?count-1:count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SkillSet> findSkillSetsByPagination(int pageNo,int pageSize) {
			Query query = entityManager.createQuery("From SkillSet");
			query.setFirstResult((pageNo-1) * pageSize);
			query.setMaxResults(pageSize);
			return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SkillSetSkills> getSkillsBySkillSetId(Integer skillSetId,int userId) {
		Query query = entityManager.createQuery("From SkillSetSkills where skillSet.skillSetId in(:skillSetId)");
		query.setParameter("skillSetId", skillSetId);
		return query.getResultList();
	}

	@Override
	public void updateSkills(EmployeeSkills skills) {
		entityManager.merge(skills);
	}
	@Override
	public EmployeeSkills findEmployeeSkillsById(Integer skillId) {
		EmployeeSkills employeeSkills =  entityManager.find(EmployeeSkills.class, skillId);
		return employeeSkills;
			

	}
	public List<EmployeeSkills> getEmployeeSkills(Integer userId,String []skillLevel){
		StringBuilder sql= new StringBuilder();
		sql.append("From EmployeeSkills where userId=:userId");
		if(skillLevel!=null && skillLevel.length!=0){
			sql.append(" and skillLevel in(:skillLevel)");
		}
		TypedQuery<EmployeeSkills> query = entityManager.createQuery(sql.toString(),EmployeeSkills.class);
		query.setParameter("userId", userId);
		if(skillLevel!=null && skillLevel.length!=0){
			query.setParameter("skillLevel", Arrays.asList(skillLevel));
		}
		return query.getResultList();
	}
	@Override
	public SkillSet getSkillSetById(int skillSetId){
		return entityManager.find(SkillSet.class, skillSetId);
	}
	
	@Override
	public void updateSkillSet(SkillSet skillSet) {
		SkillSet skillSetObj = entityManager.find(SkillSet.class,skillSet.getSkillSetId());
		skillSetObj.setSkillSetName(skillSet.getSkillSetName());
		skillSetObj.setParentSkillSet(skillSet.getParentSkillSet());
		
		//For Adding/Updating/Deleting Skills  
		StringBuilder sql = new StringBuilder();		
		for(SkillSetSkills skillSetSkills:skillSetObj.getSkills()){
					sql.setLength(0);
					entityManager.remove(skillSetSkills);
					sql.append("delete from EmployeeSkills where skillSetSkills.skillId=:skillId");
					Query query= entityManager.createQuery(sql.toString());
					query.setParameter("skillId", skillSetSkills.getSkillId());
					query.executeUpdate();
		}
				List<SkillSetSkills> newSkills = new ArrayList<>();
				for(SkillSetSkills skillSetSkills:skillSet.getSkills()){
					newSkills.add(skillSetSkills);
				}
				skillSetObj.setSkills(newSkills);
				entityManager.merge(skillSetObj);
		
	}
	@Override
	public boolean deleteSkillSetById(Integer skillSetId) {
		
		SkillSet skillSetObj = entityManager.find(SkillSet.class,skillSetId);
		StringBuilder sql = new StringBuilder();
		for(SkillSetSkills skillSetSkills:skillSetObj.getSkills()){
			sql.setLength(0);
			entityManager.remove(skillSetSkills);
			sql.append("delete from EmployeeSkills where skillSetSkills.skillId=:skillId");
			Query query= entityManager.createQuery(sql.toString());
			query.setParameter("skillId", skillSetSkills.getSkillId());
			query.executeUpdate();
}
		entityManager.remove(skillSetObj);
		return true;
	}
}
