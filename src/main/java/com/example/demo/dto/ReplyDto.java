package com.example.demo.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDto {

	private Long rno;
	
	@NotNull
	private Long bno;
	
	@NotEmpty
	private String replyText;

	@NotEmpty
	private String replyer;
	
	private LocalDateTime regDate,modDate;
	
}
