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
		List<MemberVO> list = (List<MemberVO>)map.get("result");
		String msg = (String)map.get("msg");
		
		logDao.addLog("get",  msg,  list);
		
		return list;
	}	
	
	public MemberVO getMember(Integer id) {
		Map<String, Object> map = memberDao.getMember(id);
		
		MemberVO member = (MemberVO)map.get("result");
		String msg = (String) map.get("msg");
		
		logDao.addLog("get", msg, member);
		
		return member;
	}

	public MemberVO addMember(MemberVO member) {
		Map<String, Object> map = memberDao.addMember(member);
		
		MemberVO m = (MemberVO) map.get("result");
		String msg = (String) map.get("msg");
		
		logDao.addLog("post", msg, m);
		
		return m;
	}

	public MemberVO updateMember(MemberVO member) {
		Map<String, Object> map = memberDao.updateMember(member);
		
		MemberVO m = (MemberVO) map.get("result");
		String msg = (String) map.get("msg");
		
		logDao.addLog("put", msg, m);
		
		return m;
	}

	public boolean deleteMemeber(Integer id) {
		Map<String, Object> map = memberDao.deleteMember(id);
		
		String msg = (String) map.get("msg");
		logDao.addLog("delete", msg, id);
		
		return true;
	}

	

}
