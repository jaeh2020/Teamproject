package amdn.anywhere.service;

import java.util.List;

import org.springframework.stereotype.Service;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Member;
import amdn.anywhere.mapper.MemberMapper;

@Service
public class MemberService {

	private final MemberMapper memberMapper;
	
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
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

}
