package amdn.anywhere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import amdn.anywhere.domain.Store;
import amdn.anywhere.service.MainService;



@Controller
public class MainController {
private final MainService mainService;
	
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	
	@GetMapping("/")
	public String main(Model model) {
		List<Store> mainList = mainService.getMainList();

		model.addAttribute("title", "main page");
		model.addAttribute("mainList", mainList);

		return "main";
	}

	

}
