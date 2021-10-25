package amdn.anywhere.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Mystore;
import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.ExpenseMapper;
import amdn.anywhere.mapper.MystoreMapper;
import amdn.anywhere.mapper.SalesMapper;
import amdn.anywhere.mapper.StoreSearchMapper;

@Service
@Transactional
public class AccountService {
	
	
	private static final Logger log = LoggerFactory.getLogger(AccountService.class);

	
	private final MystoreMapper mysyotrMapper;
	private final ExpenseMapper expenseMapper;
	private final SalesMapper salesMapper;
	private final StoreSearchMapper storeSearchMapper;
	
	public AccountService(MystoreMapper mysyotrMapper, ExpenseMapper expenseMapper, SalesMapper salesMapper, StoreSearchMapper storeSearchMapper) {
		this.mysyotrMapper = mysyotrMapper;
		this.expenseMapper = expenseMapper;
		this.salesMapper = salesMapper;
		this.storeSearchMapper = storeSearchMapper;
	}
   
	public Store getMystoreRead(String storeCode){ 
		return mysyotrMapper.getMystoreRead(storeCode); 
	}

	public List<Store> getMystoreList(String storeCode){
		List<Store> mystoreList = mysyotrMapper.getMystoreList(storeCode);
		log.info("mystoreList : {}",mystoreList);
		return mystoreList;
   }   
	
	public List<Store> getMystoreList(String storeCode, String searchStartDate, String searchEndDate){
		List<Store> storeSearch = mysyotrMapper.getMystoreSearch(storeCode);
		log.info("Service 검색된 리스트: {}", storeSearch);
		
		return storeSearch;
	}
	
	public List<Mystore> getMystoreExpense(String storeCode, String searchStartDate, String searchEndDate){
		List<Mystore> storeSearch = mysyotrMapper.getMystoreExpense(storeCode);
		log.info("Service 검색된 리스트: {}", storeSearch);
		return storeSearch;
	}
	
	/*
	 * public List<Mystore> getMySales(String storeCode){ List<Mystore> storeSearch
	 * = salesMapper.getSalesList(storeCode); log.info("SalesList 검색된 리스트: {}",
	 * storeSearch); return storeSearch; }
	 */
	
}
