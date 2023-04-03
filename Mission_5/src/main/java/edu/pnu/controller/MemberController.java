package edu.pnu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	public MemberController(MemberService memberService) {
		log.info("MemberController() 생성자가 호출됨");
		this.memberService = memberService;
	}
	
	//@Autowired
	//setter
	
	

}
