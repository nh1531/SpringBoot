package edu.pnu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j //log
@RestController
public class MemberController {
	
	MemberService memberService = new MemberService();
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class); // 메시지를 보여줄 class 이름
	
	// loggerFactory , lombok @Slf4j 없이 사용
	//private static 
	
	public MemberController(MemberService memberService) {
		//System.out.println("===> MemberController 생성");
		log.info("MemberController 생성자 호출");
		
		log.error("Error Message 입니다.");
		log.warn("Warn Message 입니다.");
		log.info("Info Message 입니다.");
		log.debug("Debug Message 입니다.");
		log.trace("Trace Message 입니다.");
		
		this.memberService = memberService;
	}
	
	// 모든 멤버 정보를 json 형태로 브라우저에 출력
	@GetMapping("/member") //select
	public List<MemberVO> getMembers(){
		return memberService.getMembers();
	}
	
	// 아이디가 {id}인 member를 찾아서 브라우저에 출력
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		System.out.println("getMember: " + id); // 1.controller가 호출되는지 확인 2.service 연결
		return memberService.getMember(id);
	}
	
	// 추가하고자 하는 member 정보를 전달,추가된 객체를 출력
	@PostMapping("/member") //insert
	public MemberVO addMember(MemberVO member) {
		System.out.println(member); //toString 있어야 보임
		return memberService.addMember(member);
	}
	
	// 수정 대상 객체 정보를 전달, 수정된 객체를 출력
	@PutMapping("/member") //update
	public MemberVO updateMembers(MemberVO member) {
		return memberService.updateMembers(member);
	}
	
	// 아이디가 {id}인 member를 찾아서 삭제, 브라우저에는 삭제된 객체를 출력
	@DeleteMapping("/member/{id}") //delete
	public MemberVO removeMember(@PathVariable Integer id) {
		return memberService.removeMember(id);
	}
	
	
	

}
