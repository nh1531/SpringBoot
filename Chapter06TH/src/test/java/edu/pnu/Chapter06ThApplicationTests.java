package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.service.BoardService;

@SpringBootTest
class Chapter06ThApplicationTests {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	BoardRepository boardRepo;

	//@Test
	void contextLoads() {
	}

	//@Test
	void getBoardList() {
		List<Board> list =  boardService.getBoardList();
		for (Board b : list) {
			System.out.println(b);
		}
	}
	
	//@Test
	void insertBoard() {
		Board b = new Board();
		b.setTitle("테스트");
		b.setContent("내용");
		b.setWriter("작성자");
		b.setCreateDate(new Date());
		b.setCnt(0L);
		boardRepo.save(b);
	}
	

}
