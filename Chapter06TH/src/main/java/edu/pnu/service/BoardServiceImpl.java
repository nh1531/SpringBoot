package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired 
	BoardRepository boardRepo;

	@Override
	public List<Board> getBoardList() {
		return (List<Board>) boardRepo.findAll();
	}

	@Override
	public Board getBoard(Long seq) {
		return boardRepo.findById(seq).get();
	}

	@Override
	public Board insertBoard(Board board) {
		return boardRepo.save(board);
	}

	@Override
	public Board updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		return boardRepo.save(findBoard);
	}

	@Override
	public void deleteBoard(Long seq) {
		boardRepo.deleteById(seq); 
	}

	
	

	

}
