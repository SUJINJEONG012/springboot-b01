package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Map<String, Long>> register(@RequestBody ReplyDto replyDto){
		log.info("replyDto : " + replyDto);
		Map<String, Long> resultMap = Map.of("rno", 111L);
		return ResponseEntity.ok(resultMap);
	}

	
	
}