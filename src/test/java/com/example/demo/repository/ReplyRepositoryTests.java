package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Board;
import com.example.demo.domain.Reply;
import com.example.demo.repository.search.ReplyRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {

	@Autowired
	private ReplyRepository replyRepository;
	
	@Test
	public void testInsert() {
		
		//실제 DB에 있는 bno
		Long bno = 100L;
		
		Board board = Board.builder().bno(bno).build();
		
		Reply reply = Reply.builder()
				.board(board)
				.replyText("댓글...")
				.replyer("replyer1")
				.build();
		
		replyRepository.save(reply);
	}
}
