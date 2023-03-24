package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	
	private MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}
	
	// h2 database member 테이블에서 데이터를 읽어서 리스트 배열을 만들어서 리턴한다.
	public List<MemberVO> getMembers(){
		return memberDAO.getMembers();
	}
	
	public MemberVO getMember(Integer id) {
		return memberDAO.getMember(id);
	}
	
	public MemberVO addMember(MemberVO member) {
		return memberDAO.addMember(member);
	}
	
	public MemberVO updateMembers(MemberVO member) {
//		for (MemberVO m : list) {
//			if(m.getId() == member.getId()) {
//				m.setName(member.getName());
//				m.setPass(member.getPass());
//				//return m;
//			}
//		}
		
		//MemberVO m = getMember(member.getId());
		//if(m != null) {
		//}
		return null;
	}
	
	public MemberVO removeMember(Integer id) {
//		for (MemberVO m : list) {
//			if(m.getId() == id) {
//				list.remove(m);
//				return m;
//			}
//		}
		return null;
	}

}
