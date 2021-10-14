package amdn.anywhere.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/enter")
public class EnterController {
	

	/*
	 * private final EnterService enterService;
	 * 
	 * public EnterController(EnterService enterService) { this.enterService =
	 * enterService; }
	 */
	
	//모든매장 매장리스트 조회
	@GetMapping("/addStore")
		public String addStore(Model model) {
		
		model.addAttribute("title", "입점등록신청");
		model.addAttribute("location", "입점등록신청");
		
		return "/enter/addStore";
		}
	
}
