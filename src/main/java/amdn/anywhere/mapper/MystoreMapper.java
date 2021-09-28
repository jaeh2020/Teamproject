package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.Mystore;
import amdn.anywhere.domain.Sales;
import amdn.anywhere.domain.Store;

@Mapper
public interface MystoreMapper {
	
	//상점목록 조회
	public List<Store> getMystoreList(String storeCode);
	
	//상점 조회
	public Store getMystoreRead(String storeCode);
	
	public List<Store> getMystore();
	
}
