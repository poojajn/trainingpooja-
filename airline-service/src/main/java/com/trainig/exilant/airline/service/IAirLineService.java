package com.trainig.exilant.airline.service;

import java.util.List;

import com.trainig.exilant.airline.model.Ticket;

public interface IAirLineService {
	public Ticket bookTicket(Ticket ticket);

	public Ticket cancelTicket(String ticket);

	public List<Ticket> getAllbookingList();

	public Ticket getSingleTicket(String ticketId);
}
