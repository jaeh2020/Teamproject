package amdn.anywhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Menu;
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
	  
	 
	 //주문정보에 메뉴리스트 뿌려주기
	 public List<Menu> getMenuList(){
		 List<Menu> menuList = bookMapper.getMenuList();
		 
		 return menuList;
	 }
	 

	 //상점명 가져와서 예약자정보화면에 뿌려주기

	 public Store getStoreInfoByName(String storeName){ 
		 return  bookMapper.getStoreInfoByName(storeName); 
	 }
	 
	 
	 //dto
	 public int addBookMember(Book book) {
		 return bookMapper.addBookMember(book);
	 }
	 
	 //주문코드 자동증가 코드
	 public String getNewBookCode() {
			return bookMapper.getNewBookCode();
	 }
	 
	

}

