package amdn.anywhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.MemberBiz;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Store;
import amdn.anywhere.domain.StoreCancel;
import amdn.anywhere.domain.Table;
import amdn.anywhere.mapper.StoreMapper;

@Service
public class StoreService {
	private StoreMapper storeMapper;
	
	@Autowired
	public StoreService(StoreMapper storeMapper) {
		this.storeMapper = storeMapper;
	}
	
	//승인버튼시 상태.완료일시.승인완료아이디 update
	public int modifyStoreCancel(StoreCancel storeCancel) {
		return storeMapper.modifyStoreCancel(storeCancel);
	}
	
	//취소현황 리스트 조회
	public List<StoreCancel> getStoreCancelList(){
		List<StoreCancel> storeCancelList = storeMapper.getStoreCancelList();
		return storeCancelList;
	}
	
	//나의입점취소현황 조회
	public Map<String, Object> getmyCancelStoreList(String bizId){
		
		List<StoreCancel> myCancelStoreList = storeMapper.getmyCancelStoreList(bizId);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("myCancelStoreList", myCancelStoreList);
		
		return paramMap;
	}
	
	//취소요청 상태코드 가져오기
	public Statement getCancelStatement() {
		return storeMapper.getCancelStatement();
	}
	
	//입점취소 전송
	public int cancelStore(StoreCancel storeCancel) {
		return storeMapper.cancelStore(storeCancel);
	}
	
	//취소코드 자동증가
	public String getNewCancelCode() {
		return storeMapper.getNewCancelCode();
	}
	
	//입점등록처리
	public int addMyStore(Store store) {
		return storeMapper.addMyStore(store);
	}
	
	//매장코드 자동증가 
	public String getNewStoreCode() {
		return storeMapper.getNewStoreCode();
	}
	
	//소상공인 코드 조회 
	public MemberBiz getBizCode(String bizId){ 
		return storeMapper.getBizCode(bizId);
	}
	
	//나의매장 테이블코드 자동증가
	public String getNewStoreTableCode() {
		return storeMapper.getNewStoreTableCode();
	}
	
	//나의매장 테이블번호 자동증가
	public int getNewTableNum(String storeCode) {
		return storeMapper.getNewTableNum(storeCode);
	}
	
	//나의매장 테이블 등록처리
	public int addMyTable(Table table) {
		return storeMapper.addMyTable(table);
	}
	
	//나의매장 테이블 삭제처리
	public int deleteMyTable(String storeTableCode) {
		return storeMapper.deleteMyTable(storeTableCode);
	}
	
	//나의매장 테이블 리스트 조회
	public Map<String, Object> getMyTableList(String bizId){
		
		List<Table> tableList = storeMapper.getMyTableList(bizId);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
			
		paramMap.put("tableList", tableList);
		
		return paramMap;
	}
	
	//나의매장 메뉴삭제처리
	public int deleteMyMenu(String menuCode) {
		return storeMapper.deleteMyMenu(menuCode);
	}
	
	//나의매장 메뉴수정처리
	public int modifyMyMenu(Menu menu) {
		return storeMapper.modifyMyMenu(menu);
	}
	
	
	//매장코드와 일치하는 대분류만 조회
	public Map<String, Object> getMyMainCateOnly(String storeCode){
		
		List<Store> mainCateOnly = storeMapper.getMyMainCateOnly(storeCode);
		List<Store> mainCateOnly2 = storeMapper.getMyMainCateOnly2(storeCode);
					
		Map<String, Object> paramMap = new HashMap<String, Object>();
					
		paramMap.put("mainCateOnly", mainCateOnly);
		paramMap.put("mainCateOnly2", mainCateOnly2);
	
		return paramMap;
	}
	
	//나의매장 메뉴수정화면
	public Menu getMyMenuInfoByMenuCode(String menuCode) {
		return storeMapper.getMyMenuInfoByMenuCode(menuCode);
	}
	
	//메뉴코드 자동증가
	public String getNewMenuCode() {
		return storeMapper.getNewMenuCode();
	}
	
	//메뉴 등록처리
	public int addMyMenu(Menu menu) {
		return storeMapper.addMyMenu(menu);
	}
	
	//메뉴 대분류 수정처리
	public int modifyMainCate(Store store) {
		return storeMapper.modifyMainCate(store);
	}
	
	//메뉴 대분류 조회
		public List<FoodMainCate> getMainCate(){
			List<FoodMainCate> mainCate = storeMapper.getMainCate();
			
		return mainCate;
	}

	//나의매장 메뉴리스트 조회
	public Map<String, Object> getMyMenuList(String bizId){
			
		List<Menu> myMenuList = storeMapper.getMyMenuList(bizId);
					
		Map<String, Object> paramMap = new HashMap<String, Object>();
					
		paramMap.put("myMenuList", myMenuList);
	
		return paramMap;
	}
	
	
	//나의매장정보 수정처리
	public int modifyMyStore(Store store) {
		return storeMapper.modifyMyStore(store);
	}
	
	//수정처리 위한 매장코드 가져오기
	public Store getStoreInfoByCode(String storeCode) {
		return storeMapper.getStoreInfoByCode(storeCode);
	}
	
	
	//내의매장정보 선택하여 조회 - ajax
	public Store getStoreRead(String stCode){ 
		return storeMapper.getStoreRead(stCode); 
	}
	
	
	//나의매장정보 리스트 조회(카테까지 나오는거)
	public Map<String, Object> getMyStoreList(String bizId){
		
		List<Store> storeList = storeMapper.getMyStoreList(bizId);
		List<Store> storeList2 = storeMapper.getMyStoreList2(bizId);
			
		Map<String, Object> paramMap = new HashMap<String, Object>();
			
		paramMap.put("storeList", storeList);
		paramMap.put("storeList2", storeList2);
		
		return paramMap;
	}
	
	//나의매장정보 리스트 조회
	public Map<String, Object> getMyStoreInfo(String bizId){
		
		List<Store> storeInfo = storeMapper.getMyStoreInfo(bizId);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("storeInfo", storeInfo);
		
		return paramMap;
	}
	
	//매장전체 메뉴리스트 조회
	public List<Menu> getMenuList(){
		List<Menu> menuList = storeMapper.getMenuList();
		
		return menuList;
	}

	
	//매장전체 매장리스트조회
	public List<Store> getStoreList(){
		List<Store> storeList = storeMapper.getStoreList();
		
		return storeList;
	}

}
