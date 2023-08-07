package com.example.demo.repository.search;

import com.example.demo.dto.BoardDto;

public interface BoardService {

	Long register(BoardDto baordDto);
	BoardDto readOne(Long bno);
}
