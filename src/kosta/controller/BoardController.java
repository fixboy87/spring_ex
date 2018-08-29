package kosta.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kosta.model.Board;
import kosta.model.BoardValidator;
import kosta.service.BoardService;

@Controller
public class BoardController {
	BoardService service;
	List<Board> list;
	Board board;
	
	@RequestMapping(value = "/board_insert", method=RequestMethod.GET) //시작시에 BoardCommand 객체를 요구한다.
	public String insertForm(@ModelAttribute("boardCommand") Board board, Model model) {
		
		model.addAttribute("title", "글쓰기폼");
		return "insert_form";
	}

	@RequestMapping(value = "/board_insert", method=RequestMethod.POST)
	public String board_insert(@ModelAttribute("boardCommand") @Valid Board board, BindingResult errors) { 

		if(errors.hasErrors()) {
			System.out.println("error 발생");
			return "insert_form";
		}
		
		service.insertBoardService(board);
		
		return "redirect:board_list";
	}
	
	@RequestMapping("/board_list")
	public String board_list(Model model) {
		
		list = service.listBoardService();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@Autowired
	public BoardController(BoardService service) {
		super();
		this.service = service;
	}

	public BoardController(){};
	
	
	/*@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.setValidator(new BoardValidator());
	}*/
}
