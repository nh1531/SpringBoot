package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {

	@Autowired
	BoardRepository boardRepo;
	
	//@Test
	public void BoardInsertTest() {
		for(int i = 0; i <100; i++) {
			Board b = new Board();
			b.setTitle("테스트 제목" + i);
			b.setWriter("writer");
			b.setContent("테스트 내용" + i);
			b.setCreateDate(new Date());
			b.setCnt((long) (Math.random() * 100));
			
			boardRepo.save(b);
		}
	}
	
	//@Test
	public void findByTitleContaining() {
		List<Board> boardList = boardRepo.findByTitleContaining("1");
		
		System.out.println("검색 결과");
		for (Board board : boardList ) {
			System.out.println("--->" + board);
		}
	}
	
	//@Test
	public void findByTitleContainingAndCntGreaterThan() {
		List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1", 50);
		
		for (Board board : boardList) {
			System.out.println("--->" + board);
		}
	}
	
	@Test
	
	public void findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqAsc() {
		List<Board> boardList = boardRepo.findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqAsc(10, 50);
		
		for (Board board : boardList) {
			System.out.println("--->" + board);
		}
	}
	
	//@Test
	public void findByTitleContainingOrContentContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
		
		for(Board board : boardList) {
			System.out.println("--->" + board);
		}
	}
	
	
	
	
}
