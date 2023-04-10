package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;

@Service
public class BoardService {
	List<Board> list = new ArrayList<>();

	public List<Board> getBoards() {
		return list;
	}

	public Board getBoard(Long seq) {
		for(Board b : list) {
			if(b.getSeq() == seq) {
				return b;
			}
		}
		return null;
	}

}
