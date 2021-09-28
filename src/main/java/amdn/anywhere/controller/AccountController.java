package amdn.anywhere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.Store;
import amdn.anywhere.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	
	@GetMapping("/mystore")
	public String mystore() {
		return "/account/mystore";
		
	}
	
	//ajax (내 매장 정보) -- 확인
   @GetMapping(value="/mystoreList", produces = "application/json")
   @ResponseBody
   public List<Store> getMystoreList(@RequestParam(name="storecode", required = false) String storeCode){   
      return accountService.getMystoreList(storeCode);
   }

    // Sales (매출파트)    
	@GetMapping("/addSales")
	public String getaddSales(Model model) {
		model.addAttribute("addSales", "매출 목록");
		return "/account/addSales";
	}
	
	@PostMapping("/addSales")
	public String addSales(Model model) {
		System.out.println("===============================");
		System.out.println("===Dto 만들어서 db에 담긴 sales===");
		System.out.println("===============================");
		
		return "redirect:/account/salesList";
	}
	
	@GetMapping("/salesList")
	public String salesList() {
		return "/account/salesList";		
	}	
	
	// Expense (비용파트)
	
	@GetMapping("/addExpense")
	public String getaddExpense(Model model) {
		model.addAttribute("addExpense", "지출 목록");
		return "/account/addExpense";
	}
	
	@GetMapping("/expenseList")
	public String expenseList() {
		return "/account/expenseList";		
	}
	
	@GetMapping("/addClose")
	public String getaddClose(Model model) {
		model.addAttribute("addClose", "마감 등록");
		return "/account/addClose";
	}
	
	@PostMapping("/addClose")
	public String addClose(Model model) {
		System.out.println("===============================");
		System.out.println("===Dto 만들어서 db에 담긴 close===");
		System.out.println("===============================");
		
		return "redirect:/account/close";
	}
	@GetMapping("/close")
	public String close() {
		return "/account/close";
		
	}
	
}