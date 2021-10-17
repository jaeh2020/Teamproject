package amdn.anywhere.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/pos")
public class PosController {

	
	@GetMapping("/posOrder")
		public String getaddBookOrder(Model model) {
		
		model.addAttribute("title", "나의매장 주문현황 POS");
		model.addAttribute("location", "나의매장 주문현황 POS");
		
		return "/pos/posOrder";
	}
	
}
