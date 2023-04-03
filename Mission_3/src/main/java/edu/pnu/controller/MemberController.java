package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	MemberService memberService;
	
	public MemberController() {
		this.memberService = new MemberService();
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		System.out.println("geMembers");
		return memberService.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		System.out.println("getMember");
		return memberService.getMember(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO member) {
		System.out.println("addMember");
		return memberService.addMember(member);
	}
	
	@PutMapping("/member")
	public MemberVO updateMember(MemberVO member) {
		System.out.println("updateMember");
		return memberService.updateMember(member);
	}
	
	@DeleteMapping("/member/{id}")
	public boolean deleteMember(@PathVariable Integer id) {
		System.out.println("deleteMember");
		return memberService.deleteMember(id);
	}
	
}
