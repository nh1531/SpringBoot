package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.service.BoardService;

@SpringBootTest
class Chapter06THfullApplicationTests {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	BoardRepository boardRepo;

	//@Test
	void contextLoads() {
	}
	
	
}
