package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Board;
import com.example.demo.dto.BoardDto;
import com.example.demo.dto.PageRequestDto;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {

	private final ModelMapper modelMapper;
	private final BoardRepository boardRepository;
	
	@Override
	public Long register(BoardDto baordDto) {
		
		Board board = modelMapper.map(baordDto, Board.class);
		Long bno = boardRepository.save(board).getBno();
		
		return bno;
	}

	@Override
	public BoardDto readOne(Long bno) {
		
		Optional<Board> result = boardRepository.findById(bno);
		Board board = result.orElseThrow();
		BoardDto boardDto = modelMapper.map(board, BoardDto.class);
		
		return boardDto;
	}

	@Override
	public void modify(BoardDto boardDto) {
		Optional<Board> result = boardRepository.findById(boardDto.getBno());
		Board board = result.orElseThrow();
		board.change(boardDto.getTitle(), boardDto.getContent());
		boardRepository.save(board);
		
	}

	@Override
	public void remove(Long bno) {
		boardRepository.deleteById(bno);	
	}

	@Override
	public PageResponseDto<BoardDto> list(PageRequestDto pageRequestDto) {
		
		String[] types = pageRequestDto.getTypes();
		
		String keyword = pageRequestDto.getKeyword();
		
		Pageable pageable = pageRequestDto.getPageable("bno");
		
		Page<Board> result = boardRepository.searchAll(types, keyword, pageable);
		
		List<BoardDto> dtoList = result.getContent().stream()
				.map(board-> modelMapper.map(board, BoardDto.class)).collect(Collectors.toList());
		
		
		return PageResponseDto.<BoardDto> widthAll()
				.pageRequestDto(pageRequestDto)
				.dtoList(dtoList)
				.total((int)result.getTotalElements())
				.build();
	}
	
}
