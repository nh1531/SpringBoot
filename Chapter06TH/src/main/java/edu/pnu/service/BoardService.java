package edu.pnu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;

@Service
public interface BoardService {

	List<Board> getBoardList();

	Board getBoard(Long seq);

	Board insertBoard(Board board);

	Board updateBoard(Board board);

	void deleteBoard(Long seq);

	
}
