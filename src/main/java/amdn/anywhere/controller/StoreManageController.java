package amdn.anywhere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import amdn.anywhere.service.SalesService;



@Controller
/* @RequestMapping("/store") */
public class StoreManageController {

	
	@GetMapping("/storeManage")
	public String storeManage() {
		return "/myStore/storeManage";
		
	}
	
}
