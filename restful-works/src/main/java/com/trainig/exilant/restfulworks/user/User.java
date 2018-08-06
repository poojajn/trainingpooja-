package com.trainig.exilant.restfulworks.user;

import java.util.Date;

public class User {
private Integer userId;
private String uname;
private Date DOB;
@Override
public String toString() {
	return "User [userId=" + userId + ", uname=" + uname + ", DOB=" + DOB + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public Date getDOB() {
	return DOB;
}
public void setDOB(Date dOB) {
	DOB = dOB;
}
public User(Integer userId, String uname, Date dOB) {
	super();
	this.userId = userId;
	this.uname = uname;
	DOB = dOB;
}

public User() {
	}
}
