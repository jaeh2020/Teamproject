package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Member;

@Mapper
public interface MemberMapper {

	//선호-비선호 카테고리 불러오기
	public List<FoodMainCate> getFoodMainList();
	
	//소비자, 소상공인 회원 등록
	public int addMember02(Member member);
}
