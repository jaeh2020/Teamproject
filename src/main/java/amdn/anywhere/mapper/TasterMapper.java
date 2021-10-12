package amdn.anywhere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.Store;
import amdn.anywhere.domain.Taster;



@Mapper
public interface TasterMapper {
	//평가단 정보 수정
	public int updateTaster(Map<String, String> paramMap);
	//평가단 추가
	public int addTaster(Taster taster);
	//평가단코드생성
	public String createTasterCode();
	//평가단 조회
	public List<Taster> getTasterList(Map<String, Object> paramMap);
	
	public List<Store> getStoreList(String bizId);
	
	public List<Menu> getMenuList(String storeCode);
	


}
