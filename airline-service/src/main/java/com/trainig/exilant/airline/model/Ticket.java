package com.trainig.exilant.airline.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ticket {

	private String bookingId;
	private double price;
	private Date bookingDate;
	private double discount;
	private String departurePlace;
	private double totalDiscount;
	private int noOfPassengers;

	private List<Passenger> passengers;
	{
		passengers = new ArrayList<Passenger>();
	}

	@Override
	public String toString() {
		return "Ticket [bookingId=" + bookingId + ", price=" + price + ", bookingDate=" + bookingDate + ", discount="
				+ discount + ", departurePlace=" + departurePlace + ", totalDiscount=" + totalDiscount + ", noOfPassengers="
				+ noOfPassengers + ", passengers=" + passengers + "]";
	}

	public Ticket() {
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public String getDeparturePlace() {
		return departurePlace;
	}

	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}



	public double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public Ticket(String bookingId, double price, Date bookingDate, double discount, String source,
			String departurePlace, double totalDiscount, int noOfPassengers, List<Passenger> passengers) {
		super();
		this.bookingId = bookingId;
		this.price = price;
		this.bookingDate = bookingDate;
		this.discount = discount;
		this.departurePlace = departurePlace;
		this.totalDiscount = totalDiscount;
		this.noOfPassengers = noOfPassengers;
		this.passengers = passengers;
	}

}