package amdn.anywhere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import amdn.anywhere.domain.BadWords;
import amdn.anywhere.service.BadWordsService;

@Controller
@RequestMapping("/badWords")
public class BadWordsController {
	
	private final BadWordsService badWordsService;
	
	public BadWordsController(BadWordsService badWordsService) {
		this.badWordsService = badWordsService;
	}
	
	
	@GetMapping("/commonBadWords")
	public String commonBadWords(Model model) {
		
		List<BadWords> badWordsList = badWordsService.getBadWordsList();
		
		model.addAttribute("title", "공통금지어목록");
		model.addAttribute("badWordsList", badWordsList);
		
		return "/badWords/commonBadWords";
	}

}
