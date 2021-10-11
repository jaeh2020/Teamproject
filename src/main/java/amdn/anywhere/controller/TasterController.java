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
import amdn.anywhere.domain.Taster;
import amdn.anywhere.service.QuestionService;
import amdn.anywhere.service.TasterService;

@Controller
@RequestMapping("/taster")
public class TasterController {
	
	private TasterService tasterService;
	private QuestionService questionService;

	
	public TasterController(TasterService tasterService, QuestionService questionService) {
		this.tasterService = tasterService;
		this.questionService = questionService;
	}
	//평가단 신청처리
	@PostMapping("/applyTaster")
	public String applyTaster( HttpSession session,
			@RequestParam(value="recruitBCode", required = false) String recruitBCode) {
		Taster taster = new Taster();
		taster.setRecruitBCode(recruitBCode);
		taster.setUserId("id010"); //소비자아이디 가정
		tasterService.addTaster(taster);
		return "redirect:/taster/tasterList";
	}
	//평가단 관리페이지 이동
	@GetMapping("/tasterList")
	public String tasterList(Model model) {
		List<Taster> tasterList = tasterService.getTasterList(null);
		model.addAttribute("title", "평가단 관리페이지");
		model.addAttribute("location", "평가단 관리");
		model.addAttribute("tasterList", tasterList);
		return "/taster/tasterList";
	}
	//모집 상세페이지 이동
	@GetMapping("/recruitDetail")
	public String recruitDetail(
			@RequestParam(value = "recruitCode", required = false)String recruitCode , Model model) {
		//조회수 업데이트
		tasterService.updateViewCounts(recruitCode);
		//모집코드로 공고내용 가져오기
		RecruitTasterByBiz recruitInfo = tasterService.getRecruitBBList(recruitCode).get(0);
		model.addAttribute("title", "평가단 모집 공고");
		model.addAttribute("location1URL", "/taster/recruitNotice");
		model.addAttribute("location1", "평가단 모집공고");
		model.addAttribute("location2", "상세페이지");
		model.addAttribute("recruitInfo", recruitInfo);
		
		return "/taster/recruitDetail";
	}
	//모집공고 페이지 이동
	@GetMapping("/recruitNotice")
	public String recruitNotice(Model model) {
		List<RecruitTasterByBiz> recruitList = tasterService.getRecruitBBList(null);
		model.addAttribute("recruitList", recruitList);
		model.addAttribute("title", "평가단 모집 공고");
		model.addAttribute("location", "모집 공고");
		return "/taster/recruitNotice";
	}
	//상태변경 처리
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
		
		//승인처리시 공고 및 설문조사 생성.
		if(state.equals("승인")) {
			//1	설문조사
			System.out.println("설문조사 생성");	
			questionService.addSurvey(recruitCode);
		}
		return "redirect:/taster/recruitList";
	}
	
	@GetMapping("/recruitList")
	public String recruitList(Model model) {
		
		List<RecruitTasterByBiz> recruitList = tasterService.getRecruitBBList(null);
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
