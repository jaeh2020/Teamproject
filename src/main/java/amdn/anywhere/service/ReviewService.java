package amdn.anywhere.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.Report;
import amdn.anywhere.domain.Review;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Storesearch;
import amdn.anywhere.domain.ReviewReply;
import amdn.anywhere.mapper.ReviewMapper;



@Service
@Transactional
public class ReviewService {
	
	 private final ReviewMapper reviewMapper;
	 
	  @Autowired 
	  public ReviewService(ReviewMapper reviewMapper) { 
		  this.reviewMapper = reviewMapper;
	 }
	
	//리뷰댓글삭제
	public int reviewDeleteComment(String reviewReplyNum) {
		return reviewMapper.reviewDeleteComment(reviewReplyNum);
	};
	  
	  
	//리뷰 댓글 등록
	public int addReviewComment(ReviewReply reviewReply) {
		return reviewMapper.addReviewComment(reviewReply);
	};
	
	//리뷰 댓글 자동증가
	public String getNewReviewReplyNum() {
		return reviewMapper.getNewReviewNum();
	};
	   
	//리뷰 댓글 목록
	public List<ReviewReply> getReviewCommentList(String reviewNum){
		List<ReviewReply> reviewCommentList = reviewMapper.getReviewCommentList(reviewNum);
		
		return reviewCommentList;
 	};
 
	//소비자 신고 등록
	public int reviewReport(Report report) {
		  return reviewMapper.reviewReport(report);
	};
	  
	  
	//신고번호 자동증가 코드
	public String getNewReportNum() {
		  return reviewMapper.getNewReportNum();
	};  
	   
	//신고 상태코드 불러오기
	public Statement getReportStatement(String reportStatementCode) {
		  return reviewMapper.getReportStatement(reportStatementCode);
	};
	  
	//리뷰삭제처리
	public int reviewUserDelete(String reviewNum) {
		return reviewMapper.reviewUserDelete(reviewNum);
	}; 
 
	//리뷰수정처리
	public int reviewModify(Review review) {
		return reviewMapper.reviewModify(review);
	};
		
	//리뷰정보가져오기(수정)
	public Review getReviewInfoByCode(String reviewNum) {
		return reviewMapper.getReviewInfoByCode(reviewNum);
	};
	   
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
