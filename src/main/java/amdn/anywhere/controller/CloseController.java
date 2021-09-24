package amdn.anywhere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import amdn.anywhere.service.SalesService;



@Controller
/* @RequestMapping("/close") */
public class CloseController {

	
	@GetMapping("/addClose")
	public String getaddClose(Model model) {
		model.addAttribute("addClose", "마감 등록");
		return "close/addClose";
	}
	
	@PostMapping("/addClose")
	public String addClose(Model model) {
		System.out.println("===============================");
		System.out.println("===Dto 만들어서 db에 담긴 close===");
		System.out.println("===============================");
		
		return "redirect:/close/close";
	}
	@GetMapping("/close")
	public String close() {
		return "/close/close";
		
	}
	
}
