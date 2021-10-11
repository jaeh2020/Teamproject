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
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.Store;
import amdn.anywhere.domain.Table;
import amdn.anywhere.service.StoreService;


@Controller
@RequestMapping("/store")
public class StoreController {
	

	private final StoreService storeService;
	
	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}
	
	
	//나의 매장 테이블등록 처리
	@PostMapping("/myStoreManage/addMyTable")
	public String addMyTable(Table table
							,@RequestParam(name="storeCode", required = false) String storeCode
							,HttpSession session) {
		
		//세션아이디(로그인되어있는 아이디)
		String bizId = (String) session.getAttribute("SID");
		
		int newTableNum = storeService.getNewTableNum(storeCode);
		String newStoreTableCode = storeService.getNewStoreTableCode();
		
		//테이블번호, 테이블코드 자동증가 생성 후 insert
		if(table != null) {
			table.setBizId(bizId);
			table.setStoreTableCode(newStoreTableCode);
			table.setTableNum(newTableNum);
			storeService.addMyTable(table);
		}
		
		return "redirect:/store/myStoreManage/myTableManage";
	}
	
	//나의 매장 테이블등록 화면
	@GetMapping("/myStoreManage/addMyTable")
	public String addMyTable(Model model
							,HttpSession session) {
		
		
		//세션아이디(로그인되어있는 아이디)
		String bizId = (String) session.getAttribute("SID");
		
		//매장정보 가져오기
		Map<String, Object> paramMap = storeService.getMyStoreList(bizId);

		model.addAttribute("storeList", paramMap.get("storeList"));

		
		return "/store/myStoreManage/addMyTable";
	}
	
	//나의 매장 테이블 삭제
	@GetMapping("/myStoreManage/deleteMyTable")
	public String deleteMyTable(Table table
								,@RequestParam(name="storeTableCode", required = false) String storeTableCode) {
		
		storeService.deleteMyTable(storeTableCode);
		
		return "redirect:/store/myStoreManage/myTableManage";
	}
	
	
	//나의 매장 테이블 리스트 조회
	@GetMapping("/myStoreManage/myTableManage")
	public String myTableManage(Model model
							   ,HttpSession session) {
		
		//세션아이디(로그인되어있는 아이디)
		String bizId = (String) session.getAttribute("SID");
		
		//나의 매장 테이블 리스트 조회
		Map<String, Object> paramMap = storeService.getMyTableList(bizId);
				
		model.addAttribute("tableList", paramMap.get("tableList"));
		model.addAttribute("title", "나의 매장 테이블 관리");
		model.addAttribute("location", "나의 매장 테이블 관리");
		
		return "/store/myStoreManage/myTableManage";
	}
	

	//나의매장 메뉴삭제 처리
	@GetMapping("/myStoreManage/deleteMyMenu")
	public String deleteMyMenu(Menu menu
							  ,@RequestParam(name="menuCode", required = false) String menuCode){
		
		storeService.deleteMyMenu(menuCode);
		
		return "redirect:/store/myStoreManage/myMenuManage";				  
	}
							  

	//나의매장 메뉴수정 처리
	@PostMapping("/myStoreManage/modifyMyMenu")
	public String modifyMyMenu(Menu menu) {
		
		//메뉴수정처리
		if(menu != null) {
			storeService.modifyMyMenu(menu);
		}
		return "redirect:/store/myStoreManage/myMenuManage";
	}
	
	
	//나의매장 메뉴 수정화면
	@GetMapping("/myStoreManage/modifyMyMenu")
	public String modifyMyMenu(@RequestParam(name="menuCode", required = false) String menuCode
							  ,@RequestParam(name="storeCode", required = false) String storeCode
							  ,Model model) {
		
		//메뉴 수정화면
		Menu menu = storeService.getMyMenuInfoByMenuCode(menuCode);
		
		//메뉴 대분류명 가져오기
		Map<String, Object> paramMap = storeService.getMyMainCateOnly(storeCode);

		model.addAttribute("mainCateOnly", paramMap.get("mainCateOnly"));
		model.addAttribute("mainCateOnly2", paramMap.get("mainCateOnly2"));
		model.addAttribute("menu", menu);
		model.addAttribute("title", "나의 메뉴 수정");
		model.addAttribute("location", "나의 메뉴 수정");
		
		return "/store/myStoreManage/modifyMyMenu";
	}
	
	
	//메뉴대분류 수정처리
	@PostMapping("/myStoreManage/modifyMainCate")
	public String modifyMainCate(Store store) {
		
		//메뉴대분류 수정처리
		if(store != null) {
			storeService.modifyMainCate(store);
		}
		
		return "redirect:/store/myStoreManage/myMenuManage";
	}
	
	
	
	//메뉴대분류 수정화면
	@GetMapping("/myStoreManage/modifyMainCate")
	public String modifyMainCate(Model model
								,HttpSession session) {
		
		//세션아이디(로그인되어있는 아이디)
		String bizId = (String) session.getAttribute("SID");
		
		//메뉴 대분류명 가져오기
		Map<String, Object> paramMap = storeService.getMyStoreList(bizId);;

		model.addAttribute("storeList", paramMap.get("storeList"));
		model.addAttribute("storeList2", paramMap.get("storeList2"));
		
		//메뉴 대분류 조회
		List<FoodMainCate> mainCate = storeService.getMainCate();
		
		model.addAttribute("storeList", paramMap.get("storeList"));
		model.addAttribute("storeList2", paramMap.get("storeList2"));
		model.addAttribute("bizId", bizId);
		model.addAttribute("mainCate", mainCate);
		model.addAttribute("title", "대분류 수정");
		model.addAttribute("location", "대분류 수정");
		
		return "/store/myStoreManage/modifyMainCate";
	}
	
	
	//메뉴등록 처리
	@PostMapping("/myStoreManage/addMyMenu")
	public String addMyMenu(Menu menu) {
		
		String newMenuCode = storeService.getNewMenuCode();
		
		//메뉴코드 자동증가 생성 후 menu테이블에 insert
		if(menu != null) {
			menu.setMenuCode(newMenuCode);
			storeService.addMyMenu(menu);
		}
		return "redirect:/store/myStoreManage/myMenuManage";
	}
	
	
	//메뉴등록 화면
	@GetMapping("/myStoreManage/addMyMenu")
	public String addMyMenu(Model model
						   ,HttpSession session
						   ,@RequestParam(name = "storeCode" , required = false) String storeCode) {
		
		//세션아이디(로그인되어있는 아이디)
		String bizId = (String) session.getAttribute("SID");
		
		//매장코드 가져오기
		Store store = storeService.getStoreInfoByCode(storeCode);
		
		//메뉴 대분류명 가져오기
		Map<String, Object> paramMap = storeService.getMyStoreList(bizId);;

		model.addAttribute("storeList", paramMap.get("storeList"));
		model.addAttribute("storeList2", paramMap.get("storeList2"));
		model.addAttribute("store", store);
		model.addAttribute("bizId", bizId);
		model.addAttribute("title", "메뉴 등록");
		model.addAttribute("location", "메뉴 등록");
		
		return "/store/myStoreManage/addMyMenu";
	}
		
	
	//나의 매장메뉴 리스트 조회
	@GetMapping("/myStoreManage/myMenuManage")
	public String storeManage(Model model
							 ,HttpSession session) {
		
		//세션아이디(로그인되어있는 아이디)
		String bizId = (String) session.getAttribute("SID");
		
		//나의 매장 메뉴 리스트 조회
		Map<String, Object> paramMap = storeService.getMyMenuList(bizId);
	
		model.addAttribute("storeList", paramMap.get("storeList"));
		model.addAttribute("storeList2", paramMap.get("storeList2"));
		model.addAttribute("myMenuList", paramMap.get("myMenuList"));
		model.addAttribute("title", "나의 메뉴 관리");
		model.addAttribute("location", "나의 메뉴 관리");
		
		
		return "/store/myStoreManage/myMenuManage";
	}
	
	
	
	//나의매장정보 수정처리
	@PostMapping("/myStoreManage/myStoreModify")
	public String myStoreModify(Store store) {
		
		//나의매장정보 수정처리
		if(store != null) {
			storeService.modifyMyStore(store);
		}
		
		return "redirect:/store/myStoreManage/myStoreInfo";
	}
	
	
	
	//나의매장정보 수정화면
	@GetMapping("/myStoreManage/myStoreModify")
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
		
		return "/store/myStoreManage/myStoreModify";
	}
	
	
	
	
	//나의매장정보 리스트 선택하여 조회 ajax
	@GetMapping(value="/myStoreManage/myStoreInfo", produces = "application/json")
	@ResponseBody
		public Store getStoreDetail(
					@RequestParam(name="storeCode", required = false) String storeCode
		){		
			return storeService.getStoreRead(storeCode);
		}
	
	//나의매장정보리스트 조회
	@GetMapping("/myStoreManage/myStoreInfo")
	public String myStoreManage(Model model
							   ,HttpSession session) {
		
		//세션아이디(로그인되어있는 아이디)
		String bizId = (String) session.getAttribute("SID");
		
		//나의 매장 정보 리스트 조회
		Map<String, Object> paramMap = storeService.getMyStoreInfo(bizId);
		
		model.addAttribute("storeInfo", paramMap.get("storeInfo"));
		model.addAttribute("title", "나의 매장 관리");
		model.addAttribute("location", "나의 매장 관리");
		
		return "/store/myStoreManage/myStoreInfo";
	}
	
	
	//관리자용 매장리스트 조회
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
