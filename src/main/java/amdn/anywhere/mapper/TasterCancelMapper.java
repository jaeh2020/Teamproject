package amdn.anywhere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.TasterCancel;

@Mapper
public interface TasterCancelMapper {
	//평가단 목록 조회
	public List<TasterCancel> getTasterCancelList(Map<String, Object> paramMap);
	
	//평가단 취소 처리
	public int cancelTaster(Map<String, Object> paramMap);
	
	//회원별 취소 횟수 조회
	public int checkCancelTimes(String userId);
}
