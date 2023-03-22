package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Person;
import edu.pnu.service.BoardService;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
@RestController
public class BoardController {
	
	//@Autowired
	BoardService boardService = new BoardService();
	
	
	public BoardController() {
		System.out.println("===> BoardController 생성");
		//log.info("===> BoardController 생성");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}
	
	@PostMapping("/hello")
	public String hello1(String name) {
		return "Hello Post : " + name;
	}
	
	@GetMapping("/getPerson")
	public Person getPerson() {
		return null;
		//return new Person("홍길동", 2000, "백수", "선플");
	}
	
	@GetMapping("/getPersons")
	public List<Person> getPersons() {
		List<Person> list = new ArrayList<>();
		//list.add(new Person("홍길동", 2000, "백수", "선플"));
		//list.add(new Person("홍이동", 2001, "백수", "축구"));
		//list.add(new Person("홍이동", 2003, "백수", "독서"));
		return list;
		
	}
}
