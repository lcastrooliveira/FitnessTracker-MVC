package com.pluralsight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.service.ExerciseService;

@Controller
public class MinutesController {

	@Autowired
	private ExerciseService exerciseService;
	
	@RequestMapping(value = "/addMinutes", method = RequestMethod.GET)
	public String addMinutes(Model model) {
		Exercise exercise = new Exercise();
		exercise.setMinutes(5);
		exercise.setActivity("Run");
		model.addAttribute("exercise", exercise);
		System.out.println("exercise: "+exercise.getMinutes());
		System.out.println("exercise activity "+ exercise.getActivity());
		//forward: -> Bypass view resolver, keeps request
		//redirect: -> Creates another request before redirect
		//return "redirect:addMoreMinutes.html";
		return "addMinutes";
	}
	
	@RequestMapping(value = "/addMinutes", method = RequestMethod.POST)
	public String updateMinutes(@Valid @ModelAttribute("exercise") Exercise exercise, BindingResult result) {
		System.out.println("exercise: "+exercise.getMinutes());
		System.out.println("exercise activity "+ exercise.getActivity());
		System.out.println(result.hasErrors());
		System.out.println(exercise.getActivity() != null ? "yes" : "no");
		//forward: -> Bypass view resolver, keeps request
		//redirect: -> Creates another request before redirect
		//return "redirect:addMoreMinutes.html";		
		return "addMinutes";
	}
	
	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {
		return exerciseService.findAllActivities();
	}
	
//	@RequestMapping(value = "/addMoreMinutes")
//	public String addMoreMinutes(@ModelAttribute("exercise") Exercise exercise) {
//		System.out.println("exercising: "+exercise.getMinutes());
//		return "addMinutes";
//	}
}
