package com.jee.helloworld.controller;

import com.jee.helloworld.model.Flight;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Controller
@RequestMapping("/flight")
public class FlightController {
	private ArrayList<Flight> flights = new ArrayList<>();

	@GetMapping
	public String getList(Model model) {
		model.addAttribute("flights", flights);
		return "flightList";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("flight", new Flight());
		return "flightForm";
	}

	@PostMapping(path = "/add")
	public String add(@ModelAttribute Flight pFlight) {
		pFlight.setId(generateFlightId());
		flights.add(pFlight);

		return "redirect:/flight";
	}

	@GetMapping("/edit")
	public String edit(Model model, @RequestParam("id") String id) {
		Flight flight = flights.stream()
	                        .filter(f -> f.getId().equals(id))
	                        .findAny()
	                        .orElse(null);

		model.addAttribute("flight", flight);
		return "flightForm";
	}

	@PostMapping(path = "/edit")
	public String edit(@ModelAttribute Flight pFlight) {
		Flight flight = flights.stream()
	                        .filter(f -> f.getId().equals(pFlight.getId()))
	                        .findAny()
	                        .orElse(null);

		if (flight != null) {
			int index = flights.indexOf(flight);
			flight.update(pFlight);
			flights.set(index, flight);
		}

		return "redirect:/flight";
	}

	@GetMapping(path = "/delete")
	public String delete(@RequestParam("id") String id) {
		flights.stream()
				.filter(f -> f.getId().equals(id))
				.findAny().ifPresent(f -> flights.remove(f));

		return "redirect:/flight";
	}

	public static String generateFlightId() {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 4; i++) { sb.append((char)(r.nextInt(26) + 'a')); }
		sb.append('-');
		for (int i = 0; i < 4; i++) { sb.append(r.nextInt(9)); }

		return sb.toString().toUpperCase();
	}
}
