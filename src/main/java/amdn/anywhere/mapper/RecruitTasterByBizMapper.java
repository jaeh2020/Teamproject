package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.RecruitTasterByBiz;

@Mapper
public interface RecruitTasterByBizMapper {
	public List<RecruitTasterByBiz> selectRecruitBB(); 
	
}
