package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

@Controller // @Controller -> restapi 제공x
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 게시글 삭제
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
	// 게시글 수정
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	// 게시글 상세 조회
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		Board board1 = boardService.getBoard(board);
		model.addAttribute("board", board1);
		//model.addAttribute("board", boardService.getBoard(board));
		return "board/getBoard";
	}
	
	// 게시글 등록
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	// 게시글 등록 화면
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "board/insertBoard";
	}

	// 게시글 목록 조회
	@RequestMapping("/getBoardList") // @RequestMapping -> get, put, delete, post 전부 다 받음
	// method=RequestMethod.GET
	public String getBoardList(Model model, Board board) { // model -> interface
	//public List<Board> getBoardList(Model model) {
		List<Board> boardlist = boardService.getBoardList(board);
		/*
		for (long i = 1; i<= 10L; i++) {
			Board board = new Board();
			board.setSeq(i);
			board.setTitle("게시판 프로그램 테스트");
			board.setWriter("도우너");
			board.setContent("게시판 프로그램 테스트입니다..");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardlist.add(board);
		}
		*/
		model.addAttribute("boardlist", boardlist);
		//return "/WEB-INF/board/getboardlist.jsp"; -> application.properties에 설정해서 아래코드처럼 작성 가능
		return "board/getboardlist"; // web에 localhost:8080/getBoardList
		//return boardlist;
	}
	
}
