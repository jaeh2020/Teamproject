package amdn.anywhere.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.Store;
import amdn.anywhere.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	private static final Logger log = LoggerFactory.getLogger(AccountController.class);

	
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
   public List<Store> getMystoreList(@RequestParam(name="storeCode", required = false) String storeCode){
	  log.debug("storeCode : {}",storeCode);
      return accountService.getMystoreList(storeCode);
   }

   //ajax (매장 리스트 조회)
   @RequestMapping(value="/storeSearch", method= RequestMethod.POST, produces = "application/json")
   @ResponseBody
   public List<Store> getstoreSearch( @RequestParam(value="storeSearchKey", required = false) String storeSearchKey
		   ,@RequestParam(value="searchStartDate", required = false) String searchStartDate
		   ,@RequestParam(value="searchEndDate", required = false) String searchEndDate){
	   
	   log.info("레벨테스트신청리스트 검색 옵션 : {}", storeSearchKey);
	   log.info("레벨테스트신청리스트 검색 옵션 : {}", searchStartDate);
	   log.info("레벨테스트신청리스트 검색 옵션 : {}", searchEndDate);
	   
	   List<Store> storeSearch = accountService.getstoreSearch(storeSearchKey, searchStartDate, searchEndDate);
	   
	   return storeSearch;
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