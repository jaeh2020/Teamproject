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

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.Review;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Storesearch;
import amdn.anywhere.service.ReviewService;



@Controller
@RequestMapping("/review")
public class ReviewController {

	
	  private final ReviewService reviewService;
	  
	  public ReviewController(ReviewService reviewService) { 
	  
	  		this.reviewService = reviewService; 
	  }
	 
	//리뷰수정처리
	@PostMapping("reviewModify")
	public String reviewModify(Review review
							  ,@RequestParam(name = "storeName" , required = false) String storeName) {
		
		System.out.println("review 수정화면 값" + review);
		
		reviewService.reviewModify(review);
		
		return "redirect:/review/reviewConfirm";
	}
	
	  
	// 리뷰수정
	@GetMapping("reviewModify")
	public String reviewModify(Model model
							   ,@RequestParam(name = "reviewNum" , required = false)String reviewNum
							   ,@RequestParam(name = "storeName" , required = false)String storeName) {
		
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("storeName", storeName);
		
		//리뷰정보가져오기(수정)
		Review review = reviewService.getReviewInfoByCode(reviewNum);
		//해당 매장 이름 가져오기
		Storesearch stroeSearch = reviewService.getReviewStoreName(paramMap);
		
		model.addAttribute("title", "리뷰수정");
		model.addAttribute("review", review);
		model.addAttribute("stroeSearch", stroeSearch);
		
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
