package amdn.anywhere.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.groovy.classgen.ReturnAdder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Member;
import amdn.anywhere.service.MemberService;


@Controller
public class MemberController {

	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	//로그인
	@PostMapping("/member/login")
	public String login( @RequestParam(name = "memberId", required = false) String memberId
						,@RequestParam(name = "memberPw", required = false) String memberPw
						, HttpSession session
						, RedirectAttributes redirecAttr) {
		//1 회원이 있다
		if(memberId != null && !"".equals(memberId) &&
			memberPw != null && !"".equals(memberPw)) {
			Member member = memberService.getMemberInfoById(memberId);
			if(member != null) {
				if(memberPw.equals(member.getMemberPw())) {
					session.setAttribute("SID", memberId);
					session.setAttribute("SLEVEL", member.getLevelCode());
					session.setAttribute("SNAME", member.getMemberName());
					return "redirect:/";
				}
			}
		}
		//2 회원이 없다면 result -> 등록된 정보가 없습니다.
		redirecAttr.addAttribute("result", "등록된 정보가 없습니다.");
		return "redirect:/member/login";
	};
	
	
	@GetMapping("/member/login")
	public String login( Model model
						,@RequestParam(name = "result", required = false) String result) {
		
		if(result != null) model.addAttribute("result",result);
		
		model.addAttribute("title", "로그인");
		model.addAttribute("location", "로그인");
		return "/member/login";
	}
	//가입완료
	@GetMapping("/member/addMember04")
	public String addMember04(Model model) {
		
		model.addAttribute("title", "회원가입  〉 가입완료");
		model.addAttribute("location", "회원가입  〉 가입완료");
		return "/member/addMember04";
	}
	//추가정보입력
	@GetMapping("/member/addMember03")
	public String addMember03(Model model) {
		
		List<FoodMainCate> foodMainList = memberService.getFoodMainList();
		
		model.addAttribute("title", "회원가입  〉 추가정보입력");
		model.addAttribute("location", "회원가입  〉 추가정보입력");
		model.addAttribute("foodMainList", foodMainList);
		
		return "/member/addMember03";
	}
	//회원정보입력
	@PostMapping("/member/addMember02")
	public String addMember02(Member member) {
		System.out.println("커맨드 객체 : " + member);
		
		if(member != null) memberService.addMember02(member);
		return "redirect:/member/addMember03";
	}
	
	@GetMapping("/member/addMember02")
	public String addMember02(Model model) {
		
		model.addAttribute("title", "회원가입  〉 정보입력");
		model.addAttribute("location", "회원가입  〉 정보입력");
		return "/member/addMember02";
	}
	//회원유형선택
	@GetMapping("/member/addMember01")
	public String addMember01(Model model) {
		
		model.addAttribute("title", "회원가입  〉 회원유형선택");
		model.addAttribute("location", "회원가입  〉 회원유형선택");
		return "/member/addMember01";
	}
}
