package com.example.demo.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.example.demo.domain.Board;
import com.example.demo.domain.QBoard;
import com.querydsl.jpa.JPQLQuery;


public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch{

	public BoardSearchImpl() {
		super(Board.class);
	}

	@Override
	public Page<Board> search1(Pageable pageable) {
		QBoard board = QBoard.board;
		JPQLQuery<Board> query = from(board);
		query.where(board.title.contains("1"));
		return null;
	}

	
}
