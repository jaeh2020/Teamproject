package amdn.anywhere.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.BoardCate;
import amdn.anywhere.domain.BoardReply;
import amdn.anywhere.domain.Member;
import amdn.anywhere.domain.Report;
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
	  
	  //소상공인 신고 등록
	  public int boardBizReport(Report report) {
		  return boardMapper.boardReport(report);
	  };
	  
	  //소비자 신고 등록
	  public int boardReport(Report report) {
		  return boardMapper.boardReport(report);
	  };
	  
	  
	  //신고번호 자동증가 코드
	  public String getNewReportNum() {
		  return boardMapper.getNewReportNum();
	  };
	  
	  //신고 상태코드 불러오기
	  public Statement getReportStatement(String reportStatementCode) {
		  return boardMapper.getReportStatement(reportStatementCode);
	  }
	  
	  //게시글 댓글 삭제
	  public int deleteComment(String boardReplyCode) {
		  return boardMapper.deleteComment(boardReplyCode);
		  
	  }
	  
	  //게시글 댓글 등록
	  public int addComment(BoardReply boardReply) {
		  return boardMapper.addComment(boardReply);
	  }
	  
	  //게시글 댓글 자동증가 코드
	  public String getNewBoardReplyNum() {
		  return boardMapper.getNewBoardReplyNum();
	  }
	  
	  
	  //게시판 댓글 목록
	  public List<BoardReply> getBoardCommentList(String boardNum){
		  List<BoardReply> boardCommentList = boardMapper.getBoardCommentList(boardNum);
		  
		  return boardCommentList;
	  }
	  
	  //게시판 조회 수 증가
	
	  public int updateBoardCnt(String boardNum) {
	  
		  return boardMapper.updateBoardCnt(boardNum); 
	  
	  }
	 
	 //댓글 삭제 처리(paramMap)
	  public int commentdel(Map<String, String> paramMap) {
		  return boardMapper.commentdel(paramMap);
	  }
	 
	  
	  
	  //게시판 삭제 처리
	  public int boardDelete(Map<String, String> paramMap) {
		  return boardMapper.boardDelete(paramMap);
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
	  
	  
	  //소상공인 문의 등록
	  public int boardBizQnAWrite(Board board) {
		  return boardMapper.boardBizQnAWrite(board);
	  }
	  
	  //소비자 문의 등록
	  public int boardQnAWrite(Board board) {
		  return boardMapper.boardQnAWrite(board);
	  }
	  
	  //공지사항 등록
	  public int boardNoticeWrite(Board board) {
		  return boardMapper.boardNoticeWrite(board);
	  }
	  
	  //소상공인 게시물 등록
	  public int boardBizWrite(Board board) {
		  return boardMapper.boardBizWrite(board);
	  }
	  
	  //소비자 게시물 등록
	  public int boardWrite(Board board) {
		  return boardMapper.boardWrite(board);
	  }
	  
	  
	  //소상공인 QnA 게시글 목록
	  public List<Board> getBoardBizQnAList(){
		  List<Board> boardBizQnAList = boardMapper.getBoardBizQnAList();
		  
		  return boardBizQnAList;
	  }
	  
	  //소비자 QnA 게시글 목록
	  public List<Board> getBoardQnAList(){
		  List<Board> boardQnAList = boardMapper.getBoardQnAList();
		  
		  return boardQnAList;
	  }
	  
	  //공지사항 게시글 목록
	  public List<Board> getBoardNoticeList(){
		  List<Board> boardNoticeList = boardMapper.getBoardNoticeList();
		  
		  return boardNoticeList;
	  }
	  
	  //소상공인 게시글 목록
	  public List<Board> getBoardBizList(){
		  List<Board> BoardBizList = boardMapper.getBoardBizList();
		  
		  return BoardBizList;
	  }
	  
	  //게시글 목록
	  public List<Board> getBoardList(){
		  List<Board> boardList = boardMapper.getBoardList();
		  
		  return boardList;
	  }
	 


}
