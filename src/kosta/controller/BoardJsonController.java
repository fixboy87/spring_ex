package kosta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.model.Board;
import kosta.service.BoardService;

@RestController
public class BoardJsonController {
	private BoardService service;
	
	@RequestMapping("board_listing_json")
	public List<Board> board_listing_json() {
		List<Board> list = service.listBoardService();
		System.out.println(list);
		return list;
	}
	
	@Autowired
	public void setService(BoardService service) {
		this.service = service;
	}
}
