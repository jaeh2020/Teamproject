package amdn.anywhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.StoreMapper;

@Service
public class StoreService {
	private StoreMapper storeMapper;
	
	@Autowired
	public StoreService(StoreMapper storeMapper) {
		this.storeMapper = storeMapper;
	}
	
	
	//나의매장정보 수정처리
	public int modifyMyStore(Store store) {
		return storeMapper.modifyMyStore(store);
	}
	
	//수정처리 위한 매장코드 가져오기
	public Store getStoreInfoByCode(String storeCode) {
		  return storeMapper.getStoreInfoByCode(storeCode);
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