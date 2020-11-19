package com.jee.helloworld.controller;

import com.jee.helloworld.model.Earthquake;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("/earthquake")
public class EarthquakeController {
	ArrayList<Earthquake> earthquakes = new ArrayList<>();

	@GetMapping
	public String list(HttpSession session, Model model) {
		model.addAttribute("earthquakes", earthquakes);

		return "earthquakeList";
	}

	@GetMapping("/add")
	public String add(HttpSession session, Model model) {
		//Next line is mandatory for the form to work
		model.addAttribute("earthquake", new Earthquake());
		return "earthquakeForm";
	}

	@PostMapping(path = "/add")
	public String add(HttpSession session, @ModelAttribute Earthquake earthquake) {
		earthquake.setId(UUID.randomUUID());
		session.setAttribute("earthquake", earthquake);
		earthquakes.add(earthquake);

		return "redirect:/earthquake";
	}

	@GetMapping("/edit")
	public String edit(HttpSession session, Model model, @RequestParam("id") UUID id) {
		Earthquake earthquake = earthquakes.stream()
				.filter(pEarthquake -> pEarthquake.getId().equals(id))
				.findAny()
				.orElse(null);

		model.addAttribute("earthquake", earthquake);
		return "earthquakeForm";
	}

	@PostMapping(path = "/edit")
	public String edit(HttpSession session, @ModelAttribute Earthquake pEarthquake) {
		Earthquake earthquake = earthquakes.stream()
				                        .filter(e -> e.getId().equals(pEarthquake.getId()))
				                        .findAny()
				                        .orElse(null);

		if (earthquake != null) {
			int index = earthquakes.indexOf(earthquake);
			earthquake.update(pEarthquake);
			earthquakes.set(index, earthquake);
		}

		return "redirect:/earthquake";
	}

	@GetMapping(path = "/delete")
	public String delete(HttpSession session, @RequestParam("id") UUID id) {
		earthquakes.stream()
				.filter(pEarthquake -> pEarthquake.getId().equals(id))
				.findAny().ifPresent(earthquake -> earthquakes.remove(earthquake));

		return "redirect:/earthquake";
	}
}
