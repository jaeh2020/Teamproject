package amdn.anywhere.service;

import java.util.List;

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
	public List<Store> getMainList(){ 
		 List<Store> storeList = mainMapper.getMainList();
		 
		return storeList; 
	}
	
	//상정명만조회 (ajax)
	public Store getMainRead(String stName){ 
		return mainMapper.getMainRead(stName); 
	}
	 
}
