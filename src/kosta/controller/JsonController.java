package kosta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.model.Member;

@RestController //MVC 역할이 아닌 순수하게 JSON 을 생성하기 위한 컨트롤러라고 지정
public class JsonController {

	@RequestMapping("/spring_json")
	public List<Member> spring_json() {
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("홍길동", "aa@aa.com"));
		list.add(new Member("박길동", "bb@bb.com"));
		
		return list;
	}
	
}
