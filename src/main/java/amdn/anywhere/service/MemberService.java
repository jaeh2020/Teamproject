package amdn.anywhere.service;

import java.util.List;

import org.springframework.stereotype.Service;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Member;
import amdn.anywhere.domain.MemberUser;
import amdn.anywhere.domain.MemberUserLike;
import amdn.anywhere.mapper.MemberMapper;

@Service
public class MemberService {

	private final MemberMapper memberMapper;
	
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
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
