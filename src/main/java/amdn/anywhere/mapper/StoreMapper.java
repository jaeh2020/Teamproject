package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.Store;

@Mapper
public interface StoreMapper {
	
	//메뉴삭제처리
	public int deleteMyMenu(String menuCode);
	
	//메뉴수정 처리
	public int modifyMyMenu(Menu menu);
	
	//메뉴수정 화면
	public Menu getMyMenuInfoByMenuCode(String menuCode);
	
	//메뉴코드 자동증가
	public String getNewMenuCode();
	
	//메뉴 등록 처리
	public int addMyMenu(Menu menu);
	
	//메뉴 대분류 수정처리
	public int modifyMainCate(Store store);
	
	//메뉴 대분류 조회
	public List<FoodMainCate> getMainCate();
	
	//나의매장 메뉴리스트 조회
	public List<Menu> getMyMenuList(String bizId);
	
	//나의매장정보 수정처리
	public int modifyMyStore(Store store);
	
	//수정처리 위한 매장코드 조회
	public Store getStoreInfoByCode(String storeCode);
	
	//나의매장 정보 리스트 조회
	public List<Store> getMyStoreList(String bizId);
	public List<Store> getMyStoreList2(String bizId);
	
	//매장 리스트 조회
	public List<Store> getStoreList();
}
