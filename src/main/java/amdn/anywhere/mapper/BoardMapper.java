package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Board;

@Mapper
public interface BoardMapper {
	
	//게시판 등록
	public int boardWrite(Board board);
	
	//게시판 목록
	 public List<Board> getBoardList();
	 
}
