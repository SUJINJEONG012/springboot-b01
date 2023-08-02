package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class SampleJsonController {

	@GetMapping("/helloArr")
	public String[] helloArr() {
		log.info("@@@@helloArr..........");
		return new String[] {"AAA","BBB","CCC"};
	}
}

