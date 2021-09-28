package amdn.anywhere.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import amdn.anywhere.service.TasterService;

@Controller
@RequestMapping("/taster")
public class TasterController {
	
	private TasterService tasterService;
	
	public TasterController(TasterService tasterService) {
		this.tasterService = tasterService;
	}
	
	@GetMapping("/recruitApply")
	public String recruitApply(HttpSession session, Model model) {
		
		String bizId = (String)session.getAttribute("SID");
		
		Map<String, Object> paramMap =tasterService.getListForRecruit(bizId);
		
		model.addAttribute("qCateList", paramMap.get("qCateList"));
		model.addAttribute("storeList", paramMap.get("storeList"));
		model.addAttribute("title", "평가단 모집 신청");
		model.addAttribute("location", "모집 신청");
		
		return "/taster/recruitApply";
	}
}
