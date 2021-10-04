package amdn.anywhere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import amdn.anywhere.domain.Member;
import amdn.anywhere.service.MemberService;


@Controller
public class MemberController {


	@PostMapping("/member/addMember02")
	public String addMember02(Member member) {
		System.out.println("커맨드 객체 : " + member);
		
		return "redirect:/member/addMember03";
	}
	
	@GetMapping("/member/addMember02")
	public String addMember02(Model model) {
		
		model.addAttribute("title", "회원가입  〉 회원유형선택");
		model.addAttribute("location", "회원가입  〉 회원유형선택");
		return "/member/addMember02";
	}

	@GetMapping("/member/addMember01")
	public String addMember01(Model model) {
		
		model.addAttribute("title", "회원가입  〉 회원유형선택");
		model.addAttribute("location", "회원가입  〉 회원유형선택");
		return "/member/addMember01";
	}
}
