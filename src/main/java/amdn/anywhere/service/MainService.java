package amdn.anywhere.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.SearchKeyword;
import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.MainMapper;

@Service
public class MainService {
		
	private final MainMapper mainMapper;
	
	@Autowired
	public MainService(MainMapper mainMapper) { 
		 this.mainMapper = mainMapper; 
	}
	
	//1시간마다 count한 실시간 검색어현황 insert
	public int addSearchScheduler() {
		return mainMapper.addSearchScheduler();
	}
	
	
	//선호도별 매장 조회 선호도3
	public List<Store> getStoreLikeList3(String userId){
		List<Store> storeLikeList3 = mainMapper.getStoreLikeList3(userId);
		return storeLikeList3;
	}
	//선호도별 매장 조회 선호도2
	public List<Store> getStoreLikeList2(String userId){
		List<Store> storeLikeList2 = mainMapper.getStoreLikeList2(userId);
		return storeLikeList2;
	}
	//선호도별 매장 조회 선호도1
	public List<Store> getStoreLikeList(String userId){
		List<Store> storeLikeList = mainMapper.getStoreLikeList(userId);
		return storeLikeList;
	}
	
	
	//실시간검색현황 조회
	public SearchKeyword getSearchKeyword() {
		return mainMapper.getSearchKeyword();
	}
	
	
	//검색어 토탈 쌓기
	public int addSearchTotal(Map<String, Object> paramMap) {
		return mainMapper.addSearchTotal(paramMap);
	}
	
	
	//검색어코드 자동증가
	public String getNewSearchCode() {
		return mainMapper.getNewSearchCode();
	}

	
	//상점리스트 조회
	public List<Store> getMainList(Map<String,Object> paramMap){
		String placeInput = (String) paramMap.get("placeInput");
		String mainCateCode = (String) paramMap.get("mainCateCode");
		
		paramMap.put("placeInput", placeInput);
		paramMap.put("mainCateCode", mainCateCode);

		List<Store> storeList = mainMapper.getMainList(paramMap);
		 
		return storeList; 
	}
	
	//상점명만조회 (ajax)
	public Store getMainRead(String stName){ 
		return mainMapper.getMainRead(stName); 
	}
	 
}
