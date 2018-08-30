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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kosta.model.Board;
import kosta.model.BoardValidator;
import kosta.service.BoardService;

@Controller
public class BoardController {
	BoardService service;
	List<Board> list;
	Board board;
	
	@RequestMapping(value = "/board_insert", method=RequestMethod.GET) //���۽ÿ� BoardCommand ��ü�� �䱸�Ѵ�.
	public String insertForm(@ModelAttribute("boardCommand") Board board, Model model) {
		
		model.addAttribute("title", "오늘의 제목");
		return "insert_form";
	}

	@RequestMapping(value = "/board_insert", method=RequestMethod.POST)
	public String board_insert(@ModelAttribute("boardCommand") @Valid Board board, BindingResult errors) { 

		if(errors.hasErrors()) {
			return "insert_form";
		}
		
		service.insertBoardService(board);
		
		return "redirect:board_list";
	}
	
	@RequestMapping(value = "/board_list", method=RequestMethod.GET)
	public String board_list(Model model) {
		
		list = service.listBoardService();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	
	@RequestMapping(value="/board_detail{seq}", method=RequestMethod.GET)
	public String board_detail(@PathVariable int seq, Model model) {
		model.addAttribute("board", service.getBoardService(seq));
		return "detail";
	}
	
	@RequestMapping(value="/board_delete{seq}", method=RequestMethod.GET)
	public String board_delete(@PathVariable int seq, Board board) {
		service.deleteBoardService(seq);
		return "redirect:board_list";
	}
	
	@RequestMapping(value="/board_update", method=RequestMethod.POST)
	public String board_update(@ModelAttribute("boardCommand") @Valid Board board, BindingResult errors) {
		
		if(errors.hasErrors()){
			return "board_detail";
		}
		
		service.updateBoardService(board);
		return "redirect:board_list";
	}
	
	@RequestMapping(value="/board_list_json", method=RequestMethod.GET)
	public String board_list_json() {
		return "list_json";
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
