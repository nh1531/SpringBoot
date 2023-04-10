package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService bservice;
	
	public BoardController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/board")
	public List<Board> getBoards(){
		return bservice.getBoards();
	}
	
	@GetMapping("/board/{seq}")
	public Board getBoard(Long seq) {
		return bservice.getBoard(seq);
	}
	
}
