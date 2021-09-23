package amdn.anywhere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import amdn.anywhere.service.SalesService;



@Controller
/* @RequestMapping("/sales") */
public class SalesController {

	
	@GetMapping("/addSales")
	public String getaddSales(Model model) {
		model.addAttribute("addSales", "매출 목록");
		return "sales/addSales";
	}
	
	@PostMapping("/addSales")
	public String addSales(Model model) {
		System.out.println("===============================");
		System.out.println("===Dto 만들어서 db에 담긴 sales===");
		System.out.println("===============================");
		
		return "redirect:/sales/salesList";
	}
	@GetMapping("/salesList")
	public String salesList() {
		return "/sales/salesList";
		
	}
	
}
