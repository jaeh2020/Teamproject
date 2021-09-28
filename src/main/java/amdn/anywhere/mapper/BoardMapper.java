package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.BoardCate;
import amdn.anywhere.domain.Member;
import amdn.anywhere.domain.Statement;

@Mapper
public interface BoardMapper {
	
	
	 //게시물 정보 가져오기
	 public Board getBoardInfoByCode(String BoardNum);
	 
	 //상태코드 가져오기
	 public Statement getboardStatement(String boardStatementCode);
	 
	 //게시판 카테고리 코드 가져오기
	 public BoardCate getBoardCateCode(String boardCateCode);
	
	 //회원목록 조회 ajax
	 public List<Member> getMemberList();
	
	 //아이디 조회
	 public Member getMemberRead(String memId);
	
	 //게시판 등록
	 public int boardWrite(Board board);
	
	 //게시판 번호 증가코드
	 public String getNewBoardNum();
	
	 //게시판 목록
	 public List<Board> getBoardList();
	 
	 
}
