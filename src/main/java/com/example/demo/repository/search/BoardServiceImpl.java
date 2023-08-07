package com.example.demo.repository.search;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Board;
import com.example.demo.dto.BoardDto;
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
	
}
