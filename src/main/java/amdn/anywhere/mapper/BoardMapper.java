package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.BoardCate;

@Mapper
public interface BoardMapper {
	
	//게시판 등록
	public int boardWrite(Board board);
	
	//게시판 번호 증가코드
	public String getNewBoardNum();
	
	//게시판 목록
	 public List<Board> getBoardList();
	 
	 //게시판 카테고리 코드 가져오기
	 public BoardCate getBoardCateCode(String boardCateCode);
	 
}
