package com.training;

import com.mongodb.BasicDBObject;

public class Employee extends BasicDBObject {
	private int empid;
	private String name;
	private double salary;
	private String email;

	public int getEmpid() {

		return empid;
	}

	public void setEmpid(int empid) {
		this.put("empid", empid);
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.put("name", name);
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.put("esalry", salary);
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.put("email", email);
		this.email = email;
	}

	public Employee(int empid, String name, double salary, String email) {
		super();
		this.empid = empid;
		this.name = name;
		this.salary = salary;
		this.email = email;
	}

	public Employee() {
	}

}
