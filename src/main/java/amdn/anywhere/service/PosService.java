package amdn.anywhere.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.MainMapper;
import amdn.anywhere.mapper.PosMapper;

@Service
public class PosService {
		
	private final PosMapper posMapper;
	
	@Autowired
	public PosService(PosMapper posMapper) { 
		 this.posMapper = posMapper; 
	}

	//나의매장 주문pos list조회
	public List<Order> getPosOrderList(String storeCode){
		List<Order> myPosOrderList = posMapper.getPosOrderList(storeCode);
		
		return myPosOrderList;
	}
	
}
