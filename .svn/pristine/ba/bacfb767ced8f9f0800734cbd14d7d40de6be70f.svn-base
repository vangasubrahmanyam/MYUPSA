package com.epam.profile.dao;

import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.epam.profile.model.Address;
import com.epam.profile.model.Children;
import com.epam.profile.model.Contact;
import com.epam.profile.model.Designations;
import com.epam.profile.model.Employee;
import com.epam.profile.model.HRContact;
import com.epam.profile.model.JobLevels;
import com.epam.profile.model.JobNames;
import com.epam.profile.model.ReportContact;
import com.epam.profile.model.Roles;
import com.epam.profile.model.Unit;

public interface UserDAO {
	List<Employee>findAllUsers();
	List<Employee>findUsersByPagination(int pageNo,int pageSize,int loggedInUserId);
	Long findTotalNoOfUsers();
	void saveUser(Employee user);
	Employee getMyAccountDetailsByUserId(String userId);
	void updateMyAccountDetails(Employee employee);
	boolean deleteEmployeeById(Integer userId);
	List<JobNames> getJobNames();
	List<JobLevels> getJobLevels();
	List<Designations> getDesignations();
	String findDesignationById(String designation);
	String findJobNameById(String designationId);
	String findJobLevelById(String designationId);
	List<Address> getAddressesByUserId(String userId);
	List<Children> getChildrensByUserId(String userId);
	List<Contact> getContactsByUserId(String userId);
	List<Roles> getRolesByUnit(Integer unitId);
	String findRoleById(String roleId);
	String findReportManagerById(Integer reportManagerId);
	String findUnitById(Integer unitId);
	Set<HRContact> getHRContactsByUnitLevel(Integer unitLevel);
	HRContact[] getHRContactsById(List<Integer> userIds);
	List<HRContact> getReportsToByUnitLevel(Integer unitLvel,Integer unitId);
	List<Unit> getUnits();
	Integer findUnitLevelById(Integer unitId);
	List<HRContact> getReportsToByUnitId(Integer unitId);
	Set<HRContact> getHRContactsByUnitId(Integer unitId);
	void findUnitManagerByUnitId(Integer unitId, ReportContact reportContact);
	List<Employee> searchEmployee(String searchWord);
	UserDetails getUserDetailsByUserName(String userName);
}
