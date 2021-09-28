package amdn.anywhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.BoardCate;
import amdn.anywhere.domain.Member;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.mapper.BoardMapper;

@Service
@Transactional
public class BoardService {
	
	
	 private final BoardMapper boardMapper;
	 
	  @Autowired 
	  public BoardService(BoardMapper boardMapper) { 
		  this.boardMapper = boardMapper;
	 }
	  
	 
	  //게시판 조회 수 증가
	/*
	 * public int updateBoardCnt(int boardViews) {
	 * 
	 * return boardMapper.updateBoardCnt(boardViews); }
	 */
	 
	
	  //게시판 삭제 처리
	  public int boardDelete(String boardNum) {
		  return boardMapper.boardDelete(boardNum);
	  }
	  
	  //게시판 수정 처리
	  public int boardModify(Board board) {
		  return boardMapper.boardModify(board);
	  }
	 
	  
	  //게시판 정보 가져오기
	  public Board getBoardInfoByCode(String boardNum) {
		  return boardMapper.getBoardInfoByCode(boardNum);
	  }
	  
	  
	  //상태코드 불러오기
	  public Statement getboardStatement(String boardStatementCode) {
		  return boardMapper.getboardStatement(boardStatementCode);
	  }
	  
	  //게시판 카테고리 코드 가져오기
	  public BoardCate getBoardCateCode(String boardCateCode) {
		  return boardMapper.getBoardCateCode(boardCateCode);
	  }
	 
	  
	  //회원보기 - ajax처리
	  public List<Member> getMemberList(){ 
			return boardMapper.getMemberList(); 
		}
		
		public Member getMemberRead(String memId){ 
			return boardMapper.getMemberRead(memId); 
		}
		
	  
	  //자동증가 코드 가져오기
	  public String getNewBoardNum() {
		  return boardMapper.getNewBoardNum();
	  }
	  
	  
	  
	  public int boardWrite(Board board) {
		  return boardMapper.boardWrite(board);
	  }
	  
	  
	  
	  public List<Board> getBoardList(){
		  List<Board> boardList = boardMapper.getBoardList();
		  
		  return boardList;
	  }
	 


}
