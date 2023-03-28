package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

@SpringBootTest
class Mission2ApplicationTests {
	
	@Autowired
	MemberDAO memberDAO; // repository에서 가져옴

	//@Test
	void contextLoads() {
		System.out.println("이것은 테스트입니다.");
	}
	
	@Test
	void testMemberDAO() {
		System.out.println("이것은 MemberDAO를 테스트합니다.");
		
		//MemberDAO memberDAO = new MemberDAO();
		
		List<MemberVO> list =  memberDAO.getMembers();
		for (MemberVO m : list) {
			System.out.println(m);
		}
	}
}
