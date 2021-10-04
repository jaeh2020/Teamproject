package amdn.anywhere.controller;

import java.util.Arrays;
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
import amdn.anywhere.domain.QuestionCate;
import amdn.anywhere.domain.RecruitTasterByBiz;
import amdn.anywhere.domain.Store;
import amdn.anywhere.service.TasterService;

@Controller
@RequestMapping("/taster")
public class TasterController {
	
	private TasterService tasterService;

	
	public TasterController(TasterService tasterService) {
		this.tasterService = tasterService;
	}
	@PostMapping("/recruitApplyProcess") public String recruitApplyProcess(RecruitTasterByBiz recruitByBiz) {
		System.out.println(recruitByBiz);
		
		return "redirect:/taster/recruitApply";
	}
	

	/*
	 * @PostMapping("/recruitApplyProcess") public String recruitApplyProcess(
	 * 
	 * @RequestParam(value="selectStore", required = false)String selectStore
	 * ,@RequestParam(value="selectMenu", required = false)String selectMenu
	 * ,@RequestParam(value="noticeTitle", required = false)String noticeTitle
	 * ,@RequestParam(value="surveyTitle", required = false)String surveyTitle
	 * ,@RequestParam(value="ageCheck", required = false)String[] ageCheck
	 * ,@RequestParam(value="recruitNum", required = false)int recruitNum
	 * ,@RequestParam(value="endDate", required = false)String endDate
	 * ,@RequestParam(value="checkSurveyCate", required = false)String[]
	 * checkSurveyCate ,@RequestParam(value="cateCode", required = false)String[]
	 * specialSurveyCate) { List<String> ageCheckList = Arrays.asList(ageCheck);
	 * List<String> cateList = Arrays.asList(checkSurveyCate); List<String>
	 * specialCateList = Arrays.asList(specialSurveyCate);
	 * 
	 * System.out.println(selectStore); System.out.println(selectMenu);
	 * System.out.println(noticeTitle); System.out.println(surveyTitle);
	 * System.out.println(ageCheckList); System.out.println(recruitNum);
	 * System.out.println(endDate); System.out.println(cateList);
	 * System.out.println(specialCateList);
	 * 
	 * 
	 * return "redirect:/taster/recruitApply"; }
	 */
	@GetMapping("/recruitApply")
	public String recruitApply(HttpSession session, Model model) {
		
		//String bizId = (String)session.getAttribute("SID");
		String bizId = "id004";
		
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
