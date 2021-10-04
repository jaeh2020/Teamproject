package amdn.anywhere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Member;
import amdn.anywhere.service.MemberService;


@Controller
public class MemberController {

	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/member/addMember03")
	public String addMember03(Model model) {
		
		List<FoodMainCate> foodMainList = memberService.getFoodMainList();
		
		model.addAttribute("title", "회원가입  〉 추가정보입력");
		model.addAttribute("location", "회원가입  〉 추가정보입력");
		model.addAttribute("foodMainList", foodMainList);
		
		return "/member/addMember03";
	}
	
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

	@GetMapping("/member/addMember01")
	public String addMember01(Model model) {
		
		model.addAttribute("title", "회원가입  〉 회원유형선택");
		model.addAttribute("location", "회원가입  〉 회원유형선택");
		return "/member/addMember01";
	}
}
