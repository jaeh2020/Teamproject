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

import amdn.anywhere.domain.Member;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.RecruitTasterByBiz;
import amdn.anywhere.domain.Taster;
import amdn.anywhere.domain.TasterCancel;
import amdn.anywhere.service.MemberService;
import amdn.anywhere.service.QuestionService;
import amdn.anywhere.service.StoreService;
import amdn.anywhere.service.TasterService;

@Controller
@RequestMapping("/taster")
public class TasterController {
	
	private TasterService tasterService;
	private QuestionService questionService;
	private MemberService memberService;
	
	public TasterController(TasterService tasterService, QuestionService questionService, MemberService memberService) {

		this.tasterService = tasterService;
		this.questionService = questionService;
		this.memberService = memberService;
	}
	
	//평가단 신청시 취소 횟수 확인하는 ajax
	@GetMapping(value="/checkCancelTimes", produces = "application/json")
	@ResponseBody
	public String checkCancelTimes(HttpSession session) {
		String result = "";
		int cancleTimes= tasterService.checkCancelTimes((String)session.getAttribute("SID"));
		
		if(cancleTimes >= 3)result = "F";
					   else result = "T";
		System.out.println(result);
		return result;
	}
	//평가단 - 취소하기
	@GetMapping("/cancelTaster")
	public String cancelTaster(HttpSession session, @RequestParam(value="recruitCode", required = false) String recruitCode) {
		session.getAttribute("SID");
		//취소테이블에 추가
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", session.getAttribute("SID"));
		paramMap.put("recruitBCode", recruitCode);
		tasterService.cancelTaster(paramMap);
		// 평가단 상태 업데이트
		paramMap.put("state", "cancel");
		tasterService.updateTaster(paramMap);
		return "redirect:/taster/myApplyForTaster";
	}
	
	//평가단 - 내 신청현황(소비자)
	@GetMapping("/myApplyForTaster")
	public String myApplyForTaster(Model model, HttpSession session) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", session.getAttribute("SID"));
		List<Taster> applyInfo = tasterService.getTasterList(paramMap);
		model.addAttribute("title", "내 신청 현황");
		model.addAttribute("location", "내 신청 현황");
		model.addAttribute("applyInfo", applyInfo);
		return "/taster/myApplyForTaster";
	}
	//평가단 모집 현황(소상공인)
	@GetMapping("/myRecruitList")
	public String myRecruitList(Model model, HttpSession session) {
		String id = (String)session.getAttribute("SID");
		List<RecruitTasterByBiz> recruitList = tasterService.getRecruitBBList(null, id);

		model.addAttribute("title", "모집 신청 현황");
		model.addAttribute("location", "모집 신청 현황");
		model.addAttribute("recruitList", recruitList);
		
		return "/taster/myRecruitList";
	}
	
	//평가단 신청 버튼 클릭시 ajax 로 나이체크하기
	@GetMapping(value="/ageCheck", produces = "application/json")
	@ResponseBody
	public int ageCheck(HttpSession session) {
		int age = 0;
		if(session != null) {
			String id = (String)session.getAttribute("SID");
			Member member = memberService.getMemberInfoById(id);
			String memberBirth= member.getMemberBirth();
		 age = tasterService.getAgeFromBirth(memberBirth);				
		}
		return age;
	}
	
	//평가단 신청처리
	@PostMapping("/applyTaster")
	public String applyTaster( HttpSession session,
			@RequestParam(value="recruitBCode", required = false) String recruitBCode) {
		String id = (String) session.getAttribute("SID");
		Taster taster = new Taster();
		taster.setRecruitBCode(recruitBCode);
		taster.setUserId(id); 
		tasterService.addTaster(taster);
		
		//현재 모집인원수 증가
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("nowNum", "Y");
		paramMap.put("recruitBCode", recruitBCode);
		tasterService.updateRecruitBBiz(paramMap);

		
		return "redirect:/taster/tasterList";
	}
	//평가단 관리페이지 이동
	@GetMapping("/tasterList")
	public String tasterList(Model model) {
		List<Taster> tasterList = tasterService.getTasterList(null);
		List<TasterCancel> cancelList = tasterService.getTasterCancelList(null);
		model.addAttribute("title", "평가단 관리페이지");
		model.addAttribute("location", "평가단 관리");
		model.addAttribute("tasterList", tasterList);
		model.addAttribute("cancelList", cancelList);
		return "/taster/tasterList";
	}
	//모집 상세페이지 이동
	@GetMapping("/recruitDetail")
	public String recruitDetail(@RequestParam(value = "recruitCode", required = false)String recruitBCode
								, Model model, HttpSession session) {
		//조회수 업데이트
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("view", "Y");
		paramMap.put("recruitBCode", recruitBCode);		
		tasterService.updateRecruitBBiz(paramMap);
		//모집코드로 공고내용 가져오기
		RecruitTasterByBiz recruitInfo = tasterService.getRecruitBBList(recruitBCode, null).get(0);
		
		//세션아이디가 이미 신청자일 경우 신청하기 버튼 대신 알림 문구 보이기
		paramMap.clear();
		paramMap.put("recruitBCode", recruitBCode);
		paramMap.put("userId", session.getAttribute("SID"));
		
		List<Taster> tasterList = tasterService.getTasterList(paramMap);
		if(tasterList.isEmpty()==false)	{
			for(Taster taster : tasterList) {
				if(taster.getState().equals("state_taster_cancel"))model.addAttribute("apply", "n");
				else model.addAttribute("apply", "y");
			}
		}   else model.addAttribute("apply", "n");
		
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
		List<RecruitTasterByBiz> recruitList = tasterService.getRecruitBBList(null, null);
		model.addAttribute("recruitList", recruitList);
		model.addAttribute("title", "평가단 모집 공고");
		model.addAttribute("location", "모집 공고");
		return "/taster/recruitNotice";
	}
	//상태변경 처리
	@GetMapping("/changeState")
	public String changeState(
			@RequestParam(value="recruitCode",required = false) String recruitBCode
			,@RequestParam(value="state",required = false) String state
			,HttpSession session
			){
	
		String id = (String) session.getAttribute("SID");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("recruitBCode", recruitBCode);
		paramMap.put("state", state);
		paramMap.put("adminId", id);
		
		tasterService.updateRecruitBBiz(paramMap);
		
		//승인처리시 공고 및 설문조사 생성.
		if(state.equals("승인")) {
			//1	설문조사 생성
			questionService.addSurvey(recruitBCode);
		}
		return "redirect:/taster/recruitList";
	}
	
	@GetMapping("/recruitList")
	public String recruitList(Model model) {
		
		List<RecruitTasterByBiz> recruitList = tasterService.getRecruitBBList(null, null);

		model.addAttribute("title", "평가단 모집 관리");
		model.addAttribute("location", "모집 관리");
		model.addAttribute("recruitList", recruitList);
		
		
		return "/taster/recruitList";
	}
	/* 
	 * 메서드 : 평가단 요청 폼에서 데이터 받기
	 * 보완사항 : 
	 */
	@PostMapping("/recruitApplyProcess") 
	public String recruitApplyProcess(
			HttpSession session
			,RecruitTasterByBiz recruitByBiz
		) {
		String id = (String) session.getAttribute("SID");
		recruitByBiz.setBizId(id); 
		
		//모집 추가 처리
		tasterService.addRecruit(recruitByBiz);
		return "redirect:/taster/recruitList";
	}
	
	@GetMapping("/applyRecruit")
	public String applyRecruit(HttpSession session, Model model) {
		
		String bizId = (String)session.getAttribute("SID");
		
		Map<String, Object> paramMap =tasterService.getListForRecruit(bizId);
		
		model.addAttribute("qCateList", paramMap.get("qCateList"));
		model.addAttribute("storeList", paramMap.get("storeList"));
		model.addAttribute("title", "평가단 모집하기");
		model.addAttribute("location", "평가단 모집하기");
		
		return "/taster/applyRecruit";
	}
	
	//ajax
	@GetMapping(value="/menuList", produces = "application/json")
	@ResponseBody
	public List<Menu> menuList(@RequestParam(value="storeCode", required = false)String storeCode) {
		List<Menu> menuList = tasterService.getMenuList(storeCode);

		return menuList;
	}
}
