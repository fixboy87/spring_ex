package kosta.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mapper.BoardMapper;

@Repository
public class BoardDao {
	private SqlSessionTemplate sqlTemplate;

	@Autowired
	public void setSqlTemplate(SqlSessionTemplate sqlTemplate) {
		this.sqlTemplate = sqlTemplate;
	}
	
	public void insertBoard(Board board) {
		sqlTemplate.getMapper(BoardMapper.class).insertBoard(board);
	}
	
	
}
