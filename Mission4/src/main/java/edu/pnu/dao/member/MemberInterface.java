package edu.pnu.dao.member;

import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public interface MemberInterface {

	Map<String, Object> getMembers();

	MemberVO getMember(Integer id);

	MemberVO addMember(MemberVO member);

	MemberVO updateMember(MemberVO member);

	boolean deleteMember(Integer id);

}