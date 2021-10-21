package amdn.anywhere.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import amdn.anywhere.service.ReviewService;



@Controller
@RequestMapping("/review")
public class ReviewController {

	
	  private final ReviewService reviewService;
	  
	  public ReviewController(ReviewService reviewService) { 
	  
	  		this.reviewService = reviewService; 
	  }
	 
	
	@GetMapping("/reviewWrite")
	public String reviewWrite(Model model
							 ,HttpSession session) {
		
		//리뷰작성 아이디 가져오기
		String memberId = (String)session.getAttribute("SID");
		
		model.addAttribute("title", "리뷰작성");
		model.addAttribute("location", "리뷰작성");
		model.addAttribute("memberId", memberId);
		
		return "/review/reviewWrite";
	}
}
