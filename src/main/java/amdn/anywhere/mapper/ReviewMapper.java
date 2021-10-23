package amdn.anywhere.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Review;
import amdn.anywhere.domain.Statement;




@Mapper
public interface ReviewMapper {
	
	//총 리뷰 삭제처리
	public int reviewDelete(String reviewNum);
	
	//리뷰등록
	public int reviewAdd(Review review);
	
	//예약정보가져오기
	public Book getBookList(Map<String, String> paramMap);
	
	// 리뷰번호 자동증가
	public String getNewReviewNum();
	
	//리뷰 등록 상태 코드 가져오기
	public Statement getreviewStatement(String reviewStatementCode);
	
	//방문음식점 ,음식이름 가져오기
	public List<Book> getStoreName(Map<String, String> paramMap);
	
	//총 리뷰 목록
	public List<Review> getreviewList();
	
	
}
