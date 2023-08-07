package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.BoardDto;
import com.example.demo.repository.search.BoardService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

	@Autowired
	private BoardService boardService;
	
	@Test
	public void testRegister() {
		log.info(boardService.getClass().getName());
		
		BoardDto boardDto = BoardDto.builder()
				.title("sample Title")
				.content("Sample Content")
				.writer("user00")
				.build();
		
		Long bno = boardService.register(boardDto);
		
		log.info("bno : " + bno);
	}
}
