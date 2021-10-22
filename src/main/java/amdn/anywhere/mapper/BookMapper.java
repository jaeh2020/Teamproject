package amdn.anywhere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Store;

@Mapper
public interface BookMapper {
	
	
	//예약취소테이블 insert
	public int addBookCancel(Map<String, String> paramMap);
	
	//예약취소코드 자동증가
	public String getNewbookCancelCode();
	
	//주문내역 리스트
	public List<Order> getOrderAllList(Map<String, Object> paramMap);
	
	//나의주문내역 상세조회
	public List<Order> getOrderList(String bookCode);
	
	//주문내역 리스트 조회
	public List<Order> getOrderUserInfoById(Map<String, Object> paramMap);
	
	//결제예정 그룹코드 자동증가
	public String getnewOGroupCode();

	//예약리스트 조회
	public List<Book> getBookList();
	
	//주문코드자동증가
	public String getNewOrderCode();
	
	//주문정보입력후 insert
	public int addBookOrder(List<Map<String,Object>> paramList);
	
	//예약자정보화면에서 상태코드 조회
	public Statement getStateCode(String stateCode);
	
	//주문정보화면에서 메뉴리스트 조회
	public List<Menu> getMenuList(String storeCode);

	//상점명 조회
	public Store getStoreInfo(String storeName);
	
	//예약정보입력후 insert
	public int addBookMember(Book book);
	
	//예약코드 자동증가
	public String getNewBookCode();
}
