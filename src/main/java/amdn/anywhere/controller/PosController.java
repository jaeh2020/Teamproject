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
	
	
	//테이블or웨이팅 pos
	@GetMapping("/posTableWait")
	public String posTableWait(Model model
							  ,@RequestParam(name = "storeCode" , required = false) String storeCode) {
		
		//웨이팅현황조회
		Waiting waiting = posService.getPosWaiting(storeCode);
		
		//테이블현황조회
		List<Table> posTableList = posService.getPosTableList(storeCode);
		
		//pos 테이블 상태목록 가져오기
		List<Statement> posStateList = posService.getPosStateList();

		
		
		model.addAttribute("posStateList", posStateList);
		model.addAttribute("posTableList", posTableList);
		model.addAttribute("waiting", waiting);
		model.addAttribute("title", "나의매장 테이블/웨이팅 POS");
		model.addAttribute("location", "나의매장 테이블/웨이팅 POS");
		
		return "pos/posTableWait";
	}
	
	
	
	//테이블번호.상태 변경시 update
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
		
		//order테이블 테이블번호or상태변경
		posService.modifyPosTableState(paramMap);

		return "redirect:/pos/posMain";
	}
	
	
	//주문승인.웨이팅승인 클릭시 상태변경
	@GetMapping("/posOrderChangeState")
	public String posOrderChangeState(@RequestParam(value="bookCode", required = false) String bookCode
									 ,@RequestParam(value="state",required = false) String state
									 ,HttpSession session) {
		
		String id = (String) session.getAttribute("SID");
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("bookCode", bookCode);
		paramMap.put("state", state);
		paramMap.put("orderConfirmId", id);
		
		//order테이블 상태변경
		posService.modifyPosOrderState(paramMap);
		//book테이블 상태변경
		posService.modifyPosBookState(paramMap);
		
		
		return "redirect:/pos/posMain";
	}

	
	@GetMapping("/posOrder")
		public String getPosOrder(Model model
								,@RequestParam(name = "storeCode" , required = false) String storeCode) {
		
		//나의매장 테이블번호 조회
		List<Table> posTableList = posService.getPosTableList(storeCode);
		
		//나의매장 주문pos List조회
		List<Order> myPosOrderList = posService.getPosOrderList(storeCode);
		
		
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
