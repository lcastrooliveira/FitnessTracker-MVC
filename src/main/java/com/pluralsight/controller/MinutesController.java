package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pluralsight.model.Exercise;

@Controller
public class MinutesController {

	/**
	 * 
	 * @param exercise
	 * @return
	 */
	@RequestMapping(value = "/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {
		System.out.println("exercise: "+exercise.getMinutes());
		//forward: -> Bypass view resolver, keeps request
		//redirect: -> Creates another request before redirect
		//return "redirect:addMoreMinutes.html";
		return "addMinutes";
	}
	
//	@RequestMapping(value = "/addMoreMinutes")
//	public String addMoreMinutes(@ModelAttribute("exercise") Exercise exercise) {
//		System.out.println("exercising: "+exercise.getMinutes());
//		return "addMinutes";
//	}
}
