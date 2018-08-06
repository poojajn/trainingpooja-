package com.trainig.exilant.airline.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilderFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trainig.exilant.airline.model.Ticket;
import com.trainig.exilant.airline.service.IAirLineService;

@RestController
public class BookingController {

	@Autowired
	private IAirLineService iAirLineService;

	@PostMapping("/book-ticket")
	public Ticket bookTicket(@RequestBody Ticket ticket) {
		System.out.println(ticket.getPassengers());
		return iAirLineService.bookTicket(ticket);

	}

	@GetMapping("/cancel-ticket/{ticketId}")
	public Resource<String> cancelTicket(@PathVariable String ticketId) {
		Ticket ticket = iAirLineService.cancelTicket(ticketId);
		Resource<String> resources = new Resource<String>("Your Ticket is Cancelled");
		ControllerLinkBuilder linkInfo = new ControllerLinkBuilderFactory()
				.linkTo(methodOn(this.getClass()).bookTicket(ticket));
		resources.add(linkInfo.withRel("continue to book ticket"));
		return resources;

	}

	@GetMapping("/getAllbooking")
	public List<Ticket> getAllTicketDetails() {
		return iAirLineService.getAllbookingList();
	}

	@GetMapping("/getSinglebooking/{ticketId}")
	public Ticket getSingleTicketDetails(@PathVariable String ticketId) {
		Ticket ticket = iAirLineService.getSingleTicket(ticketId);
		System.out.println("dfdsfdsfds" + ticket);
		return ticket;
	}

}
