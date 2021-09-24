package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Store;

@Mapper
public interface BookMapper {
	
	//상점명 조회
	public Store getStoreInfoById(String storeName);

}
