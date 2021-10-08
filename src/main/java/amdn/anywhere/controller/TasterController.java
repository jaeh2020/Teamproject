package amdn.anywhere.controller;

import java.util.HashMap;
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
	//상태변경시 처리
	@GetMapping("/changeState")
	public String changeState(
			@RequestParam(value="recruitCode",required = false) String recruitCode
			,@RequestParam(value="state",required = false) String state
			,HttpSession session
			){
		System.out.println(recruitCode);
		System.out.println(state);		
		String adminId = "id001"; //세션에서 가져와야함.
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("recruitCode", recruitCode);
		paramMap.put("state", state);
		paramMap.put("adminId", adminId);
		
		tasterService.modifyState(paramMap);
		
		return "redirect:/taster/recruitList";
	}
	
	@GetMapping("/recruitList")
	public String recruitList(Model model) {
		
		List<RecruitTasterByBiz> recruitList = tasterService.getRecruitBBList();
		System.out.println(recruitList);
		model.addAttribute("title", "평가단 모집 목록");
		model.addAttribute("location", "모집 목록");
		model.addAttribute("recruitList", recruitList);
		
		
		return "/taster/recruitList";
	}
	/* 
	 * 메서드 : 평가단 요청 폼에서 데이터 받기
	 * 보완사항 : 
	 */
	@PostMapping("/recruitApplyProcess") 
	public String recruitApplyProcess(
			RecruitTasterByBiz recruitByBiz
		) {
		System.out.println(recruitByBiz + " ----------------------------01");
		recruitByBiz.setBizId("id004"); // 소상공인아이디 가정
		
		//모집 추가 처리
		tasterService.addRecruit(recruitByBiz);
		return "/taster/recruitList";
	}
	
	@GetMapping("/recruitApply")
	public String recruitApply(HttpSession session, Model model) {
		
		//String bizId = (String)session.getAttribute("SID");
		String bizId = "id004";
		
		Map<String, Object> paramMap =tasterService.getListForRecruit(bizId);
		
		model.addAttribute("qCateList", paramMap.get("qCateList"));
		model.addAttribute("storeList", paramMap.get("storeList"));
		model.addAttribute("title", "평가단 모집 신청");
		model.addAttribute("location", "모집 신청");
		
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
