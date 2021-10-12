package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.Store;
import amdn.anywhere.domain.Table;

@Mapper
public interface StoreMapper {
	
	//나의매장 테이블코드 자동증가
	public String getNewStoreTableCode();
	
	//나의매장 테이블번호 자동증가
	public int getNewTableNum(String storeCode);
	
	//나의매장 테이블등록 처리
	public int addMyTable(Table table);
	
	//나의매장 테이블 삭제처리
	public int deleteMyTable(String storeTableCode);
	
	//나의매장 테이블 리스트 조회
	public List<Table> getMyTableList(String bizId);
	
	//나의매장 메뉴삭제처리
	public int deleteMyMenu(String menuCode);
	
	//나의매장 메뉴수정 처리
	public int modifyMyMenu(Menu menu);
	
	//매장코드와 일치하는 대분류만 조회
	public List<Store> getMyMainCateOnly(String storeCode);
	public List<Store> getMyMainCateOnly2(String storeCode);
	
	//나의매장 메뉴수정 화면
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
	
	//나의매장정보 선택하여 조회 - ajax
	public Store getStoreRead(String stCode);
	
	//나의매장 정보 조회
	public List<Store> getMyStoreInfo(String bizCode);
	
	//나의매장 정보 리스트 조회(카테까지 나옴 지워야함)
	public List<Store> getMyStoreList(String bizCode);
	public List<Store> getMyStoreList2(String bizCode);
	
	//전체매장 메뉴리스트 조회
	public List<Menu> getMenuList();
	
	//전체매장 리스트 조회
	public List<Store> getStoreList();
}
