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

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Store;
import amdn.anywhere.service.MenuService;
import amdn.anywhere.service.StoreService;


@Controller
@RequestMapping("/store")
public class StoreController {
	

	private final StoreService storeService;
	private MenuService menuService;
	
	public StoreController(StoreService storeService, MenuService menuService) {
		this.storeService = storeService;
		this.menuService = menuService;
	}
	
	
	@GetMapping("/myStoremanage/addMyMenu")
	public String addMyMenu(Model model
						   ,HttpSession session) {
		
		//세션아이디(로그인되어있는 아이디)
		String bizId = (String) session.getAttribute("SID");
		
		//메뉴 대분류 가져오기
		List<FoodMainCate> foodMainCateList = menuService.getFoodMainCateList();
		
		//메뉴카테고리 가져오기 (메인/사이드)
		
		model.addAttribute("bizId", bizId);
		model.addAttribute("foodMainCateList", foodMainCateList);
		model.addAttribute("title", "메뉴 등록");
		model.addAttribute("location", "메뉴 등록");
		
		return "/store/myStoremanage/addMyMenu";
	}
		
	
	
	@GetMapping("/myStoremanage/myMenuManage")
	public String storeManage(Model model
							 ,HttpSession session) {
		
	
		//세션아이디(로그인되어있는 아이디)
		String bizId = (String) session.getAttribute("SID");
		
		//나의 매장 메뉴 리스트 조회
		Map<String, Object> paramMap = menuService.getMyMenuList(bizId);
	
		model.addAttribute("myMenuList", paramMap.get("myMenuList"));
		model.addAttribute("title", "나의 메뉴 관리");
		model.addAttribute("location", "나의 메뉴 관리");
		
		
		return "/store/myStoremanage/myMenuManage";
	}
	
	
	
	
	@PostMapping("/myStoremanage/myStoreModify")
	public String myStoreModify(Store store) {
		
		//나의매장정보 수정처리
		if(store != null) {
			storeService.modifyMyStore(store);
		}
		
		return "redirect:/store/myStoremanage/myStoreInfo";
	}
	

	@GetMapping("/myStoremanage/myStoreModify")
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
		
		return "/store/myStoremanage/myStoreModify";
	}
	
	
	@GetMapping("/myStoremanage/myStoreInfo")
	public String myStoreManage(Model model
							   ,HttpSession session) {
		

		//세션아이디(로그인되어있는 아이디)
		String bizId = (String) session.getAttribute("SID");
		
		//나의 매장 정보 리스트 조회
		Map<String, Object> paramMap = storeService.getMyStoreList(bizId);
		
		model.addAttribute("storeList", paramMap.get("storeList"));
		model.addAttribute("title", "나의 매장 관리");
		model.addAttribute("location", "나의 매장 관리");
		
		return "/store/myStoremanage/myStoreInfo";
	}
	
	
	@GetMapping("/storeManage")
		public String storeManage(Model model) {
		
		//매장리스트 조회
		List<Store> storeList = storeService.getStoreList();


		model.addAttribute("title", "매장관리");
		model.addAttribute("location", "매장관리");
		model.addAttribute("storeList", storeList);
		
		return "/store/storeManage";
		}
	
}
