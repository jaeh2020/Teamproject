package amdn.anywhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amdn.anywhere.domain.Sales;
import amdn.anywhere.mapper.SalesMapper;


@Service
public class SalesService {
	
	
	  private final SalesMapper salesMapper;
	
	  @Autowired
	  public SalesService(SalesMapper salesMapper) { 
		  this.salesMapper = salesMapper; 
		  
	  }
	 
	 public List<Sales> getsalesList(){ 
		 List<Sales> salesList = salesMapper.getSalesList();
	
	 return salesList;
	 }
	 


}
