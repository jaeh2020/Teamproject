package amdn.anywhere.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.BoardReply;
import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.Report;
import amdn.anywhere.domain.Review;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Storesearch;
import amdn.anywhere.domain.ReviewReply;
import amdn.anywhere.service.ReviewService;



@Controller
@RequestMapping("/review")
public class ReviewController {

	
	  private final ReviewService reviewService;
	  
	  public ReviewController(ReviewService reviewService) { 
	  
	  		this.reviewService = reviewService; 
	  }
	
	//리뷰 댓글 삭제처리
	@GetMapping("/reviewDeleteComment")
	public String reviewDeleteComment(ReviewReply reviewReply
								,@RequestParam(name = "reviewReplyNum" , required = false) String reviewReplyNum
								,@RequestParam(name = "reviewNum" , required = false) String reviewNum
								, HttpSession session) {
		
	
			 //로그인 정보 가져오기
			 String memberId = (String) session.getAttribute("SID");
			 reviewReply.setMemberId(memberId);
		 
			 System.out.println("boardReply 화면 값" + reviewReply);
			
			 reviewService.reviewDeleteComment(reviewReplyNum);
			
			 return "redirect:/review/reviewUserView?reviewNum="+ reviewNum ;
	}
	  
	  
	  //리뷰 댓글 등록
	  @PostMapping("/reviewUserView")
		public String boardView(ReviewReply reviewReply
				, HttpSession session
				, @RequestParam(name = "reviewNum" , required = false) String reviewNum) {
			
			//로그인 정보 가져오기
			String memberId = (String) session.getAttribute("SID");
			reviewReply.setMemberId(memberId);
			
			System.out.println("커맨드 객체 boardReply" + reviewReply);
			
			
			//게시글 댓글 자동증가 생성 후 insert
			if (reviewReply != null) {
				reviewReply.setReviewReplyNum(reviewService.getNewReviewReplyNum());
				reviewService.addReviewComment(reviewReply);
				
			}
			
			return "redirect:/review/reviewUserView?reviewNum=" + reviewNum;
		}  
	
	  
	//게시글 신고 작성처리
	@PostMapping("/reviewReport")
	public String reviewReport(Report report
							 ) {
		
		System.out.println("report" + report);
		
		
		if (report != null) {
			report.setReportCode(reviewService.getNewReportNum());
			reviewService.reviewReport(report);
		}
		
		return "redirect:/";
	}
	  
	  
	//리뷰 신고 작성
	@GetMapping("/reviewReport")
	public String boardReport(Model model
							  ,HttpSession session
							  ,@RequestParam(name = "reportCateCode" , required = false) String reportCateCode
							  ,@RequestParam(name = "reportStatementCode" , required = false) String reportStatementCode
							  ,@RequestParam(name = "reviewNum" , required = false) String reviewNum) {
		
		//신고자 아이디 가져오기
		String reportId = (String)session.getAttribute("SID");
		//게시글 번호 가져오기
		Review review = reviewService.getReviewInfoByCode(reviewNum);
		//신고 상태코드 가져오기
		Statement reportStatement = reviewService.getReportStatement(reportStatementCode);
	
		
		model.addAttribute("title", "리뷰 신고");
		model.addAttribute("reportId", reportId);
		model.addAttribute("review" , review);
		model.addAttribute("reportStatement" , reportStatement);
	
		return "/review/reviewReport";
	}
  
	//소비자 리뷰삭제처리
	@GetMapping("/reviewUserDelete")
	public String reviewUserDelete(Review review
								  ,@RequestParam(name = "reviewNum" , required = false)String reviewNum) {
		
		//삭제처리
		reviewService.reviewUserDelete(reviewNum);
		
		return "redirect:/";
	}  
	  
	 	  
	//리뷰수정처리
	@PostMapping("reviewModify")
	public String reviewModify(Review review
							  ,Storesearch storesearch
							  ,@RequestParam(name = "storeName" , required = false) String storeName) {

		reviewService.reviewModify(review);
		
		return "redirect:/";
	}
	
	  
	// 리뷰수정
	@GetMapping("reviewModify")
	public String reviewModify(Model model
							   ,@RequestParam(name = "reviewNum" , required = false)String reviewNum) {
		
		
		//리뷰정보가져오기(수정)
		Review review = reviewService.getReviewInfoByCode(reviewNum);
		
		model.addAttribute("title", "리뷰수정");
		model.addAttribute("review", review);
		
		return "/review/reviewModify";
	}
	  
	//소비자 리뷰 상세보기
	@GetMapping("/reviewUserView")
	public String reviewUserView(Model model
								,@RequestParam(name = "reviewNum" ,required = false)String reviewNum
								,HttpSession session) {
		
		//현재 로그인 아이디 가져오기
		String memberId = (String)session.getAttribute("SID");
		//리뷰목록가져오기
		Review review = reviewService.getreviewView(reviewNum);
		//조회 수 증가
		Integer reviewCnt = 0;
		reviewCnt = reviewService.updateReviewCnt(reviewNum);
		//리뷰 댓글 목록
		List<ReviewReply> reviewCommentList = reviewService.getReviewCommentList(reviewNum);
		
		model.addAttribute("reviewCommentList", reviewCommentList);
		model.addAttribute("title", "리뷰조회");
		model.addAttribute("review", review);
		model.addAttribute("reviewCnt", reviewCnt);
		model.addAttribute("memberId", memberId);
		return "/review/reviewUserView";
		}
	  
	 	
		//소비자 리뷰 목록
		@GetMapping("/reviewConfirm")
		public String reviewConfirm(Model model
								,@RequestParam(name = "storeName" , required = false)String storeName) {
		
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("storeName", storeName);
		
		
		//각 매장 리뷰목록가져오기
		List<Review> getreviewList = reviewService.getreviewConfirmList(paramMap);
		
		//해당 매장 이름 가져오기
		Storesearch stroeSearch = reviewService.getReviewStoreName(paramMap);
		
		
		model.addAttribute("title", "리뷰조회");
		model.addAttribute("getreviewList", getreviewList);
		model.addAttribute("stroeSearch", stroeSearch);
		
		return "/review/reviewConfirm";
	}
	  
	  
	//운영사 리뷰 상세보기
	@GetMapping("/reviewView")
	public String reviewView(Model model
							,@RequestParam(name = "reviewNum" ,required = false)String reviewNum) {
		
		//리뷰목록가져오기
		Review review = reviewService.getreviewView(reviewNum);
		
		model.addAttribute("title", "리뷰상세보기");
		model.addAttribute("review", review);
		
		return "/review/reviewView";
	}
	  
	//운영사 리뷰 삭제처리
	@GetMapping("/reviewDelete")
	public String reviewDelete(Review review
								,@RequestParam(name = "reviewNum" , required = false)String reviewNum) {
		
		System.out.println("review" + review);
		
		reviewService.reviewDelete(reviewNum);
	
		return "redirect:/review/reviewList";
	}
	  
	  
	//리뷰작성처리
	@PostMapping("/reviewWrite")
	public String reviewWrite(Review review) {
		
		System.out.println("review" + review);
		
		//리뷰글 자동증가 생성 후 insert
		if(review != null) {
			review.setReviewNum(reviewService.getNewReviewNum());
			reviewService.reviewAdd(review);
		}
		
		return  "redirect:/";
	}
	    
	//리뷰작성하기
	@GetMapping("/reviewWrite")
	public String reviewWrite(Model model
							 ,HttpSession session
							 ,@RequestParam(name = "bookCode" , required = false) String bookCode
							 ,@RequestParam(name = "reviewStatementCode" , required = false) String reviewStatementCode) {
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("bookCode", bookCode);
		
		//리뷰작성 아이디 가져오기
		String memberId = (String)session.getAttribute("SID");
		//음식점 이름 가져오기
		List<Order> order = reviewService.getStoreName(paramMap);
		//리뷰상태코드가져오기
		Statement statement = reviewService.getreviewStatement(reviewStatementCode);
		//예약정보가져오기
		Book bookList = reviewService.getBookList(paramMap);
		
		
		model.addAttribute("title", "리뷰작성");
		model.addAttribute("location", "리뷰작성");
		model.addAttribute("memberId", memberId);
		model.addAttribute("order", order);
		model.addAttribute("statement", statement);
		model.addAttribute("bookList", bookList);
		
		return "/review/reviewWrite";
	}
	
	//운영사 리뷰 목록
	@GetMapping("/reviewList")
	public String reviewList(Model model) {
		
		List<Review> reviewList = reviewService.getreviewList();
		
		model.addAttribute("title", "총 리뷰목록");
		model.addAttribute("location", "총 리뷰목록");
		model.addAttribute("reviewList", reviewList);
		
		return "/review/reviewList";
	}
}
