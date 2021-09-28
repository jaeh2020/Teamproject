package amdn.anywhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.BookMapper;


@Transactional
@Service
public class BookService {

	 private final BookMapper bookMapper;
	
	  
	 @Autowired
	 public BookService(BookMapper bookMapper) { 
	  this.bookMapper = bookMapper;
		  
	 }
	 

	 //예약리스트 조회
	 public List<Book> getBookList(String bookCode){
		 List<Book> bookList = bookMapper.getBookList(bookCode);
		 
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
	 public List<Menu> getMenuList(){
		 List<Menu> menuList = bookMapper.getMenuList();
		 
		 return menuList;
	 }
	 

	 //예약자정보화면에 상점명 뿌려주기
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

