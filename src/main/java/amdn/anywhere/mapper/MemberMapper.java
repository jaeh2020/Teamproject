package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Member;
import amdn.anywhere.domain.MemberUser;
import amdn.anywhere.domain.MemberUserLike;

@Mapper
public interface MemberMapper {

	//소비자 회원 추가정보 개인조회
	public MemberUser getMemberUserInfoById(String userId);
	
	//소비자 회원 추가정보 조회
	public List<MemberUser> getMemberUserList();
	
	//마이페이지 내정보 수정
	public int modifyMyInfo(Member member);
	
	//회원 정보 조회(로그인, 내정보)
	public Member getMemberInfoById(String memberId);
	
	//회원 전체 목록 조회
	public List<Member> getMemberList();
	
	//회원관리 소비자 추가정보 등록
	public int addMember03(MemberUser memberUser);
	
	//선호-비선호 선택 등록
	public int addMemberUserLike(MemberUserLike memberUserLike);
	
	//선호-비선호 기본키 자동증가
	public String getUserLikeCode();
	
	//선호-비선호 카테고리 불러오기
	public List<FoodMainCate> getFoodMainList();
	
	//소비자, 소상공인 회원 등록
	public int addMember02(Member member);
	
	//id중복체크
	public Member idCheck(String memberId);
}
