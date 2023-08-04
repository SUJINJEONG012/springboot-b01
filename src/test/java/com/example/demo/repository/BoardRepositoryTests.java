package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.domain.Board;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

	@Autowired
	private BoardRepository boardRepository;
	
	//insert 테스트 
//	@Test
//	public void testInsert() {
//		IntStream.rangeClosed(1,100).forEach(i -> {
//			Board board = Board.builder()	
//					.title("title" + i)
//					.content("content"+i)
//					.writer("user" + (i % 10))
//					.build();
//			
//			Board result = boardRepository.save(board);
//			log.info("BNO:" + result.getBno());
//					
//		});
//	}
	
//	@Test
//	public void testSelect() {
//		Long bno = 100L;
//		Optional<Board> result = boardRepository.findById(bno);
//		
//		Board board = result.orElseThrow();
//		log.info(board);
//	}
	
//	@Test
//	public void testUpdate() {
//		Long bno = 100L;
//		Optional<Board> result = boardRepository.findById(bno);
//		Board board = result.orElseThrow();
//		board.change("Update...Title 100", "Update content 100");
//		boardRepository.save(board);
//	}
//	
	
//	@Test
//	public void testDelete() {
//		Long bno =1L;
//		boardRepository.deleteById(bno);
//	}
	
	@Test
	public void testPaging() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
		Page<Board> result = boardRepository.findAll(pageable);
		
		log.info("Total count : " + result.getTotalElements());
		log.info("Total pages : " + result.getTotalElements());
		log.info("Page number: " + result.getNumber());
		log.info("Page Size : " + result.getSize());
		
		List<Board> todoList = result.getContent();
		todoList.forEach(board -> log.info(board));
	
	}
	
	
	
}
