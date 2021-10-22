package amdn.anywhere.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import amdn.anywhere.domain.MemberUser;
import amdn.anywhere.domain.Store;
import amdn.anywhere.service.MainService;
import amdn.anywhere.service.MemberService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	private final MainService mainService;
	private final MemberService memberService;
	
	public SearchController(MainService mainService, MemberService memberService) {
		this.mainService = mainService;
		this.memberService = memberService;
	}
	
	@GetMapping("likeSearch")
	public String likeSearch(Model model
							,HttpSession session
							,@RequestParam(name = "userLikeKey1", required = false) String userLikeKey1
							,@RequestParam(name = "userLikeKey2", required = false) String userLikeKey2
							,@RequestParam(name = "userLikeKey3", required = false) String userLikeKey3) {
		
		
		System.out.println(userLikeKey1 + "<-----------------userLikeKey1");
		
		//세션아이디(로그인되어있는 아이디)
		String userId = (String) session.getAttribute("SID");
		
		//선호도 조회
		MemberUser memberUser = memberService.getMemberUserInfoById(userId);
		
		//선호도1
		List<Store> storeLikeList = mainService.getStoreLikeList(userId);
		//선호도2
		List<Store> storeLikeList2 = mainService.getStoreLikeList2(userId);
		//선호도3
		List<Store> storeLikeList3 = mainService.getStoreLikeList3(userId);
		
		model.addAttribute("storeLikeList3", storeLikeList3);
		model.addAttribute("storeLikeList2", storeLikeList2);
		model.addAttribute("storeLikeList", storeLikeList);
		model.addAttribute("memberUser", memberUser);
		model.addAttribute("title", "회원별 선호도 맞춤 매장");
		model.addAttribute("location", "회원별 선호도 맞춤 매장");
		
		return "/search/likeSearch";
	}
	
	
	
	
	@GetMapping("eventSearch")
	public String eventSearch(Model model) {
		
		
		//List<Store> searchEventList = mainService.getSearchEventList();
		
		model.addAttribute("title", "이벤트중인 매장");
		model.addAttribute("location", "이벤트중인 매장");
		
		return "/search/eventSearch";
	}

}




	