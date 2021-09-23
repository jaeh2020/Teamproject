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
	 
	 public List<Store> getMainList(){ 
		 List<Store> mainList = mainMapper.getMainList();
	
	 return mainList; }
	 


}
