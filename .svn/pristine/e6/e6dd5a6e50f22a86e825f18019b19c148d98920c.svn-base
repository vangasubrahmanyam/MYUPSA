package com.epam.profile.model;

public class HRContact {
private Integer hrContactId;
private String hrContactName;
public Integer getHrContactId() {
	return hrContactId;
}
public void setHrContactId(Integer hrContactId) {
	this.hrContactId = hrContactId;
}
public String getHrContactName() {
	return hrContactName;
}
public void setHrContactName(String hrContactName) {
	this.hrContactName = hrContactName;
}
@Override
	public boolean equals(Object obj) {
		HRContact contact =(HRContact)obj;
		return this.hrContactId.intValue()==contact.hrContactId.intValue() && this.hrContactName.equalsIgnoreCase(contact.hrContactName);
	}
@Override
	public int hashCode() {
		return this.hrContactId.intValue()*this.hrContactName.hashCode()*32;
	}
}

