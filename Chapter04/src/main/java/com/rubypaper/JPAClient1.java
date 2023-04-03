package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JPAClient1 {
	
	public static void main(String[] args) {
		// EntityManger 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		
		// 데이터를 입력
		insertBoard(emf);
		
		/*
		EntityManager em = emf.createEntityManager();
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			// Transaction 시작
			tx.begin();
			
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록 잘 되네요.");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			// 글 등록
			em.persist(board); // persist->save
			
			// Transaction commit 
			tx.commit(); // transaction을 commit 하지 않으면 실제 db에 반영되지 않음
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			em.close();
			emf.close();
		}
		*/
	}

	private static void insertBoard(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			Board board = new Board();
			for(int i = 0; i < 10; i++) {
				board.setTitle("JPA 제목");
				board.setWriter("관리자");
				board.setContent("JPA 글 등록 잘 되네요.");
				board.setCreateDate(new Date());
				board.setCnt(0L);
			}
			em.persist(board);
			tx.commit();
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
