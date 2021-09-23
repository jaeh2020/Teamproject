package amdn.anywhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Board;
import amdn.anywhere.mapper.BoardMapper;

@Service
@Transactional
public class BoardService {
	
	
	 private final BoardMapper boardMapper;
	 
	  @Autowired 
	  public BoardService(BoardMapper boardMapper) { 
		  this.boardMapper = boardMapper;
	 }
	  
	  
	  public int boardWrite(Board board) {
		  return boardMapper.boardWrite(board);
	  }
	  
	  
	  
	  public List<Board> getBoardList(){
		  List<Board> boardList = boardMapper.getBoardList();
		  
		  return boardList;
	  }
	 


}
