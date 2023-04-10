package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.DBoard;
import edu.pnu.service.BoardService;

@Controller // return void or string. 파일 이름
public class BoardController1 {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/board")
	//public List<DBoard> getBoardList(Model model){
	public void getBoardList(Model model) {
		List<DBoard> list = boardService.getBoardList();
		model.addAttribute("boardList", list);
	}
	
	@GetMapping("/board")
	// Long nullable, long null값 취급x
	public DBoard getBoard(Long seq){
		return boardService.getBoard(seq);
	}
	
	/*
	// parameter 형식 ?=..
	@GetMapping("/board")
	public List<DBoard> getBoard(Long seq){
		if(seq == null) return boardService.getBoardList();
		
		List<DBoard> list = new ArrayList<>();
		list.add(boardService.getBoard(seq));
		return list;
	}
	*/
	
	@GetMapping("/board/{seq}")
	public DBoard getBoardbyPath(@PathVariable Long seq){
		
		System.out.println("getBoard PathVariable : " + seq);
		return boardService.getBoard(seq);
	}

}
