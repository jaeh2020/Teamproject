package amdn.anywhere.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import amdn.anywhere.domain.Order;
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

	
	@GetMapping("/posOrder")
		public String getPosOrder(Model model
								,@RequestParam(name = "storeCode" , required = false) String storeCode) {
		
		//나의매장 주문pos list조회
		List<Order> myPosOrderList = posService.getPosOrderList(storeCode);
		
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
