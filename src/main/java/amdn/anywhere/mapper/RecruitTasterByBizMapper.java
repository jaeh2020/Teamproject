package amdn.anywhere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.RecruitTasterByBiz;

@Mapper
public interface RecruitTasterByBizMapper {
	
	public List<RecruitTasterByBiz> selectRecruitBB(String recruitCode); 
	//조회수 업데이트
	public int updateViewCounts(String recruitCode);
	//모집리스트 상태 수정
	public int modifyState(Map<String, Object> paramMap);
	//모집코드 생성
	public String createRecruitCode();
	//모집 신청
	public int insertRecruit(RecruitTasterByBiz recruitTasterByBiz);
}
