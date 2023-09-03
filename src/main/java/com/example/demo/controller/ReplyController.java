package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ReplyDto;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/replies")
@Log4j2
public class ReplyController {

	@ApiOperation(value="Replies Post", notes="POST 방식으로 댓글 등록")
	@PostMapping(value="/", consumes= MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Long> register(@RequestBody ReplyDto replyDto, BindingResult bindingResult) throws BindException{
		
		log.info("replyDto : " + replyDto);
		
		if(bindingResult.hasErrors()) {
			throw new BindException(bindingResult);
		}
		
		Map<String, Long> resultMap = new HashMap<>();
		resultMap.put("rno", 111L);
		
		return resultMap;
	}

	
	
}