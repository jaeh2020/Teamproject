package amdn.anywhere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.MemberBiz;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Store;
import amdn.anywhere.domain.StoreCancel;
import amdn.anywhere.domain.Table;
import amdn.anywhere.domain.Waiting;

@Mapper
public interface StoreMapper {
	

	
	//승인버튼시 매장 delete
	public int deleteStore(String storeCode);
	
	//승인버튼시 상태.완료일시.승인완료아이디 update
	public int modifyStoreCancel(Map<String, String> paramMap);
	
	//입점취소신청 리스트 조회
	public List<StoreCancel> getStoreCancelList();
	
	//나의 입점취소현황 조회
	public List<StoreCancel> getmyCancelStoreList(String bizId);
	
	//취소요청 상태코드 가져오기
	public Statement getCancelStatement();
	
	//입점취소신청 전송
	public int cancelStore(StoreCancel storeCancel);
	
	//취소코드 자동증가
	public String getNewCancelCode();
	
	//입점등록후 웨이팅테이블 insert
	public int addWaitingTable(Waiting waiting);
	
	//웨이팅코드 자동증가
	public String getNewWaitingCode();
	
	//입점등록처리
	public int addMyStore(Store store);
	
	//매장코드 자동증가
	public String getNewStoreCode();
	
	//소상공인코드 조회 
	public MemberBiz getBizCode(String bizId);
	
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
	
	//나의매장정보 선택하여 입점취소 상태코드 조회 - ajax
	public StoreCancel getMyCancelList(String stCode);
	
	//나의매장정보 선택하여 조회 - ajax
	public Store getStoreRead(String stCode);
	
	//나의매장 정보 조회
	public List<Store> getMyStoreInfo(String bizCode);
	
	//나의매장 정보 리스트 조회(카테까지 나옴 지워야함)
	public List<Store> getMyStoreList(String bizCode);
	public List<Store> getMyStoreList2(String bizCode);
	
	//전체매장 테이블리스트조회
	public List<Table> getTableList();
	
	//전체매장 메뉴리스트 조회
	public List<Menu> getMenuList();
	
	//전체매장 리스트 조회
	public List<Store> getStoreList();
}
