package amdn.anywhere.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import amdn.anywhere.domain.Store;
import amdn.anywhere.service.StoreService;


@Controller
@RequestMapping("/store")
public class StoreController {
	

	private final StoreService storeService;
	
	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}
	
	
	@PostMapping("/myStoreModify")
	public String myStoreModify(Store store) {
		
		//나의매장정보 수정처리
		if(store != null) {
			storeService.modifyMyStore(store);
		}
		
		return "redirect:myStoreManage";
	}
	

	@GetMapping("/myStoreModify")
	public String myStoreModify(Model model
								,HttpSession session
								,@RequestParam(name = "storeCode" , required = false) String storeCode) {
		
		//수정처리위한 매장코드 가져오기
		Store store = storeService.getStoreInfoByCode(storeCode);
		
		//세션아이디(로그인되어있는 아이디)
		String bizId = (String) session.getAttribute("SID");
		
		//나의 매장 정보 리스트 조회
		Map<String, Object> paramMap = storeService.getMyStoreList(bizId);
		
		model.addAttribute("foodmainList", paramMap.get("foodmainList"));
		model.addAttribute("storeList", paramMap.get("storeList"));
		model.addAttribute("store", store);
		model.addAttribute("title", "나의 매장 관리");
		model.addAttribute("location", "나의 매장 관리");
		
		return "/store/myStoreModify";
	}
	
	
	@GetMapping("/myStoreManage")
	public String myStoreManage(Model model
							   ,HttpSession session) {
		

		//세션아이디(로그인되어있는 아이디)
		String bizId = (String) session.getAttribute("SID");
		
		//나의 매장 정보 리스트 조회
		Map<String, Object> paramMap = storeService.getMyStoreList(bizId);
		
		model.addAttribute("storeList", paramMap.get("storeList"));
		model.addAttribute("title", "나의 매장 관리");
		model.addAttribute("location", "나의 매장 관리");
		
		return "/store/myStoreManage";
	}
	
	
	@GetMapping("/storeManage")
		public String storeManage(Model model) {
		
		List<Store> storeList = storeService.getStoreList();


		model.addAttribute("title", "매장관리");
		model.addAttribute("location", "매장관리");
		model.addAttribute("storeList", storeList);
		
		return "/store/storeManage";
		}
	
}
