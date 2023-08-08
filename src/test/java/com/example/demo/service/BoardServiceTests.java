package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.PageRequestDto;
import com.example.demo.dto.PageResponseDto;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

	@Autowired
	private BoardService boardService;
	
//	@Test
//	public void testRegister() {
//		log.info(boardService.getClass().getName());
//		
//		BoardDto boardDto = BoardDto.builder()
//				.title("sample Title")
//				.content("Sample Content")
//				.writer("user00")
//				.build();
//		
//		Long bno = boardService.register(boardDto);
//		
//		log.info("bno : " + bno);
//	}
	
//	@Test
//	public void testModify() {
//		//변경에 필요한 데이터만
//		BoardDto boardDto = BoardDto.builder()
//				.bno(101L)
//				.title("Update...")
//				.content("Updated.....content 101...")
//				.build();
//		
//		boardService.modify(boardDto);
//		
//	}
	
	@Test void testList() {
		PageRequestDto pageRequestDto = PageRequestDto.builder()
				.type("tcw")
				.keyword("1")
				.page(1)
				.size(10)
				.build();
		
		PageResponseDto<BoardDto> responseDto = boardService.list(pageRequestDto);
		log.info( "responseDto : " + responseDto);
	}
	
	
}
