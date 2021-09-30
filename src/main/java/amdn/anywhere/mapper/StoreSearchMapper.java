package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.Mystore;
import amdn.anywhere.domain.Sales;
import amdn.anywhere.domain.Store;

@Mapper
public interface StoreSearchMapper {
	
	public List<Store> getStoreList();
	
	public List<Store> getstoreSearch(@Param(value = "storeSearchKey") 	String storeSearchKey
									  ,@Param(value = "searchStartDate") 	String searchStartDate
									  ,@Param(value = "searchEndDate") 		String searchEndDate);
	
	public List<Store> getLTListDetail();
		
	public List<Store> getMystore();
}
