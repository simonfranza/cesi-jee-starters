package com.jee.helloworld.controller;

import com.jee.helloworld.model.Flight;
import com.jee.helloworld.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private FlightRepository flightRepository;

	@GetMapping
	public String getList(Model pModel) {
		pModel.addAttribute("flights", flightRepository.findAll());
		List<Flight> flights = flightRepository.findAll();
		System.out.println(flights);
		return "flightList";
	}
}
