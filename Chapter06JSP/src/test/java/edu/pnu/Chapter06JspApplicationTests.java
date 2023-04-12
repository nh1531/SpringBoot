package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.service.BoardService;

@SpringBootTest
class Chapter06JspApplicationTests {
	
	@Autowired
	BoardRepository boardRepo;
	
	@Autowired
	BoardService boardService;

	//@Test
	void contextLoads() {
	}
	
	@Test
	void insertDataTest() {
		for(int i=1; i<=10; i++) {
			boardRepo.save(Board.builder()
					.title("title" + i)
					.content("content" + i)
					.writer("writer" + i)
					.build()
					);
		}
	}
	

}
