package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	MemberService memberService = new MemberService();
	
	//@GetMapping("/member")
	//public List<MemberVO> getMembers(){
		//memberService.getMembers();
	//}

}
