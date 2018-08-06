package com.trainig.exilant.airline.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trainig.exilant.airline.model.Passenger;
import com.trainig.exilant.airline.model.Ticket;

@Service
public class airLineServiceImpl implements IAirLineService {
	private List<Ticket> tickets;
	{
		tickets = new ArrayList<Ticket>();
	}

	private final String id = "ABC000";
	private int ticketId = 1;

	@Override
	public Ticket bookTicket(Ticket ticket) {
		List<Passenger> passengers = ticket.getPassengers();
		int noOfPassenger = passengers.size();
		double discount = 0.0;
		ticketId++;
		ticket.setBookingId(id + ticketId);
		ticket.setBookingDate(new Date());
		if (noOfPassenger > 6) {
			ticket.setDiscount(30);
			discount = (ticket.getPrice() - ((ticket.getPrice() * ticket.getDiscount()) / 100));
			discount = discount * noOfPassenger;
			ticket.setTotalDiscount(discount);
		} else {
			ticket.setDiscount(0);
			discount = ticket.getPrice() * noOfPassenger;
			ticket.setTotalDiscount(discount);
		}

		ticket.setNoOfPassengers(noOfPassenger);
		System.out.println("noOfPassengers" + ticket.getNoOfPassengers());
		tickets.add(ticket);
		return ticket;
	}

	@Override
	public Ticket cancelTicket(String ticketId) {

		Iterator<Ticket> it = getAllbookingList().iterator();
		Ticket tct = getSingleTicket(ticketId);
		while (it.hasNext()) {
			if (it.next().getBookingId().equals(ticketId)) {
				it.remove();
			}
		}
		return tct;
	}

	@Override
	public List<Ticket> getAllbookingList() {
		return tickets;
	}

	@Override
	public Ticket getSingleTicket(String ticketId) {
		for (Ticket t : tickets) {
			if (t.getBookingId().equalsIgnoreCase(ticketId)) {
				return t;
			}
		}

		return null;
	}

}
