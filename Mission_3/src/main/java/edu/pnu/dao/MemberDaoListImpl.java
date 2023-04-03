package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoListImpl implements MemberInterface {
	List<MemberVO> list = new ArrayList<>();

	public MemberDaoListImpl() {
		for(int i = 1; i <= 5; i++) {
			MemberVO member = new MemberVO();
			member.setId(i);
			member.setPass("pass" + i);
			member.setName("name" + i);
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
		int id = member.getId();
		String pass = member.getPass();
		String name = member.getName();
		MemberVO m = new MemberVO(id, pass, name, new Date());
		list.add(member);
		return m;
	}
	
	public MemberVO updateMember(MemberVO member) {
		for (MemberVO m : list) {
			if (m.getId() == member.getId()) {
				m.setName(member.getName());
				m.setPass(member.getPass());
				return m;
			}
		}
		return null;
	}
	
	public boolean deleteMember(Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id) {
				list.remove(m);
				return true;
			}
		}
		return false;
	}
}
