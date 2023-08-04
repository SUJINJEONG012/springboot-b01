package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	//페이징 처리를 위해 findAll()사용
	
}
