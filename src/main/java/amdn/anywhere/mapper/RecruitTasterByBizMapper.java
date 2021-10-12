package amdn.anywhere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.RecruitTasterByBiz;

@Mapper
public interface RecruitTasterByBizMapper {
	
	public List<RecruitTasterByBiz> selectRecruitBB(String recruitCode); 
	
	//모집리스트 (상태:state, 조회수:view, 현재모집인원:nowNum) 업데이트
	public int updateRecruitBBiz(Map<String, String> paramMap);
	//모집코드 생성
	public String createRecruitCode();
	//모집 신청
	public int insertRecruit(RecruitTasterByBiz recruitTasterByBiz);
}
