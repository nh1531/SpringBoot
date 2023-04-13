package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/getBoardList")
	public void getBoardList(Model model, Board board) {
		
		model.addAttribute("boardlist", boardlist)
		// return "getBoardList"; // mapping url이랑 return url.html/jsp 이 같으면 void하면 자동 호출 
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("greeting","Hi Thymeleaf~");
		return "hello";
	}
	
	@GetMapping("/board")
	public List<Board> getBoardList(){
		return boardService.getBoardList();
	}
	
	@GetMapping("/board/{seq}")
	public Board getBoard(@PathVariable Long seq) {
		return boardService.getBoard(seq);
	}
	
	@PostMapping("/board")
	public Board insertBoard(Board board) {
		return boardService.insertBoard(board);
	}
	
	@PutMapping("/board")
	public Board updateBoard(Board board) {
		return boardService.updateBoard(board);
	}
	
	@DeleteMapping("/board/{seq}")
	public List<Board> deleteBoard(@PathVariable Long seq) {
		boardService.deleteBoard(seq);
		return boardService.getBoardList();
	}
	
	
	

}
