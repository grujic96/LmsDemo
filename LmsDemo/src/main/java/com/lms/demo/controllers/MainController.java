package com.lms.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lms.demo.repositories.LmsService;

@Controller
public class MainController {
	
	@Autowired
	private LmsService lmsService;
	
	@GetMapping("/")
	public String init() {
		return "index";
	}
	
}
