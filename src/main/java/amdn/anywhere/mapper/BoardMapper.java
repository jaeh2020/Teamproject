package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.BoardReply;
import amdn.anywhere.domain.Member;
import amdn.anywhere.domain.Report;
import amdn.anywhere.domain.Statement;

@Mapper
public interface BoardMapper {
	
	
	
	//신고등록
	public int boardBizReport(Report report);
	
	//신고등록
	public int boardReport(Report report);
	 
	//신고 코드 자동증가
	public String getNewReportNum();
	
	//신고상태코드 가져오기
	public Statement getReportStatement(String reportStatementCode);
	
	//게시글 댓글 삭제
	public int deleteComment(String boardReplyCode);
	
	//게시글 댓글 등록 
	public int addComment(BoardReply boardReply);
	
	//게시글 댓글 자동증가 코드
	public String getNewBoardReplyNum();
	
	//게시물 댓글 목록
	public List<BoardReply> getBoardCommentList(String boardNum);
	
	//게시물 조회 수 증가
	 public int updateBoardCnt(String boardNum); 
	 
	 //게시물 삭제 처리
	 public int boardDelete(String boardNum);
	
	 //게시물 수정 처리
	 public int boardModify(Board board);
	 
	 //게시물 정보 가져오기
	 public Board getBoardInfoByCode(String BoardNum);
	 
	 //상태코드 가져오기
	 public Statement getboardStatement(String boardStatementCode);
	 
	
	 //회원목록 조회 ajax
	 public List<Member> getMemberList();
	
	 //아이디 조회
	 public Member getMemberRead(String memId);
	 
	 //공지사항 등록
	 public int boardNoticeWrite(Board board);
	 
	 //소상공인 게시판 등록
	 public int boardBizWrite(Board board);
	 
	 //소비자 게시판 등록
	 public int boardWrite(Board board);
	
	 //게시판 번호 증가코드
	 public String getNewBoardNum();
	
	 //공지사항 목록
	 public List<Board> getBoardNoticeList();
	 
	 //소상공인 게시판 목록
	 public List<Board> getBoardBizList();
	 
	 //게시판 목록
	 public List<Board> getBoardList();
	 
	 
}
