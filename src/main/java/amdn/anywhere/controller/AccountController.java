package amdn.anywhere.controller;

import org.springframework.stereotype.Controller;

import amdn.anywhere.service.SalesService;


@Controller
public class AccountController{
	private SalesService salesService;
	
	public AccountController(SalesService salesService){
		this.salesService = salesService;
	}
	
}

