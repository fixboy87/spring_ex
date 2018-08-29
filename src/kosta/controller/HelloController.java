package kosta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.service.HelloService;

@Controller
public class HelloController {
	HelloService service;
	
/*	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "hello!!!");
		mav.addObject("message", service.getMessage());
		mav.setViewName("hello");
		
		return mav;
	}*/
	
	@RequestMapping("/hello.do")
	public String hello(Model model) {
		model.addAttribute("message", service.getMessage());
		
		return "hello";
	}
	
	public HelloController() {
		// TODO Auto-generated constructor stub
	}

	public HelloController(HelloService service) {
		super();
		this.service = service;
	}
	
	@Autowired
	public void setService(HelloService service) {
		this.service = service;
	}
	
}
