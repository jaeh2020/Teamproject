package amdn.anywhere.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.MemberUser;
import amdn.anywhere.domain.SearchKeyword;
import amdn.anywhere.domain.Store;
import amdn.anywhere.service.MainService;
import amdn.anywhere.service.MemberService;
import amdn.anywhere.service.StoreService;



@Controller
public class MainController {
	private final MainService mainService;
	private final  StoreService storeService;
	private final  MemberService memberService;
	
	public MainController(MainService mainService, StoreService storeService, MemberService memberService) {
		this.mainService = mainService;
		this.storeService = storeService;
		this.memberService = memberService;
	}
	
	
	//ajax
	@GetMapping(value="/storeList", produces = "application/json")
	@ResponseBody
	public Store getStoreDetail(
				@RequestParam(name="storeName", required = false) String storeName
	){		
		return mainService.getMainRead(storeName);
	}
	
	
		
	@GetMapping("/")
	public String main(Model model
					  ,@RequestParam(name="placeInput", required = false) String placeInput
					  ,@RequestParam(name="placeAddress", required = false) String placeAddress
					  ,@RequestParam(name="mainCateCode", required = false) String mainCateCode
					  ,@RequestParam(name="searchKey", required = false) String searchKey
					) {
		
		

		
		//실시간검색현황 조회
		SearchKeyword searchKeyword = mainService.getSearchKeyword();
		
		//메뉴 카테고리(대분류) 불러오기
		List<FoodMainCate> mainCate = storeService.getMainCate();
		
		//검색어코드 자동증가
		String newSearchCode = mainService.getNewSearchCode();
		
		//상점 리스트, 실시간 예약대기 번호 가져오기
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("placeInput", placeInput);
		paramMap.put("mainCateCode", mainCateCode);
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchCode", newSearchCode);
		
		List<Store> mainList = mainService.getMainList(paramMap);
		
		//검색어 토탈 쌓기
		if(searchKey != null) {
			mainService.addSearchTotal(paramMap);
		}
		
		model.addAttribute("searchKeyword", searchKeyword);
		model.addAttribute("mainCate", mainCate);
		model.addAttribute("title", "AMDN, 아무데나");
		model.addAttribute("mainList", mainList);
		model.addAttribute("placeAddress", placeAddress);		

		return "main";
	}
	
	
	
	

}
