package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Store;
import amdn.anywhere.domain.Waiting;

@Mapper
public interface MainMapper {

	//상점목록 조회
	public List<Store> getMainList();
	
	//상점 조회
	public Store getMainRead(String stName);

}
