package com.jee.helloworld.controller;

import com.jee.helloworld.model.Booking;
import com.jee.helloworld.repository.BookingRepository;
import com.jee.helloworld.repository.FlightRepository;
import com.jee.helloworld.repository.TravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private TravellerRepository travellerRepository;

	@Autowired
	private FlightRepository flightRepository;

	@GetMapping
	public String getList(Model pModel) {
		pModel.addAttribute("bookings", bookingRepository.findAll());
		return "bookingList";
	}

	@GetMapping("/create")
	public String create(Model pModel) {
		pModel.addAttribute("booking", new Booking());

		return "bookingForm";
	}

	@PostMapping(path = "/create")
	public String create(@ModelAttribute Booking pBooking) {

		travellerRepository.save(pBooking.getTraveller());
		flightRepository.save(pBooking.getFlight());

		bookingRepository.save(pBooking);
		return "redirect:/booking";
	}

	@GetMapping("/update")
	public String update(Model pModel, @RequestParam("bookingId") int bookingId){
		Booking booking = bookingRepository.findOne(bookingId);
		pModel.addAttribute("booking", booking);

		return "bookingForm";
	}

	@PostMapping(path = "/update")
	public String update(@ModelAttribute Booking pBooking){
		travellerRepository.save(pBooking.getTraveller());
		flightRepository.save(pBooking.getFlight());
		bookingRepository.save(pBooking);

		return "redirect:/booking";
	}

	@GetMapping(path = "/delete")
	public String delete(@RequestParam("bookingId") int bookingId) {
		bookingRepository.delete(bookingId);

		return "redirect:/booking";
	}
}
