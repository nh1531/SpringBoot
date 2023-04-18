package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/getBoardList")
	public String getBoardList(Model model, Board board){
		List<Board> boardList = boardService.getBoardList(board);
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}
	
	@GetMapping("/getBoard")
	public void getBoard(Model model, Board board) {
		Board bo = boardService.getBoard(board);
		model.addAttribute("board", bo);
	}
	
	@GetMapping("/insertBoard")
	public void insertBoardView() {
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Model model, Board board) {
		Board bo = boardService.insertBoard(board);
		model.addAttribute("board", bo);
		return "redirect:getBoardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Model model, Board board) {
		Board bo = boardService.updateBoard(board);
		model.addAttribute("board", bo);
		return "redirect:getBoard";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
	

	

}
