package amdn.anywhere.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import amdn.anywhere.domain.Expense;
import amdn.anywhere.service.SalesService;



@Controller
/* @RequestMapping("/Expense") */
public class ExpenseController {

	
	@GetMapping("/addExpense")
	public String getaddSales(Model model) {
		model.addAttribute("addExpense", "지출 목록");
		return "expense/addExpense";
	}
	
	@PostMapping("/addExpense")
	public String addExpense(Model model) {
		System.out.println("===============================");
		System.out.println("===Dto 만들어서 db에 담긴 Expense===");
		System.out.println("===============================");
		
		List<Expense> list = new ArrayList<Expense>();
		
		Expense ex = null;
		ex = new Expense();	
		ex.setStoreCode(null);
		list.add(ex);
		ex = new Expense();		
		list.add(ex);
		ex = new Expense();		
		list.add(ex);
		
		System.out.println(list+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<???A?A");
		
		model.addAttribute("expenseList", list);
		
		return "redirect:/expense/expenseList";
	}
	@GetMapping("/expenseList")
	public String expenseList() {
		return "/expense/expenseList";
		
	}
	
}
