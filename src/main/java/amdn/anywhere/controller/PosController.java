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

import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.Standby;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Table;
import amdn.anywhere.domain.Waiting;
import amdn.anywhere.service.PosService;
import amdn.anywhere.service.StoreService;




@Controller
@RequestMapping("/pos")
public class PosController {
	
	private final StoreService storeService;
	private final PosService posService;
	
	public PosController(StoreService storeService
						,PosService posService) {
		
		this.storeService = storeService;
		this.posService = posService;
	}
	
	

	//테이블상태 변경시 update
	@GetMapping("/posTableUpdate")
	public String posTableUpdate(@RequestParam(value="state",required = false) String state
								,@RequestParam(value="storeTableCode",required = false) String storeTableCode
								,@RequestParam(value="tableStateName",required = false) String tableStateName
								,@RequestParam(value="storeCode",required = false) String storeCode) {
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("state", state);
		paramMap.put("storeTableCode", storeTableCode);
		paramMap.put("tableStateName", tableStateName);
		paramMap.put("storeCode", storeCode);
		
		
		//table 상태변경 update
		posService.modifyPosTable(paramMap);
		//waiting 사용중클릭하면 사용가능테이블 -1   사용중테이블+1
		//		    사용가능클릭하면 사용가능테이블 +1  사용중테이블-1
		posService.modifyWaitingNum(paramMap);
		
		
		return "redirect:/pos/posTableWait?storeCode=" + storeCode;
	}
	
	
	
	
	
	//입장완료 버튼 클릭시 update
	@GetMapping("posWaitChangeState")
	public String posWaitChangeState(@RequestParam(value="bookCode", required = false) String bookCode
									,@RequestParam(value="storeCode", required = false) String storeCode
									,@RequestParam(value="state", required = false) String state) {
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("bookCode", bookCode);
		paramMap.put("storeCode", storeCode);
		paramMap.put("state", state);
		
		//standby테이블 상태=주문완료, 완료일시 update
		posService.modifyPosStanbyState(paramMap);
		//book테이블 상태=주문완료
		posService.modifyPosBookState(paramMap);
		//order테이블 상태=주문완료
		posService.modifyPosOrderState(paramMap);
		//waiting테이블 대기인원-1
		posService.modifyWaitingNum(paramMap);
		
		return "redirect:/pos/posMain";
	}
	
	
	//테이블or웨이팅 pos
	@GetMapping("/posTableWait")
	public String posTableWait(Model model
							  ,@RequestParam(name = "storeCode" , required = false) String storeCode) {
		
		//웨이팅소비자목록조회-standby
		List<Standby> standbyList = posService.getPosStandby(storeCode);
		
		//웨이팅현황조회
		Waiting waiting = posService.getPosWaiting(storeCode);
		
		//테이블현황조회
		List<Table> posTableList = posService.getPosTableList(storeCode);
		
		//pos 테이블 상태목록 가져오기
		List<Statement> posStateList = posService.getPosStateList();
		
		
		
		model.addAttribute("posStateList", posStateList);
		model.addAttribute("posTableList", posTableList);
		model.addAttribute("standbyList", standbyList);
		model.addAttribute("waiting", waiting);
		model.addAttribute("title", "나의매장 테이블/웨이팅 POS");
		model.addAttribute("location", "나의매장 테이블/웨이팅 POS");
		
		return "pos/posTableWait";
	}
	
	
	
	
	//테이블번호 변경시 update
	@GetMapping("/posTableChangeState")
	public String posTableChangeState(@RequestParam(value="bookCode", required = false) String bookCode
									 ,@RequestParam(value="state",required = false) String state
									 ,@RequestParam(value="storeTableCode",required = false) String storeTableCode
									 ,@RequestParam(value="tableStateCode",required = false) String tableStateCode
									 ) {
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("bookCode", bookCode);
		paramMap.put("state", state);
		paramMap.put("storeTableCode", storeTableCode);
		paramMap.put("tableStateCode", tableStateCode);
		
		
			//order테이블 테이블번호 update
			posService.modifyPosTableState(paramMap);
		

		return "redirect:/pos/posMain";
	}
	
	
	//주문승인.웨이팅승인 클릭시 상태변경
	@GetMapping("/posOrderChangeState")
	public String posOrderChangeState(@RequestParam(value="bookCode", required = false) String bookCode
									 ,@RequestParam(value="state",required = false) String state
									 ,@RequestParam(value="storeCode",required = false) String storeCode
									 ,@RequestParam(value="userId",required = false) String userId
									 ,HttpSession session
									 ,Standby standby) {
		
		String id = (String) session.getAttribute("SID");
		
		//standby코드 자동증가 생성
		String newBookStandbyCode = posService.getNewBookStandbyCode();
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userId", userId);
		paramMap.put("bookCode", bookCode);
		paramMap.put("state", state);
		paramMap.put("orderConfirmId", id);
		paramMap.put("storeCode", storeCode);
		paramMap.put("bookStandbyCode", newBookStandbyCode);
		
		//order테이블 상태변경
		posService.modifyPosOrderState(paramMap);
		//book테이블 상태변경
		posService.modifyPosBookState(paramMap);
		
		if(state.equals("웨이팅승인")) {
			//standby테이블 insert
			posService.addPosStandby(paramMap);
			//waiting테이블 입장대기인원 update
			posService.modifyWaitingNum(paramMap);
		}
		
		
		return "redirect:/pos/posMain";
	}

	
	@GetMapping("/posOrder")
		public String getPosOrder(Model model
								,@RequestParam(name = "storeCode" , required = false) String storeCode
								,@RequestParam(name = "dateBefore", required = false) String dateBefore
							  	,@RequestParam(name = "dateAfter", required = false) String dateAfter) {
		
		//나의매장 테이블번호 조회
		List<Table> posTableList = posService.getPosTableList(storeCode);
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("dateBefore", dateBefore);
		paramMap.put("dateAfter", dateAfter);
		paramMap.put("storeCode", storeCode);
		
		//나의매장 주문pos List조회
		List<Order> myPosOrderList = posService.getPosOrderList(paramMap);
		
		
		model.addAttribute("posTableList", posTableList);
		model.addAttribute("myPosOrderList", myPosOrderList);
		model.addAttribute("title", "나의매장 주문 POS");
		model.addAttribute("location", "나의매장 주문 POS");
		
		return "/pos/posOrder";
	}
	
	
	@GetMapping("/posMain")
	public String getPosMain(Model model
			 				,HttpSession session) {
		
		
		//세션아이디(로그인되어있는 아이디)
		String bizId = (String) session.getAttribute("SID");
				
		//나의 매장 정보 리스트 조회
		Map<String, Object> paramMap = storeService.getMyStoreInfo(bizId);
				
		model.addAttribute("storeInfo", paramMap.get("storeInfo"));
		model.addAttribute("title", "나의매장 POS");
		model.addAttribute("location", "나의매장 POS");
		
		return "/pos/posMain";
	}
	
}
