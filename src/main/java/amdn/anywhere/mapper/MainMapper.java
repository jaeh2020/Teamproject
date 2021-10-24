package amdn.anywhere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.SearchKeyword;
import amdn.anywhere.domain.Store;

@Mapper
public interface MainMapper {
	
	
	
	//선호도별 매장조회 선호도3
	public List<Store> getStoreLikeList3(String userId);
	//선호도별 매장조회 선호도2
	public List<Store> getStoreLikeList2(String userId);
	//선호도별 매장조회 선호도1
	public List<Store> getStoreLikeList(String userId);
	
	//실시간검색현황 조회
	public SearchKeyword getSearchKeyword();
	
	//검색어토탈 쌓기
	public int addSearchTotal(Map<String, Object> paramMap);
	
	//검색어코드 자동증가
	public String getNewSearchCode();

	//상점목록 조회
	public List<Store> getMainList(Map<String, Object> paramMap);
	
	//상점 조회
	public Store getMainRead(String stName);

}
