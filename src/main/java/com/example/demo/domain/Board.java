package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Board {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long bno;
	
	@Column(length =500, nullable=false)
	private String title;
	@Column(length =2000, nullable = false)
	private String content;
	@Column(length= 50, nullable= false)
	private String writer;
	
}
