package amdn.anywhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amdn.anywhere.domain.Board;
import amdn.anywhere.mapper.BoardMapper;

@Service
public class BoardService {
	
	
	  private final BoardMapper boardMapper;
	
	  @Autowired
	  public BoardService(BoardMapper boardMapper) { 
		  this.boardMapper = boardMapper; 
		  
	  }
	 
	 public List<Board> getBoardList(){ 
		 List<Board> boardList = boardMapper.getBoardList();
	
	 return boardList; }
	 


}
