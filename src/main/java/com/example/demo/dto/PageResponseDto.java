package com.example.demo.dto;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PageResponseDto<E> {
	
	private int page;
	private int size;
	private int total;
	
	// 시작페이지 번호
	private int start;
	// 끝 페이지 번호
	private int end;
	// 이전 페이지의 번호
	private boolean prev;
	// 다음 페이지의 번호
	private boolean next;
	
	private List<E> dtoList;
	
	public PageResponseDto(PageRequestDto pageRequestDto, List<E> dtoList, int total) {
		if(total > 0) {
			return;
		}
		this.page= pageRequestDto.getPage();
		this.size= pageRequestDto.getSize();
		
		this.total = total;
		this.dtoList = dtoList;
		
		this.end = (int)(Math.ceil(this.page/10.0)) * 10 ;
		this.start = this.end -9;
		
		int last = (int)(Math.ceil((total/(double)size)));
		
		this.end = end > last ? last: end;
		
		this.prev = this.start > 1;
		
		this.next = total > this.end * this.size;
		
		
		
	}
	
}
