package amdn.anywhere.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Store;
import amdn.anywhere.service.MainService;
import amdn.anywhere.service.StoreService;




@Controller
public class MainController {
	private final MainService mainService;
	private final  StoreService storeService;
	
	public MainController(MainService mainService, StoreService storeService) {
		this.mainService = mainService;
		this.storeService = storeService;
	}
	
	/*
	 * @PostMapping("/") public String
	 * getMainList(@RequestParam(name="mainCateName", required = false) String
	 * mainCateName ,Model model) {
	 * 
	 * Map<String, Object> paramMap = new HashMap<String, Object>();
	 * paramMap.put("mainCateName", mainCateName);
	 * 
	 * 
	 * return "redirect:/"; }
	 */
	
	
	//ajax
	@GetMapping(value="/storeList", produces = "application/json")
	@ResponseBody
	public Store getStoreDetail(
				@RequestParam(name="storeName", required = false) String storeName
	){		
		return mainService.getMainRead(storeName);
	}
	
	
		
	@GetMapping("/")
	public String main(Model model) {
		
		//메뉴 카테고리(대분류) 불러오기
		List<FoodMainCate> mainCate = storeService.getMainCate();
		
		//상점 리스트, 실시간 예약대기 번호 가져오기
		List<Store> mainList = mainService.getMainList();
		
		model.addAttribute("mainCate", mainCate);
		model.addAttribute("title", "main page");
		model.addAttribute("mainList", mainList);

		return "main";
	}
	
	
	
	

}
