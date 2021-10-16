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
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.MemberBiz;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Store;
import amdn.anywhere.domain.StoreCancel;
import amdn.anywhere.service.StoreService;

@Controller
@RequestMapping("/enter")
public class EnterController {
	
	private final StoreService storeService;
	
	public EnterController(StoreService storeService) {
		this.storeService = storeService;
	}
	
	
	
	//취소신청 현황 리스트 에서 승인거절 버튼 누를시 update와 delete
	@GetMapping("/cancelStoreChangeState")
	public String cancelStoreChangeState(@RequestParam(value="storeCancelCode", required = false) String storeCancelCode
										,@RequestParam(value="state",required = false) String state
										,@RequestParam(value="storeCode",required = false) String storeCode
										,HttpSession session) {
		
		
		String id = (String) session.getAttribute("SID");
		
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("storeCode", storeCode);
		paramMap.put("storeCancelCode", storeCancelCode);
		paramMap.put("state", state);
		paramMap.put("cancelConfirmId", id);
		
		storeService.modifyStoreCancel(paramMap);
		
		//승인 완료 후 delete
		if(state.equals("승인")) {
			storeService.deleteStore(storeCode);
		}
		return "redirect:/enter/cancelStoreManage";
	}
	
	
	//취소신청 현황리스트 조회
	@GetMapping("/cancelStoreManage")
	public String cancelStoreManage(Model model
									,HttpSession session) {
		
		//세션아이디(로그인되어있는 아이디) 
		String memberId = (String) session.getAttribute("SID");
		
		
		//취소신청 현황리스트 조회
		List<StoreCancel> storeCancelList = storeService.getStoreCancelList();
		
		
		model.addAttribute("memberId", memberId);
		model.addAttribute("storeCancelList", storeCancelList);
		model.addAttribute("title", "입점취소 관리");
		model.addAttribute("location", "입점취소 관리");		
		
		return "/enter/cancelStoreManage";
	}
	

	//입점취소신청 전송
	@PostMapping("/cancelStore")
	public String cancelStore(StoreCancel storeCancel) {
		
		//취소코드 자동증가
		String newCancelCode = storeService.getNewCancelCode();
		
		//취소코드 자동증가 후 입점취소신청 전송
		if(storeCancel != null) {
			storeCancel.setStoreCancelCode(newCancelCode);
			storeService.cancelStore(storeCancel);
		}
		return "redirect:/enter/cancelMyStore";
	}
	
	
	//입점취소신청 등록 화면
	@GetMapping("/cancelStore")
	public String cancelStore(Model model
							 ,HttpSession session){
		
		//세션아이디(로그인되어있는 아이디) 
		String bizId = (String) session.getAttribute("SID");
		
		//취소요청 상태코드 가져오기
		Statement statement = storeService.getCancelStatement();
		
		//나의 매장 정보 리스트 조회
		Map<String, Object> paramMap = storeService.getMyStoreInfo(bizId);
		
				
		model.addAttribute("storeInfo", paramMap.get("storeInfo"));	
		model.addAttribute("statement", statement);
		model.addAttribute("bizId", bizId);
		model.addAttribute("title", "입점등록취소");
		model.addAttribute("location", "입점등록취소");		
		
		return "/enter/cancelStore";
	}
	
	
	//입점취소현황 화면
	@GetMapping("cancelMyStore")
	public String cancelMyStore(Model model
								,HttpSession session) {
		
		//세션아이디(로그인되어있는 아이디) 
		String bizId = (String) session.getAttribute("SID");
		
		//나의입점취소현황  조회
		Map<String, Object> paramMap = storeService.getmyCancelStoreList(bizId);

		model.addAttribute("myCancelStoreList", paramMap.get("myCancelStoreList"));
		model.addAttribute("title", "입점등록취소현황");
		model.addAttribute("location", "입점등록취소현황");
		
		return "/enter/cancelMyStore";
	}
	
	
	//입점등록처리
	@PostMapping("/addStore")
	public String addStore(Store store) {
		
		//매장코드 자동증가
		String newStoreCode = storeService.getNewStoreCode();
		
		//매장코드 자동증가 생성 후 storeinfo테이블에 insert
			if(store != null) {
				store.setStoreCode(newStoreCode);
				storeService.addMyStore(store);
			}
			
		return "redirect:/store/myStoreManage/myStoreInfo";
	}

	//나의매장 리스트 선택하여 조회 ajax
		@GetMapping(value="/cancelStoreDetail", produces = "application/json")
		@ResponseBody 
		public StoreCancel getStoreCancleDetail(@RequestParam(name="storeCode", required = false) String storeCode) {
			
			return storeService.getMyCancelList(storeCode);
		}
	
	 
	//입점등록신청 화면
	@GetMapping("/addStore")
	public String addStore(Model model
							  ,HttpSession session) {
		
		//세션아이디(로그인되어있는 아이디) 
		String bizId = (String) session.getAttribute("SID");
		
		//소상공인 코드 조회 
		MemberBiz memberBiz = storeService.getBizCode(bizId);
		
		//메뉴 대분류 전체 조회
		List<FoodMainCate> mainCate = storeService.getMainCate();
		 
		model.addAttribute("mainCate", mainCate);
		model.addAttribute("memberBiz", memberBiz);
		model.addAttribute("bizId", bizId);
		model.addAttribute("title", "입점등록신청");
		model.addAttribute("location", "입점등록신청");
		
		return "/enter/addStore";
	}
	
	
}
