package amdn.anywhere.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.Review;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Storesearch;
import amdn.anywhere.mapper.ReviewMapper;



@Service
@Transactional
public class ReviewService {
	
	 private final ReviewMapper reviewMapper;
	 
	  @Autowired 
	  public ReviewService(ReviewMapper reviewMapper) { 
		  this.reviewMapper = reviewMapper;
	 }
	  
	//게시물 조회 수 증가
	public int updateReviewCnt(String reviewNum) {
		return reviewMapper.updateReviewCnt(reviewNum);
	};
	  
	//음식점 이름 가져오기
	public Storesearch getReviewStoreName(Map<String, String> paramMap) {
		return reviewMapper.getReviewStoreName(paramMap);
	};
  
	//각 매장 리뷰 목록 가져오기
	public List<Review> getreviewConfirmList(Map<String, String> paramMap) {
		
		List<Review> getreviewList = reviewMapper.getreviewConfirmList(paramMap);
		
		return getreviewList;
	};
	  
	//관리자 리뷰 상세보기
	public Review getreviewView(String reviewNum) {
		return reviewMapper.getreviewView(reviewNum);
	};
	  
	  
	//총 리뷰 삭제처리
	public int reviewDelete(String reviewNum) {
		return reviewMapper.reviewDelete(reviewNum);
	};  
	  
	//리뷰등록
	public int reviewAdd(Review review) {
		return reviewMapper.reviewAdd(review);
	};
	  
	//예약정보가져오기
	  public Book getBookList(Map<String, String> paramMap) {
		return reviewMapper.getBookList(paramMap);
	};
	  
	// 리뷰번호 자동증가
	public String getNewReviewNum() {
		return reviewMapper.getNewReviewNum();
	};
	    
	//리뷰 등록 상태 코드 가져오기
	public Statement getreviewStatement(String reviewStatementCode) {
		return reviewMapper.getreviewStatement(reviewStatementCode);
	};
		   

	//방문음식점 ,음식이름 가져오기
	public List<Order> getStoreName(Map<String, String> paramMap) {
		
		List<Order> order = reviewMapper.getStoreName(paramMap);
		
		return order;
	};
	
	//총 리뷰 목록
	public List<Review> getreviewList(){
		
		List<Review> reviewList = reviewMapper.getreviewList();
		
		return reviewList;
		
	};

}
