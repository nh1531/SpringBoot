package com.rubypaper;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.rubypaper.domain.Board1;

public class JPAClient1 {
	
	public static void main(String[] args) {
		// EntityManger 생성. 생성한 곳에서 닫기
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		
		// 데이터를 입력
		//insertBoard(emf);
		// id가 1인 데이터를 출력
		findBoardOne(emf, 1L); // int와 long 구분
		// 입력된 전체 데이터를 출력(JPA Query)
		findBoardManyJPAQuery(emf);
		//입력된 전체 데이터를 출력(Native Query)
		findBoardManyNativeQuery(emf);
		
		// id가 1인 데이터를 수정
		//updateBoard(emf, 1L);
		// 수정된 정보를 확인
		findBoardOne(emf, 1L);
		
		// id가 2인 데이터를 삭제
		//deleteBoard(emf, 2L);
		// 삭제 결과를 확인
		findBoardManyJPAQuery(emf);
		
		emf.close();
	}

	

	private static void findBoardManyNativeQuery(EntityManagerFactory emf) {
		
		EntityManager em = emf.createEntityManager();
		
		// 방법 3-1
		List<?> list1 = em.createNativeQuery("select * from Board", Board1.class).getResultList();
		for (Object b : list1) {
			System.out.println(b);
		}
		System.out.println("-".repeat(60));
		// 방법 3-2
		List<Object[]> list2 = em.createNativeQuery("select * from Board").getResultList();
		for (Object[] b : list2) {
			for(int i = 0; i < b.length; i++) {
				if(i != 0) System.out.print(",");
				System.out.print(b[i]);
			}
			System.out.println();
		}
		System.out.println("=".repeat(80));
		
		em.close();
	}



	private static void findBoardManyJPAQuery(EntityManagerFactory emf) {

		EntityManager em = emf.createEntityManager();
		
		//TypedQuery<Board> result = em.createQuery("select b from Board b", Board.class); //1줄?
		String jpql = "select b from Board b order by b.seq desc";
		List<Board1> boardList = em.createQuery(jpql, Board1.class).getResultList();
		for (Board1 brd : boardList) {
			System.out.println("--->" + brd);
		}
		em.close();
	}


	private static void findBoardOne(EntityManagerFactory emf, long l) {
		// 트랜잭션은 select에는 사용x, insert, update, delete에만 사용
		emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		try {
			// 글 상세 조회
			Board1 searchBoard = em.find(Board1.class, 1L);
			System.out.println("--->" + searchBoard.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
			emf.close();
		}
		
	}

	private static void insertBoard(EntityManagerFactory emf) {
		// EntityManager 생성
		emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			//Transaction 시작
			tx.begin();
			
			for(int i = 0; i < 5; i++) {
				Board1 board = new Board1();
				board.setTitle("JPA 제목");
				board.setWriter("관리자");
				board.setContent("JPA 글 등록 잘 되네요.");
				board.setCreateDate(new Date());
				board.setCnt(0L);
				
				// 글 등록
				em.persist(board);
			}
			//Transaction commit
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			// Transaction rollback
			tx.rollback();
		}
		finally {
			em.close();
		}
		
	}
}
