package edu.pnu.dao.member;

import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public interface MemberInterface {

	Map<String, Object> getMembers();

	Map<String, Object> getMember(Integer id);

	Map<String, Object> addMember(MemberVO member);

	MemberVO updateMember(MemberVO member);

	boolean deleteMember(Integer id);

}