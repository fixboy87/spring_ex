package kosta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kosta.model.Board;
import kosta.service.BoardService;

@Controller
public class BoardController {
	BoardService service;
	List<Board> list;
	Board board;
	
	@RequestMapping(value = "/board_insert", method=RequestMethod.GET)
	public String insertForm(Model model) {
		model.addAttribute("title", "±Û¾²±âÆû");
		return "insert_form";
	}

	@RequestMapping(value = "/board_insert", method=RequestMethod.POST)
	public String board_insert(Board board) {

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
	
}
