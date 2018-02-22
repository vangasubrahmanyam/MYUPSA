package com.epam.profile.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"USER_NAME"}))
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	private String password;
	@Column(name="native_name") 
	private String nativeName;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="MIDDLE_NAME")
	private String middleName;
	@Column(name="LAST_NAME")
	private String lastName;
	private String email;
	private String phone;
	private String gender;
	@Column(name="DATE_OF_BIRTH")
	private String dateOfBirth;
	@Transient
	private String profilePhoto;
	@Transient
	private String imageData;
	
	@Column(name="profile_photo")
	private byte[] image;
	
	
	@Column(name="MARITAL_STATUS")
	private String maritalStatus;
	@Column(name="government_id")
	private String governmentId;
	@Column(name="driving_licence")
	private String drivingLicence;
	@Column(name="driving_licence_expiry")
	private String drivingLicenceExpiry;
	@Column(name="t_shirt_size")
	private String tShirtSize;
	@Column(name="REMOTE_WORK")
	private String remoteWork;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="job_id")
	private JobDetails jobDetails;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "employee")
	@Fetch(value=FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<Children> childrens = new ArrayList<>(0);
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "employee")
	@Fetch(value=FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<Address> addresses = new ArrayList<>(0);
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "employee")
	@Fetch(value=FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<Contact> contacts = new ArrayList<>(0);
	
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	public String getImageData() {
		return imageData;
	}
	public void setImageData(String imageData) {
		this.imageData = imageData;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getGovernmentId() {
		return governmentId;
	}
	public void setGovernmentId(String governmentId) {
		this.governmentId = governmentId;
	}
	public String getDrivingLicence() {
		return drivingLicence;
	}
	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}
	public String getDrivingLicenceExpiry() {
		return drivingLicenceExpiry;
	}
	public void setDrivingLicenceExpiry(String drivingLicenceExpiry) {
		this.drivingLicenceExpiry = drivingLicenceExpiry;
	}
	public String gettShirtSize() {
		return tShirtSize;
	}
	public void settShirtSize(String tShirtSize) {
		this.tShirtSize = tShirtSize;
	}
	public JobDetails getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(JobDetails jobDetails) {
		this.jobDetails = jobDetails;
	}
	
	public String getNativeName() {
		return nativeName;
	}
	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}
	public List<Children> getChildrens() {
		return childrens;
	}
	public void setChildrens(List<Children> childrens) {
		this.childrens = childrens;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public String getRemoteWork() {
		return remoteWork;
	}
	public void setRemoteWork(String remoteWork) {
		this.remoteWork = remoteWork;
	}
	
	
}
