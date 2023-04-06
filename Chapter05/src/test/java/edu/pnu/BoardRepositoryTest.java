package edu.pnu;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository boardRepo;
	
	//@Test
	public void BoardInsertTest() {
		
		for(int i = 0 ; i < 10 ; i++) {
			Board b = new Board();
			b.setTitle("title");
			b.setContent("content");
			b.setWriter("writer");
			b.setCreateDate(new Date());
			b.setCnt(0L);
			
			boardRepo.save(b);
		}
		
	}
	
	//@Test
	public void BoardGetTest() {
		Board board = boardRepo.findById(1L).get();
		System.out.println(board);
	}
	
	//@Test
	public void BoardUpdateTest() {
		System.out.println("===1번 게시글 조회===");
		Board board = boardRepo.findById(1L).get();
		
		System.out.println("===1번 게시글 제목 수정");
		board.setTitle("제목을 수정했습니다");
		boardRepo.save(board);
	}
	
	//@Test
	public void BoardDeleteTest() {
		boardRepo.deleteById(2L);
	}
	
	@Test
	public void test() { // 페이징
		Pageable paging = PageRequest.of(0, 3);
		List<Board> list = boardRepo.queryAnnotationTest(paging);
				
		for (Board b : list) 
			System.out.println(b);
	}
	

}
