package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Board1;

public class JPAClient {
	
	public static void main(String[] args) {
		// EntityManger 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			for (int i = 1; i <= 10; i++) {
				Board board = Board.builder()
								.title("title" + i)
								.content("content" + i)
								.writer("writer")
								//.createDate(new Date())
								.build();
				em.persist(board);
			}
			tx.commit();
			
			tx.begin();
			for(int i = 1; i <= 10; i++) {
				Board1 board1 = Board1.builder()
								.title("title" + i)
								.content("content" + i)
								.writer("writer")
								.createDate(new Date())
								.build();
				em.persist(board1);
			}
			tx.commit();
			
			/*
			// Transaction 시작
			tx.begin();
			
			Board1 board = new Board1();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록 잘 되네요.");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			// 글 등록
			em.persist(board);
			
			// Transaction commit 
			tx.commit(); // transaction을 commit 하지 않으면 실제 db에 반영되지 않음
			*/
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			em.close();
			emf.close();
		}
	}
}
