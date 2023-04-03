package edu.pnu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.dao.MemberDaoListImpl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.domain.MemberVO;

public class MemberService {
	private MemberInterface memberDao;
	private Map<String , MemberInterface> map;
	
	public MemberService() {
		memberDao = new MemberDaoH2Impl();
		//memberDao = new MemberDaoListImpl();
		
		//map = new HashMap<>();
		//map.put("h2", new MemberDaoH2Impl());
		//map.put("list", new MemberDaoListImpl());
	}

	public List<MemberVO> getMembers() {
		return memberDao.getMembers();
	}

	public MemberVO getMember(Integer id) {
		return memberDao.getMember(id);
	}

	public MemberVO addMember(MemberVO member) {
		return memberDao.addMember(member);
	}

	public MemberVO updateMember(MemberVO member) {
		return memberDao.updateMember(member);
	}

	public boolean deleteMember(Integer id) {
		return memberDao.deleteMember(id);
	}

}
