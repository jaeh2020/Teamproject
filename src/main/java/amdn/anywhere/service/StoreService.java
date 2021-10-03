package amdn.anywhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amdn.anywhere.domain.BadWords;
import amdn.anywhere.domain.QuestionCate;
import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.BadWordsMapper;
import amdn.anywhere.mapper.StoreMapper;

@Service
public class StoreService {
	private final StoreMapper storeMapper;
	
	@Autowired
	public StoreService(StoreMapper storeMapper) {
		this.storeMapper = storeMapper;
	}
	
	//나의매장정보 리스트 조회
		public Map<String, Object> getMyStoreList(String bizId){
		
		List<Store> storeList = storeMapper.getMyStoreList(bizId);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("storeList", storeList);
		
		return paramMap;
	}
	
	
	//매장리스트조회
	public List<Store> getStoreList(){
		List<Store> storeList = storeMapper.getStoreList();
		
		return storeList;
	}
}
