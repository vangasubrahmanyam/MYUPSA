package com.epam.profile.service;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.epam.profile.constants.AppConstants;
import com.epam.profile.dao.UserDAO;
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

@Service
@Transactional
public class UserService {
	@Autowired
	UserDAO userDao;
	
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public void  registerUser(Employee user) {
		SecureRandom random = new SecureRandom();
			   StringBuilder sb = new StringBuilder( 10 );
			   for( int i = 0; i < 10; i++ ) 
			      sb.append( AppConstants.PASSWORDCHARS.toString().charAt( random.nextInt(AppConstants.PASSWORDCHARS.toString().length()) ) );
			   	  user.setPassword(sb.toString());
			   	  String array[]=new String[user.getJobDetails().getHrContacts().length];
			   	  int i=0;
			   	  for(HRContact contact: user.getJobDetails().getHrContacts()){
			   		array[i++]=contact.getHrContactId().toString();
			   	}
			   	  String contactIds = String.join(",", array);
			   	  user.getJobDetails().setHrContactsIds(contactIds);
			   	  user.getJobDetails().setReportManagerId(user.getJobDetails().getReportTo().getHrContactId());
			   	  user.getJobDetails().setUnitId(user.getJobDetails().getUnit().getUnitId());
			   	  userDao.saveUser(user);
	}
	public List<Employee> getAllUsers() {
		return userDao.findAllUsers();
	}
	public List<Employee> findUsersByPagination(int pageNo, int pageSize,int loggedInUserId) {
		return userDao.findUsersByPagination(pageNo,pageSize,loggedInUserId);
	}
	
	public Long findTotalNoOfUsers() {
		return userDao.findTotalNoOfUsers();
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public Employee getMyAccountDetailsByUserId(String userId) throws ParseException {
		Employee employee = userDao.getMyAccountDetailsByUserId(userId);
		System.out.println(employee.getImage());
		if(employee.getJobDetails() == null)
			return null;
		DateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd");
		if(employee.getDateOfBirth()!=null)
		employee.setDateOfBirth(fromFormat.format(fromFormat.parse(employee.getDateOfBirth())));
		if(employee.getDrivingLicenceExpiry()!=null)
		employee.setDrivingLicenceExpiry(fromFormat.format(fromFormat.parse(employee.getDrivingLicenceExpiry())));
		String designationName = userDao.findDesignationById(employee.getJobDetails().getDesignation());
		employee.getJobDetails().setDesignation(designationName);
		
		String jobName = userDao.findJobNameById(employee.getJobDetails().getJobName());
		employee.getJobDetails().setJobName(jobName);
		
		String roleName = userDao.findRoleById(employee.getJobDetails().getRole());
		employee.getJobDetails().setRole(roleName);
		
		String jobLevelName = userDao.findJobLevelById(employee.getJobDetails().getJobLevel());
		employee.getJobDetails().setJobLevel(jobLevelName);
		
		List<Address> address= userDao.getAddressesByUserId(userId);
		employee.setAddresses(address);
		List<Children> childrens= userDao.getChildrensByUserId(userId);
		employee.setChildrens(childrens);
		
		List<Contact> contacts= userDao.getContactsByUserId(userId);
		employee.setContacts(contacts);
		Integer unitId= employee.getJobDetails().getUnitId();
		ReportContact reportContact = new ReportContact();
		userDao.findUnitManagerByUnitId(unitId,reportContact);
		List<Unit> unitList = userDao.getUnits();
		StringBuilder builder = new StringBuilder();
		
		for(int i=unitList.size()-1;i>=0;i-- ){
			Unit unit = unitList.get(i);
			if(unit.getUnitId().intValue()==unitId){
				builder.insert(0,unit.getUnitName());
				if(unitId.intValue()!=1){
					builder.insert(0,"/");
				}
				unitId=unit.getSuperiorUnit();
			}
			
		}
		//String unitName = userDao.findUnitById(employee.getJobDetails().getUnitId());
		Unit unit = new  Unit();
		unit.setUnitId(employee.getJobDetails().getUnitId());
		unit.setUnitName(builder.toString());
		
		String reportManagerName = userDao.findReportManagerById(employee.getJobDetails().getReportManagerId());
		reportContact.setSuperiorManagerId(employee.getJobDetails().getReportManagerId());
		reportContact.setSuperiorManagaerName(reportManagerName);
		employee.getJobDetails().setReportContact(reportContact);
		employee.getJobDetails().setUnit(unit);
		String userIds = employee.getJobDetails().getHrContactsIds();
		HRContact[] hrContacts= userDao.getHRContactsById(Stream.of(userIds.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
		employee.getJobDetails().setHrContacts(hrContacts);
		return employee;
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public void updateMyAccountDetails(Employee employee) throws ParseException {
		userDao.updateMyAccountDetails(employee);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=false)
	public boolean deleteUserById(Integer userId) {
		return userDao.deleteEmployeeById(userId);
	}
	public List<JobNames> getJobNames() {
		return userDao.getJobNames();
	}
	public List<JobLevels> getJobLevels() {
		return userDao.getJobLevels();
	}
	public List<Designations> getDesignations() {
		return userDao.getDesignations();
	}
	public List<Roles> getRolesByUnit(Integer unitId) {
		return userDao.getRolesByUnit(unitId);
	}
	public Set<HRContact> getHRContacts(Integer unitId) {
		Integer unitLevel = userDao.findUnitLevelById(unitId);
		Set<HRContact> finalList = null;
		finalList  = userDao.getHRContactsByUnitId(unitId);
		finalList.addAll(userDao.getHRContactsByUnitLevel(unitLevel));
		return finalList;
	}
	public List<HRContact> getReportsToByUnit(Integer unitId) {
		Integer unitLevel = userDao.findUnitLevelById(unitId);
		List<HRContact> finalList = null;
		finalList  = userDao.getReportsToByUnitId(unitId);
		finalList.addAll(userDao.getReportsToByUnitLevel(unitLevel,unitId));
		return finalList;
	}
	public List<Unit> getUnits() {
		return userDao.getUnits();
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public List<Employee> searchEmployee(String searchWord) {
		List<Employee> employees = userDao.searchEmployee(searchWord);
		for(Employee employee :employees){
			String designationName = userDao.findDesignationById(employee.getJobDetails().getDesignation());
			employee.getJobDetails().setDesignation(designationName);
			
			ReportContact reportContact = new ReportContact();
			Integer unitId= employee.getJobDetails().getUnitId();
			String unitName = userDao.findUnitById(unitId);
			Unit unit = new Unit();
			unit.setUnitName(unitName);
			employee.getJobDetails().setUnit(unit);
			userDao.findUnitManagerByUnitId(unitId,reportContact);
			String reportManagerName = userDao.findReportManagerById(employee.getJobDetails().getReportManagerId());
			reportContact.setSuperiorManagerId(employee.getJobDetails().getReportManagerId());
			reportContact.setSuperiorManagaerName(reportManagerName);
			employee.getJobDetails().setReportContact(reportContact);
			
		}
		return employees;
	}
	
	
}
