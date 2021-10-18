package amdn.anywhere.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.MainMapper;

@Service
public class MainService {
		
	private final MainMapper mainMapper;
	
	@Autowired
	public MainService(MainMapper mainMapper) { 
		 this.mainMapper = mainMapper; 
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
