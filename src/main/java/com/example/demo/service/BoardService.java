package com.example.demo.service;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.PageRequestDto;
import com.example.demo.dto.PageResponseDto;

public interface BoardService {

	Long register(BoardDto baordDto);
	BoardDto readOne(Long bno);
	void modify(BoardDto boardDto);
	void remove(Long bno);
	
	PageResponseDto<BoardDto> list(PageRequestDto pageRequestDto);
	
}
