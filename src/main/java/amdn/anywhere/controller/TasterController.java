package amdn.anywhere.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.RecruitTasterByBiz;

import amdn.anywhere.service.TasterService;

@Controller
@RequestMapping("/taster")
public class TasterController {
	
	private TasterService tasterService;

	
	public TasterController(TasterService tasterService) {
		this.tasterService = tasterService;
	}

	
	/* 
	 * 메서드 : 평가단 요청 폼에서 데이터 받기
	 * 보완사항 : 
	 */
	@PostMapping("/recruitApplyProcess") public String recruitApplyProcess(
			RecruitTasterByBiz recruitByBiz
		) {
		System.out.println(recruitByBiz + " ----------------------------01");
		recruitByBiz.setBizId("id004"); // 소상공인아이디 가정
		//1. 모집코드 자동생성 처리
		//2. 상태코드 세팅
		//3. 신청 일시 세팅 (자바 내장 함수 이용)
		// insert 전에 mapper, resultMap 작성.
		//4. insert
		return "redirect:/taster/recruitApply";
	}
	
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
