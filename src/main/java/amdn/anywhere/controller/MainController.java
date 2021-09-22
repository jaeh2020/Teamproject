package amdn.anywhere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class MainController {
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("title", "1팀 화이팅");
		return "main";
	}
	
	@GetMapping("/addBookMember")
	public String getaddBookMember(Model model) {
		model.addAttribute("addBookMember", "예약정보입력");
		return "/book/addBookMember";
	}
	
	@PostMapping("/addBookMember")
		public String addBookMember(Model model) {
			System.out.println("=============================");
			System.out.println("dto만들어서 db에 담긴정보 나와야함");
			System.out.println("=============================");

		return "redirect:/book/addBookOrder";
	}
	
	@GetMapping("/addBookOrder")
	public String getaddBookOrder(Model model) {
		model.addAttribute("addBookOrder", "주문정보입력");
		return "/book/addBookOrder";
	}
	
}
