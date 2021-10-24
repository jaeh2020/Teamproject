package amdn.anywhere.service;

import java.util.List;

import org.springframework.stereotype.Service;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Member;
import amdn.anywhere.domain.MemberBiz;
import amdn.anywhere.domain.MemberLogin;
import amdn.anywhere.domain.MemberUser;
import amdn.anywhere.domain.MemberUserLike;
import amdn.anywhere.domain.Point;
import amdn.anywhere.mapper.MemberMapper;
import amdn.anywhere.mapper.MessageMapper;
import amdn.anywhere.mapper.PointMapper;

@Service
public class MemberService {

	private final MemberMapper memberMapper;
	
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	//로그아웃 내역 업데이트
	public int modifyLogout(MemberLogin memberLogin) {
		return memberMapper.modifyLogout(memberLogin);
	}
	
	//로그인내역 입력
	public int addLogin(MemberLogin memberLogin) {
		return memberMapper.addLogin(memberLogin);
	}
	
	//로그인 내역 코드 자동증가
	public String getLoginCode() {
		return memberMapper.getLoginCode();
	}
	
	//전체 회원 탈퇴
	public String removeMember(String memberId, String memberPw) {
		String result = "회원 탈퇴 실패";
		
		//입력받은 비밀번호 일치?
		Member member = memberMapper.getMemberInfoById(memberId);
		if(member != null) {
			if(memberPw.equals(member.getMemberPw())) {
				
				//회원권한
				String memberLevel = member.getLevelCode();
				
				//소비자
				if(memberLevel.equals("level_user")) {
					memberMapper.removeMemberUser(memberId);
				}
				
				memberMapper.removeMember(memberId);
				
				result ="회원 탈퇴 성공!!!!!!!!!!!!";
			}
		}
		return result;
	}
	
	//소비자 추천/비추천 수정
	public int modifyUserLike(MemberUserLike memberUserLike) {
		return memberMapper.modifyUserLike(memberUserLike);
	}
	
	//소상공인 승인 상태, 승인자 아이디 변경
	public int modifyBizConfirm(MemberBiz memberBiz) {
		return memberMapper.modifyBizConfirm(memberBiz);
	}
	
	//소상공인 승인 신청 개인조회(id)
	public MemberBiz getMemberBizInfoById(String memberId) {
		return memberMapper.getMemberBizInfoById(memberId);
	}
	
	//소상공인 승인 신청 개인조회(code)
	public MemberBiz getMemberBizInfoByCode(String bizCode) {
		return memberMapper.getMemberBizInfoByCode(bizCode);
	}
	
	//소상공인 승인 목록
	public List<MemberBiz> getMemberBizList(){
		List<MemberBiz> memberBizList = memberMapper.getMemberBizList();
		return memberBizList;
	}
	
	//소상공인 자동증가 코드
	public String getMemberBizCode() {
		return memberMapper.getMemberBizCode();
	}
	
	//소상공인 승인신청 등록
	public int addBizConfirm(MemberBiz memberBiz) {
		return memberMapper.addBizConfirm(memberBiz);
	}
	
	//소비자 회원 추가정보 개인 조회
	public MemberUser getMemberUserInfoById(String userId) {
		return memberMapper.getMemberUserInfoById(userId);
	}
	
	//소비자 회원 추가정보 조회
	public List<MemberUser> getMemberUserList(){
		List<MemberUser> memberUserList = memberMapper.getMemberUserList();
		return memberUserList;
	}
	
	//마이페이지 내정보 수정
	public int modifyMyInfo(Member member) {
		return memberMapper.modifyMyInfo(member);
	}
	
	//회원 정보 조회(로그인,)
	public Member getMemberInfoById(String memberId) {
		return memberMapper.getMemberInfoById(memberId);
	}
	
	//회원 전체 목록 조회
	public List<Member> getMemberList(){
		List<Member> memberList = memberMapper.getMemberList();
		return memberList;
	}
	
	//소비자 추가정보 등록
	public int addMember03(MemberUser memberUser) {	
		return memberMapper.addMember03(memberUser);
	}
	
	//선호-비선호 선택내용 등록
	public int addMemberUserLike(MemberUserLike memberUserLike) {
		return memberMapper.addMemberUserLike(memberUserLike);
	}
	
	//선호-비선호 자동증가 코드
	public String getUserLikeCode() {
		return memberMapper.getUserLikeCode();
	}
	
	//선호-비선호 카테고리 불러오기
	public List<FoodMainCate> getFoodMainList(){
		List<FoodMainCate> foodMainList = memberMapper.getFoodMainList();
		return foodMainList;
	}
	
	//소비자, 소상공인 회원 등록
	public int addMember02(Member member) {
		return memberMapper.addMember02(member);
	}
	
	//id중복체크
	public Member idCheck(String memberId) {
		return memberMapper.idCheck(memberId);
	}
}
