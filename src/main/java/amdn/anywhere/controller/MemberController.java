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
import amdn.anywhere.domain.MemberBiz;
import amdn.anywhere.domain.MemberLogin;
import amdn.anywhere.domain.MemberUser;
import amdn.anywhere.domain.MemberUserLike;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.service.MemberService;


@Controller
public class MemberController {

	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	//회원 전체 로그인 내역 조회
	@GetMapping("/member/loginList")
	public String getLoginList(Model model) {
		List<Member> memberList = memberService.getMemberList();
		
		model.addAttribute("title", "로그인 내역 조회");
		model.addAttribute("location", "로그인 내역 조회");
		model.addAttribute("memberList", memberList);
		
		return "/member/loginList";
	}
	
	//선호도 수정 ajax
	@GetMapping(value="/modifyUserLike", produces = "application/json")
	@ResponseBody
	public String modifyUserLike(@RequestParam(value = "userLikeCode") String userLikeCode
								,@RequestParam(value = "likeId") String likeId
								,@RequestParam(value = "likeArr[]") List<String> likeArr
								,@RequestParam(value = "unlikeArr[]") List<String> unlikeArr
								,MemberUserLike mul) {
		
		mul.setUserLikeCode(userLikeCode);
		mul.setUserLikeKey1(likeArr.get(0));
		mul.setUserLikeKey2(likeArr.get(1));
		mul.setUserLikeKey3(likeArr.get(2));
		mul.setUserUnlikeKey1(unlikeArr.get(0));
		mul.setUserUnlikeKey2(unlikeArr.get(1));
		mul.setUserUnlikeKey3(unlikeArr.get(2));
		System.out.println(mul.getLikeId() + "dfdfsdfff");
		memberService.modifyUserLike(mul);

		return "mul";
	}
	
	@GetMapping("/member/modifyUserLike")
	public String modifyUserLike(@RequestParam(name = "userId", required = false) String userId
								,Model model) {
		System.out.println("userId::::::" + userId);
		
		//선호-비선호 메인카테 불러오기
		List<FoodMainCate> foodMainList = memberService.getFoodMainList();
		
		MemberUser memberUser = memberService.getMemberUserInfoById(userId);
		memberUser.setUserId(userId);
		
		model.addAttribute("title", "MYPAGE  > 추천/비추천 카테고리 수정");
		model.addAttribute("location", "MYPAGE  > 추천/비추천 카테고리 수정");
		model.addAttribute("foodMainList", foodMainList);
		model.addAttribute("memberUser", memberUser);
		
		return "/member/modifyUserLike";
	}
	
	//소비자 회원아이디 클릭시 추천/비추천 보여주는 ajax
	@GetMapping(value = "/likeList", produces = "application/json")
	@ResponseBody
	public MemberUser likList( @RequestParam(value = "userId") String userId){
		System.out.println("userId : " + userId);
		
		MemberUser memberUser = memberService.getMemberUserInfoById(userId);
		memberUser.setUserId(userId);
		System.out.println("memberUser??? : " + memberUser);
		
		return memberUser;
	}
	
	//소상공인 승인 ajax
	@GetMapping(value="/modifyBizConfirm", produces = "application/json")
	@ResponseBody
	public String modifyBizConfirm(	@RequestParam(value = "bizCode") String bizCode
									,@RequestParam(value = "memberId") String memberId
									,@RequestParam(value = "state") String state) {
		
		System.out.println("bizCode : " + bizCode);
		System.out.println("memberId : " + memberId);
		System.out.println("state : " + state);
		
		MemberBiz memberBiz = memberService.getMemberBizInfoByCode(bizCode);
		
		memberBiz.setConfirmId(memberId);
		memberBiz.setBizStatus(state);
		
		memberService.modifyBizConfirm(memberBiz);
		
		System.out.println("memberBiz 수정완료? : " + memberBiz);

		return "memberBiz";
	}
	
	//회원 전체 목록 조회
	@GetMapping("/member/memberUserList")
	public String getMemberUserList(Model model) {
		
		List<MemberUser> memberUserList = memberService.getMemberUserList();
		
		model.addAttribute("title", "소비자 회원 목록");
		model.addAttribute("location", "소비자 회원 목록");
		model.addAttribute("memberUserList", memberUserList);

		
		return "/member/memberUserList";
	}
	
	//회원탈퇴
	@PostMapping("/member/deleteMember")
	public String deleteMember( @RequestParam(name = "memberId", required = false) String memberId
								,@RequestParam(name = "memberPw", required = false) String memberPw
								,RedirectAttributes redirectAttr
								,HttpSession session) {
		
		System.out.println("(removeMember) 화면에서 입력받은값 : memberId : " + memberId + "memberPw : " + memberPw);
		
		String result = memberService.removeMember(memberId, memberPw);
		
		if("회원 탈퇴 실패".equals(result)) {
			redirectAttr.addAttribute("memberId", memberId);
			redirectAttr.addAttribute("result", "회원 비번 불일치");
			
			return "redirect:/member/deleteMember";
		}
		System.out.println("result : " +result);

		session.invalidate();
		
		return "redirect:/";
	};
	
	@GetMapping("/member/deleteMember")
	public String deleteMember( @RequestParam(name = "memberId", required = false) String memberId
								,Model model) {
		
		System.out.println("(removeMember) 화면에서 입력받은값 : memberId : " + memberId);

		model.addAttribute("title", "MYPAGE  > 회원탈퇴");
		model.addAttribute("location", "MYPAGE  > 회원탈퇴");
		return "/member/deleteMember";
	}
	
	//회원 전체 목록 조회
	@GetMapping("/member/memberBizList")
	public String getMemberBizList(Model model) {
		
		List<MemberBiz> memberBizList = memberService.getMemberBizList();
		
		model.addAttribute("title", "소상공인 승인 신청 목록");
		model.addAttribute("location", "소상공인 승인 신청 목록");
		model.addAttribute("memberBizList", memberBizList);

		
		return "member/memberBizList";
	}
	
	//소상공인 가입 승인
	@PostMapping("/member/addBizConfirm")
	public String addBizConfirm(MemberBiz memberBiz) {
		System.out.println("커맨드 객체 memberBiz: " + memberBiz);
		
		if(memberBiz != null) {
			memberBiz.setBizCode(memberService.getMemberBizCode());
			memberService.addBizConfirm(memberBiz);
		}
		
		//승인 신청하면 소상공인마이페이지로 가도록 경로 수정 필요
		return "redirect:/member/myPageBiz?memberId="+memberBiz.getMemberId();
	}
	
	@GetMapping("/member/addBizConfirm")
	public String addBizConfirm(Model model) {
		
		model.addAttribute("title", "소상공인 가입 승인");
		model.addAttribute("location", "소상공인 가입 승인");
		return "/member/addBizConfirm";
	}
	
	//마이페이지 myPageBiz
	@GetMapping("/member/myPageBiz")
	public String myPageBiz(@RequestParam(name = "memberId", required = false) String memberId
							,Member member
							,Model model) {
		
		MemberBiz memberBiz = memberService.getMemberBizInfoById(memberId);
		System.out.println("memberBiz"+memberBiz);
		if(memberBiz == null) {
			return "redirect:/member/addBizConfirm";
		}
		
		model.addAttribute("title", "MYPAGE");
		model.addAttribute("location", "MYPAGE");
		model.addAttribute("memberBiz", memberBiz);
		
		return "/member/myPageBiz";
	}
	
	//마이페이지 myPage
	@GetMapping("/member/myPage")
	public String myPage(@RequestParam(name = "userId", required = false) String userId
						,Model model) {
		
		//소비자회원 추가 정보
		MemberUser memberUser = memberService.getMemberUserInfoById(userId);
		System.out.println("memberUser"+memberUser);
		
		model.addAttribute("title", "MYPAGE");
		model.addAttribute("location", "MYPAGE");
		model.addAttribute("memberUser", memberUser);
		
		return "/member/myPage";
	}
	
	//마이페이지 myInfo
	@PostMapping("/member/myInfo")
	public String modifyMyInfo( @RequestParam(name = "memberId", required = false) String memberId
								,Member member) {
		System.out.println("화면에서 입력 : " + member);
		
		memberService.modifyMyInfo(member);
		
		return "redirect:/member/myInfo?memberId="+member.getMemberId();
	}
	
	@GetMapping("/member/modifyMyInfo")
	public String modifyMyInfo( @RequestParam(name = "memberId", required = false) String memberId
						 		,Model model) {
		
		Member member = memberService.getMemberInfoById(memberId);
		
		System.out.println("member 수정"+ member);
		
		model.addAttribute("title", "마이페이지  > 내정보 수정");
		model.addAttribute("location", "마이페이지  > 내정보 수정");
		model.addAttribute("member", member);
		return "/member/modifyMyInfo";
	}
	
	//마이페이지 myInfo
	@GetMapping("/member/myInfo")
	public String myInfo( @RequestParam(name = "memberId", required = false) String memberId
						 ,Model model) {
		
		Member member = memberService.getMemberInfoById(memberId);
		
		model.addAttribute("title", "마이페이지  > 내정보");
		model.addAttribute("location", "마이페이지  > 내정보");
		model.addAttribute("member", member);
		return "/member/myInfo";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(@RequestParam(name = "memberId", required = false) String memberId
						,MemberLogin memberLogin
						,HttpSession session) {
		
		//로그아웃 시간 업데이트
		memberService.modifyLogout(memberLogin);
		//세션종료
		session.invalidate();
		return "redirect:/";
	}
	
	//로그인
	@PostMapping("/member/login")
	public String login( @RequestParam(name = "memberId", required = false) String memberId
						,@RequestParam(name = "memberPw", required = false) String memberPw
						, HttpSession session
						, RedirectAttributes redirecAttr
						, MemberBiz memberBiz
						, MemberLogin memberLogin) {
		//1 회원이 있다
		if(memberId != null && !"".equals(memberId) &&
			memberPw != null && !"".equals(memberPw)) {
			Member member = memberService.getMemberInfoById(memberId);

			//비즈 로그인 시
			if(member != null && member.getLevelCode().equals("level_biz")) {
				if(memberPw.equals(member.getMemberPw())) {
					session.setAttribute("SID", memberId);
					session.setAttribute("SLEVEL", member.getLevelCode());
					session.setAttribute("SNAME", member.getMemberName());
					
					//로그인내역남기기
					memberLogin.setLoginNum(memberService.getLoginCode());
					memberLogin.setLevelCode(member.getLevelCode());
					memberService.addLogin(memberLogin);					
					System.out.println("memberLogin::::"+memberLogin);
					
					return "redirect:/member/myPageBiz?memberId="+memberBiz.getMemberId();
				}
			}else {
				if(memberPw.equals(member.getMemberPw())) {
					session.setAttribute("SID", memberId);
					session.setAttribute("SLEVEL", member.getLevelCode());
					session.setAttribute("SNAME", member.getMemberName());
					
					//로그인내역남기기
					memberLogin.setLoginNum(memberService.getLoginCode());
					memberLogin.setLevelCode(member.getLevelCode());
					memberService.addLogin(memberLogin);					
					System.out.println("memberLogin::::"+memberLogin);
					
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
		
		//소비자 추가정보 입력
		if(memberUser != null) memberService.addMember03(memberUser);
		//포인트 최초 등록
		
		//메세지 알림 체크 등록
		
		return "redirect:/member/addMember05";
	}
	
	//선호도 선택 ajax
	@GetMapping(value="/userLike", produces = "application/json")
	@ResponseBody
	public String userLike(	@RequestParam(value = "userLikeCode") String userLikeCode
							,@RequestParam(value = "likeId") String likeId
							,@RequestParam(value = "likeArr[]") List<String> likeArr
							,@RequestParam(value = "unlikeArr[]") List<String> unlikeArr
							,MemberUserLike mul) {
		
		mul.setUserLikeCode(userLikeCode);
		mul.setLikeId(likeId);
		mul.setUserLikeKey1(likeArr.get(0));
		mul.setUserLikeKey2(likeArr.get(1));
		mul.setUserLikeKey3(likeArr.get(2));
		mul.setUserUnlikeKey1(unlikeArr.get(0));
		mul.setUserUnlikeKey2(unlikeArr.get(1));
		mul.setUserUnlikeKey3(unlikeArr.get(2));
		
		if(mul != null) {
			mul.setUserLikeCode(memberService.getUserLikeCode());
			memberService.addMemberUserLike(mul);
		}

		return "mul";
	}
	
	@GetMapping("/member/addMember03")
	public String addMember03(Model model) {
		
		//선호-비선호 메인카테 불러오기
		List<FoodMainCate> foodMainList = memberService.getFoodMainList();
		
		//자동증가 코드
		//String uLikeCode = memberService.getUserLikeCode();
		
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
