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
	
}
