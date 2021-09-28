package amdn.anywhere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import amdn.anywhere.domain.Store;
import amdn.anywhere.domain.Waiting;
import amdn.anywhere.service.MainService;




@Controller
public class MainController {
	private final MainService mainService;
	
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	
	//ajax
	@GetMapping(value="/storeList", produces = "application/json")
	@ResponseBody
	public Store getStoreList(
				@RequestParam(name="storeName", required = false) String storeName
	){		
		return mainService.getMainRead(storeName);
	}
	
	
		
	@GetMapping("/")
	public String main(Model model) {
		
		//상점 리스트, 실시간 예약대기 번호 가져오기
		List<Store> mainList = mainService.getMainList();
		
		model.addAttribute("title", "main page");
		model.addAttribute("mainList", mainList);

		return "main";
	}
	
	
	
	

}
