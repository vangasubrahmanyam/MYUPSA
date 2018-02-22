package com.epam.profile.dao;

import java.util.List;
import java.util.Map;

import com.epam.profile.dto.DropDownDTO;
import com.epam.profile.model.Education;

public interface EducationDAO {
	void addNewEducationRecord(Education education);
	void updateEducationDetails(Education education);
	boolean deleteEducationRecordById(Integer educationId);
	List<Education> findEducationByPagination(int pageNo, int pageSize,int userId);
	Long findTotalNoOfRecords(int userId);
	Education getEducationDetailsById(Integer educationId);
	List<DropDownDTO> getInstitutions();
	List<DropDownDTO> getCollegesByInstitutionId(Integer institutionId);
	List<DropDownDTO> getDepartmentsByInstitutionId(Integer institutionId);
	Map<String, String> getAllInstitutions();
	Map<String, String> getAllColleges();
	Map<String, String> getAllDepartments();
	
}
