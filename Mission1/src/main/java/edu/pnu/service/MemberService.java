package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	List<MemberVO> list = new ArrayList<>();
	
	public MemberService(){ // 생성되자마자 member 데이터 들어감. getMembers에 넣으면 get이 호출되어야지 데이터가 들어감
		for(int i = 1; i <= 10; i++) {
			MemberVO member = new MemberVO();
			member.setId(i);
			member.setPass("테스트 비밀번호");
			member.setName("테스트 이름");
			member.setRegidate(new Date());
			list.add(member);
		}
		
	}
	
	public List<MemberVO> getMembers(){
		return list;
	}
	
	public MemberVO getMember(Integer id) {
		for (MemberVO m : list) {
			if(m.getId() == id)
				return m;
		}
		return null;
	}
	
	public MemberVO addMember(MemberVO member) {
		int id = list.size()+1;
		String pass = member.getPass();
		String name = member.getName();
		Date regidate = new Date();
		MemberVO m = new MemberVO();
		m.setId(id);
		m.setPass(pass);
		m.setName(name);
		m.setRegidate(regidate);
		list.add(member);
		return member;
	}
	
	public MemberVO updateMembers(MemberVO member) {
		for (MemberVO m : list) {
			if(m.getId() == member.getId()) {
				m.setName(member.getName());
				m.setPass(member.getPass());
				return m;
			}
		}
		
		//MemberVO m = getMember(member.getId());
		//if(m != null) {
		//}
		return null;
	}
	
	public MemberVO removeMember(Integer id) {
		for (MemberVO m : list) {
			if(m.getId() == id) {
				list.remove(m);
				return m;
			}
		}
		return null;
	}

}
