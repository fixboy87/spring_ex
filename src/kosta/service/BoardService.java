package kosta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kosta.model.Board;

@Service
public class BoardService {
	
	public List<Board> listBoardService() {
		List<Board> list = new ArrayList<Board>();
		Board board = new Board(1, "Çã±Õ", "È«±æµ¿Àü", "È«±æµ¿ °¡¶ó»ç´ë", "2018-08-28", 0);
		System.out.println(board);
		
		list.add(board);
		return list;
	}
}
