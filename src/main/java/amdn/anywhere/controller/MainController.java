package amdn.anywhere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("title", "1팀 화이팅");
		return "main";
	}
	
}
