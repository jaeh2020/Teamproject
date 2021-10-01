package amdn.anywhere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("/member/addMember")
	public String addMember(Model model) {
		
		model.addAttribute("title", "회원가입  〉 회원유형선택");
		model.addAttribute("location", "회원가입  〉 회원유형선택");
		return "/member/addMember";
	}
}
