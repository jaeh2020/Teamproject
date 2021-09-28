package amdn.anywhere.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.ExpenseMapper;
import amdn.anywhere.mapper.MystoreMapper;
import amdn.anywhere.mapper.SalesMapper;

@Service
@Transactional
public class AccountService {
	
	private final MystoreMapper mysyotrMapper;
	private final ExpenseMapper expenseMapper;
	private final SalesMapper salesMapper;
	
	public AccountService(MystoreMapper mysyotrMapper, ExpenseMapper expenseMapper, SalesMapper salesMapper) {
		this.mysyotrMapper = mysyotrMapper;
		this.expenseMapper = expenseMapper;
		this.salesMapper = salesMapper;
	}
   
	public Store getMystoreRead(String storeCode){ 
		return mysyotrMapper.getMystoreRead(storeCode); 
	}

	public List<Store> getMystoreList(String storeCode){
		return mysyotrMapper.getMystoreList(storeCode);
   }   
}
