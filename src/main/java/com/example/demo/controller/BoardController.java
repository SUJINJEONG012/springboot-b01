package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.PageRequestDto;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("/list")
	public void list(PageRequestDto pageRequestDto, Model model) {
		
		PageResponseDto<BoardDto> responseDto = boardService.list(pageRequestDto);
		log.info(responseDto);
		model.addAttribute("responseDto", responseDto);
	}
	
	// 등록처리
	@GetMapping("/register")
	public void registerGet() {
		
	}
	
	@PostMapping("/register")
	public String registerPost(@Valid BoardDto boardDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		log.info("board Post Register....");
		if(bindingResult.hasErrors()) {
			log.info("has errors.....");
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/board/register";
		}
		
		log.info(boardDto);
		
		Long bno = boardService.register(boardDto);
		
		redirectAttributes.addFlashAttribute("result", bno);
		
		return "redirect:/board/list";
	}
	
	@GetMapping({"/read", "/modify"})
	public void read(Long bno, PageRequestDto pageRequestDto, Model model) {
		BoardDto boardDto = boardService.readOne(bno);
		
		log.info(boardDto);
		
		model.addAttribute("dto", boardDto);
	}
	
	
	@PostMapping("/modify")
	public String modify(PageRequestDto pageRequestDto, @Valid BoardDto boardDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		log.info("Board Modify Post.......");
		
		if(bindingResult.hasErrors()) {
			log.info("has errors........");
			String link = pageRequestDto.getLink();
			redirectAttributes.addAttribute("bno", boardDto.getBno());
			return "redirect:/board/modify?"+link;
		}
		
		boardService.modify(boardDto);
		
		redirectAttributes.addFlashAttribute("result", "modified");
        redirectAttributes.addAttribute("bno", boardDto.getBno());
		return "redirect:/board/read";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes redirectAttributes) {
		log.info("remove post...." + bno);
		
		boardService.remove(bno);
		
		redirectAttributes.addFlashAttribute("result","removed");
		return "redirect:/board/list"; 
	}
}
