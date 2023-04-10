package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.Board;

public interface BoardInterface {
	
	List<Board> getBoards();
	
	Board getBoard(Long seq);

}
