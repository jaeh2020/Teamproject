package amdn.anywhere.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;


import amdn.anywhere.domain.Store;



@Mapper
public interface TasterMapper {
	
	public List<Store> getStoreList(String bizId);

}