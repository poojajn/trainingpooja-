package com.trainig.exilant.airline.model;

public class Passenger {
	private String passengerId;
	private String passengername;

	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", passengername=" + passengername + "]";
	}

	public String getPassengername() {
		return passengername;
	}

	public Passenger(String passengerId, String passengername) {
		super();
		this.passengerId = passengerId;
		this.passengername = passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

	public Passenger() {
	}

}
