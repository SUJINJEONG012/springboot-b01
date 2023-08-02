package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller	
@Log4j2
public class SampleController {

	@GetMapping("/hello2")
	public void hello(Model model){
		log.info("Hello..........");
		model.addAttribute("msg","Hello World");
	}
}
