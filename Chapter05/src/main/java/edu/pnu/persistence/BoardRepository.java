package edu.pnu.persistence;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	
	@Query("Select b from Board b order by b.seq DESC") // 실행할 쿼리. method 호출 시 쿼리 실행
	List<Board> queryAnnotationTest(Pageable paging);

	List<Board> findByTitleContaining(String title);
	
	List<Board> findByTitleContainingAndCntGreaterThan(String title, long cnt);
	
	List<Board> findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqAsc(long cnt, long cnt1);
	
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);
	
}
