package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Store;

@Mapper
public interface StoreMapper {
	
	//나의매장정보 수정처리
	public int modifyMyStore(Store store);
	
	//수정처리 위한 매장코드 조회
	public Store getStoreInfoByCode(String storeCode);
	
	//나의매장 정보 리스트 조회
	public List<Store> getMyStoreList(String bizId);
	
	//매장 리스트 조회
	public List<Store> getStoreList();
}
