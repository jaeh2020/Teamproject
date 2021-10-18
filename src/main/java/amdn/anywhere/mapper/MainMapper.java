package amdn.anywhere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Store;

@Mapper
public interface MainMapper {

	//상점목록 조회
	public List<Store> getMainList(Map<String, Object> paramMap);
	
	//상점 조회
	public Store getMainRead(String stName);

}
