package amdn.anywhere.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.Menu;
import amdn.anywhere.service.TasterService;

@Controller
@RequestMapping("/taster")
public class TasterController {
	
	private TasterService tasterService;

	
	public TasterController(TasterService tasterService) {
		this.tasterService = tasterService;
	}
	@PostMapping("/recruitApplyProcess")
	public String recruitApplyProcess(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^recruitApplyProcess TasterController.java");
	
	
		String[] ageCheckList = request.getParameterValues("ageCheck");
		for(int i = 0; i < ageCheckList.length ; i++) {
			System.out.println(ageCheckList[i]);
		}
		
		return "redirect:/taster/recruitApply";
	}
	
	@GetMapping("/recruitApply")
	public String recruitApply(HttpSession session, Model model) {
		
		String bizId = (String)session.getAttribute("SID");
		
		Map<String, Object> paramMap =tasterService.getListForRecruit(bizId);
		
		model.addAttribute("qCateList", paramMap.get("qCateList"));
		model.addAttribute("storeList", paramMap.get("storeList"));
		model.addAttribute("title", "평가단 모집 신청");
		model.addAttribute("location2", "모집 신청");
		
		return "/taster/recruitApply";
	}
	
	//ajax
	@GetMapping(value="/menuList", produces = "application/json")
	@ResponseBody
	public List<Menu> menuList(@RequestParam(value="storeCode", required = false)String storeCode) {
		List<Menu> menuList = tasterService.getMenuList(storeCode);

		return menuList;
	}
}
