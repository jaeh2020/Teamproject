package amdn.anywhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Store;
import amdn.anywhere.domain.Table;
import amdn.anywhere.mapper.BookMapper;


@Transactional
@Service
public class BookService {

	 private final BookMapper bookMapper;
	
	 @Autowired
	 public BookService(BookMapper bookMapper) { 
	  this.bookMapper = bookMapper;
		  
	 }

	 
	//나의 주문내역 상세 조회
	public Map<String, Object> getOrderList(String bookCode){ 
		
		List<Order> orderDetail = bookMapper.getOrderList(bookCode); 
		
		Map<String, Object>paramMap = new HashMap<String, Object>(); 
		
		paramMap.put("orderDetail",orderDetail); 
		
		return paramMap;
	}
	
	 
	 //나의 주문내역 리스트
	public Map<String, Object> getOrderUserInfoById(String bizId){ 
		
		List<Order> userOrderList = bookMapper.getOrderUserInfoById(bizId); 
		
		Map<String, Object>paramMap = new HashMap<String, Object>(); 
		
		paramMap.put("userOrderList",userOrderList); 
		
		return paramMap;
	 }
	 
	 //결제예정 그룹코드 자동증가
	 public String getnewOGroupCode() {
		 return bookMapper.getnewOGroupCode();
	 }
	 

	 //예약리스트 조회
	 public List<Book> getBookList(){
		 List<Book> bookList = bookMapper.getBookList();
		 
		 return bookList;
	 }
	 
	 
	 //주문코드 자동증가
	 public String getNewOrderCode() {
		 return bookMapper.getNewOrderCode();
	 }
	 
	 
	 
	 //주문정보입력 후 insert
	 public int addBookOrder(Order order) {
		 return bookMapper.addBookOrder(order);
	 }
	 
	 
	 //예약자정보화면에 상태코드 가져오기
	 public Statement getStateCode(String stateCode) {
		 return bookMapper.getStateCode(stateCode);
	 }
	  
	 
	 //주문정보에 메뉴리스트 뿌려주기
	 public List<Menu> getMenuList(String storeCode){
		 List<Menu> menuList = bookMapper.getMenuList(storeCode);
		 
		 return menuList;
	 }
	 

	 //상점정보가져오기 - 예약자정보화면에 상점명 뿌려주기
	 public Store getStoreInfo(String storeName){ 
		 return bookMapper.getStoreInfo(storeName); 
	 }
	 
	 
	 //예약자정보입력 후 insert
	 public int addBookMember(Book book) {
		 return bookMapper.addBookMember(book);
	 }
	 
	 //예약코드 자동증가
	 public String getNewBookCode() {
			return bookMapper.getNewBookCode();
	 }
	 
	

}

