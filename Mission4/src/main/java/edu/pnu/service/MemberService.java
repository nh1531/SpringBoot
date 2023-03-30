package edu.pnu.service;

import java.util.List;
import java.util.Map;

import edu.pnu.dao.log.LogDao;
import edu.pnu.dao.log.LogDaoH2Impl;
import edu.pnu.dao.member.MemberDaoH2Impl;
import edu.pnu.dao.member.MemberInterface;
import edu.pnu.domain.MemberVO;

public class MemberService {
	
	private MemberInterface memberDao;
	private LogDao logDao;
	
	public MemberService() {
		memberDao = new MemberDaoH2Impl();
		//memberDao = new MemberDaoListImpl();
		
		logDao = new LogDaoH2Impl();
	}

	public List<MemberVO> getMembers() {
		Map<String, Object> map = memberDao.getMembers();
		
		@SuppressWarnings("unchecked")
		List<MemberVO> list = (List<MemberVO>)map.get("data");
		String msg = (String)map.get("msg");
		
		logDao.addLog("Get",  msg,  list);
		
		return list;
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

	public boolean deleteMemeber(Integer id) {
		return memberDao.deleteMember(id);
	}

	

}
