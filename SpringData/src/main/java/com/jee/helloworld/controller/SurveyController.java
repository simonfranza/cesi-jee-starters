package com.jee.helloworld.controller;

import com.jee.helloworld.model.Survey;
import com.jee.helloworld.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	private SurveyRepository surveyRepository;

	@GetMapping
	public String listAll(Model pModel) {
		List<Survey> surveys = surveyRepository.findAll();
		pModel.addAttribute("surveys", surveys);

		return "surveyList";
	}

	@GetMapping("/create")
	public String create(Model pModel){
		pModel.addAttribute("survey", new Survey());

		return "surveyForm";
	}

	@PostMapping(path = "/create")
	public String create(@ModelAttribute Survey pSurvey){
		surveyRepository.save(pSurvey);

		return "redirect:/survey";
	}

	@GetMapping("/update")
	public String update(Model pModel, @RequestParam("surveyId") int earthquakeId){
		Survey survey = surveyRepository.findOne(earthquakeId);
		pModel.addAttribute("survey", survey);

		return "surveyForm";
	}

	@PostMapping(path = "/update")
	public String update(@ModelAttribute Survey pSurvey){
		surveyRepository.save(pSurvey);

		return "redirect:/survey";
	}

	@GetMapping(path = "/delete")
	public String delete(@RequestParam("surveyId") int earthquakeId) {
		surveyRepository.delete(earthquakeId);

		return "redirect:/survey";
	}
}
