package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.BizEvalAgreeChange;
import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Member;
import amdn.anywhere.domain.MemberBiz;
import amdn.anywhere.domain.MemberLogin;
import amdn.anywhere.domain.MemberUser;
import amdn.anywhere.domain.MemberUserLike;
import amdn.anywhere.domain.MembershipDel;

@Mapper
public interface MemberMapper {

	//포인트 소멸 후 업데이트
	public int modifyPointDel(MemberUser memberUser);
	
	//포인트 적립 후 업데이트
	public int modifyPoint(MemberUser memberUser);
	
	//로그아웃 내역 업데이트
	public int modifyLogout(MemberLogin memberLogin);
	
	//전체 회원 로그인 내역 입력
	public int addLogin(MemberLogin memberLogin);
	
	//로그인내역코드 자동증가
	public String getLoginCode();
	
	//소비자(user)회원 탈퇴
	public int removeMemberUser(String userId);
	
	//전체(member)회원탈퇴
	public int removeMember(String memberId);
	
	//선호-비선호 선택 등록
	public int modifyUserLike(MemberUserLike memberUserLike);
	
	//소상공인 평가동의 승인 상태 승인자 변경
	public int modifyBizEvalConfirm(BizEvalAgreeChange bizEvalAgreeChange);
	
	//소상공인 승인신청 개인 조회(bizId)
	public BizEvalAgreeChange getBizEvalInfoById(String bizId);
	
	//소상공인 승인신청 개인 조회(code)
	public BizEvalAgreeChange getBizEvalInfoByCode(String eAgreeCode);
	
	//소상공인 평가동의 승인신청 목록
	public List<BizEvalAgreeChange> getBizEvalList();

	//소상공인 승인 상태, 승인자 아이디 변경
	public int modifyBizConfirm(MemberBiz memberBiz);
	
	//소상공인 승인신청 개인 조회(id)
	public MemberBiz getMemberBizInfoById(String bizId);
	
	//소상공인 승인신청 개인 조회(code)
	public MemberBiz getMemberBizInfoByCode(String bizCode);
	
	//소상공인 승인 목록
	public List<MemberBiz> getMemberBizList();
	
	//소상공인 신청 기본키 자동증가
	public String getMemberBizCode();
	
	//소상공인 승인신청 등록
	public int addBizConfirm(MemberBiz memberBiz);
	
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
