package amdn.anywhere.mapper;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Member;

@Mapper
public interface MemberMapper {

	//소비자, 소상공인 회원 등록
	public int addMember02(Member member);
}
