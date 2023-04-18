package edu.pnu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;

@Service
public interface BoardService {

	List<Board> getBoardList(Board board);

	Board getBoard(Board board);

	Board insertBoard(Board board);

	Board updateBoard(Board board);

	void deleteBoard(Board board);

	

	

}
