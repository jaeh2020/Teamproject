package amdn.anywhere.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Member;
import amdn.anywhere.domain.MemberUser;
import amdn.anywhere.domain.MemberUserLike;
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
		
		model.addAttribute("title","로그인");
		model.addAttribute("location","로그인");
		return "/member/login";
	}
	//회원 전체 목록 조회
	@GetMapping("/member/memberList")
	public String getMemberList(Model model) {
		List<Member> memberList = memberService.getMemberList();
		
		model.addAttribute("title", "회원목록조회");
		model.addAttribute("location", "회원목록조회");
		model.addAttribute("memberList", memberList);
		
		return "/member/memberList";
	}
	//가입완료
	@GetMapping("/member/addMember05")
	public String addMember05(Model model) {
		
		model.addAttribute("title", "회원가입  > 가입완료");
		model.addAttribute("location", "회원가입  > 가입완료");
		return "/member/addMember05";
	}
	//소상공인 가입
	@PostMapping("/member/addMember04")
	public String addMember04(Member member) {
		System.out.println("커맨드 객체 : " + member);
		
		if(member != null) memberService.addMember02(member);
		
		return "redirect:/member/addMember05";
	}
	
	@GetMapping("/member/addMember04")
	public String addMember04(Model model) {
		
		model.addAttribute("title", "회원가입  > 정보입력");
		model.addAttribute("location", "회원가입  > 정보입력");
		return "/member/addMember04";
	}
	
	//추가정보입력
	@PostMapping("/member/addMember03")
	public String addMember03(MemberUser memberUser) {
		System.out.println("멤버유저 : " + memberUser);		
		
		if(memberUser != null) memberService.addMember03(memberUser);
		
		return "redirect:/member/addMember04";
	}
	
	//선호도 선택 ajax
	@GetMapping(value="/userLike", produces = "application/json")
	@ResponseBody
	public String userLike(	@RequestParam(value = "userLikeCode") String userLikeCode
							,@RequestParam(value = "memberId") String memberId
							,@RequestParam(value = "likeArr[]") List<String> likeArr
							,@RequestParam(value = "unlikeArr[]") List<String> unlikeArr
							,MemberUserLike mul) {
		/*
		 * String ulikeCode = memberService.getUserLikeCode();
		 * System.out.println("ulikeCodedd"+ulikeCode);
		 */
		
		mul.setUserLikeCode(userLikeCode);
		mul.setMemberId(memberId);
		mul.setUserLikeKey1(likeArr.get(0));
		mul.setUserLikeKey2(likeArr.get(1));
		mul.setUserLikeKey3(likeArr.get(2));
		mul.setUserUnlikeKey1(unlikeArr.get(0));
		mul.setUserUnlikeKey2(unlikeArr.get(1));
		mul.setUserUnlikeKey3(unlikeArr.get(2));
		System.out.println(mul+"mullllllllllll");
		
		if(mul != null) memberService.addMemberUserLike(mul);

		return "mul";
	}
	
	@GetMapping("/member/addMember03")
	public String addMember03(Model model) {
		
		//선호-비선호 메인카테 불러오기
		List<FoodMainCate> foodMainList = memberService.getFoodMainList();
		
		model.addAttribute("title", "회원가입  > 추가정보입력");
		model.addAttribute("location", "회원가입  > 추가정보입력");
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
	
	//id중복체크
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	@ResponseBody
	public int idCheck(@RequestParam("memberId") String memberId) {
		
		Member idCheck = memberService.idCheck(memberId);
		System.out.println("memberId체크" + memberId);
		System.out.println("id체크" + idCheck);
		
		int result = 0;
		if(idCheck != null) {
			result = 1;
		}
		return result;
	}

	@GetMapping("/member/addMember02")
	public String addMember02(Model model) {
		
		model.addAttribute("title", "회원가입  > 정보입력");
		model.addAttribute("location", "회원가입  > 정보입력");
		return "/member/addMember02";
	}
	
	//회원유형선택
	@GetMapping("/member/addMember01")
	public String addMember01(Model model) {
		
		model.addAttribute("title", "회원가입  > 회원유형선택");
		model.addAttribute("location", "회원가입  > 회원유형선택");
		return "/member/addMember01";
	}
}
