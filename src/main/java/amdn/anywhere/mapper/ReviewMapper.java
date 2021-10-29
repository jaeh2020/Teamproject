package amdn.anywhere.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.Report;
import amdn.anywhere.domain.Review;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Storesearch;
import amdn.anywhere.domain.ReviewReply;




@Mapper
public interface ReviewMapper {
	
	//리뷰댓글삭제
	public int reviewDeleteComment(String reviewReplyNum);
	
	//리뷰 댓글 등록
	public int addReviewComment(ReviewReply reviewReply);
	
	//리뷰 댓글 자동증가
	public String getNewReviewReplyNum();
	
	//리뷰 댓글 목록
	public List<ReviewReply> getReviewCommentList(String reviewNum);
	
	//신고등록
	public int reviewReport(Report report);
		 
	//신고 코드 자동증가
	public String getNewReportNum();

	//신고상태코드 가져오기
	public Statement getReportStatement(String reportStatementCode);
	
	//리뷰삭제처리
	public int reviewUserDelete(String reviewNum);
	
	//리뷰수정처리
	public int reviewModify(Review review);
	
	//리뷰정보가져오기(수정)
	public Review getReviewInfoByCode(String reviewNum);
	
	//게시물 조회 수 증가
	public int updateReviewCnt(String reviewNum);
	
	//음식점 이름 가져오기
	public Storesearch getReviewStoreName(Map<String, String> paramMap);
	
	//각 매장 리뷰 목록
	public List<Review> getreviewConfirmList(Map<String, String> paramMap);
	
	//관리자 리뷰 상세보기
	public Review getreviewView(String reviewNum);
	
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
	public List<Order> getStoreName(Map<String, String> paramMap);
	
	//총 리뷰 목록
	public List<Review> getreviewList();
	
	
}
