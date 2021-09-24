package amdn.anywhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.BoardMapper;
import amdn.anywhere.mapper.BookMapper;


@Service
public class BookService {
	
	
	  private final BookMapper bookMapper;
	
	  @Autowired
	  public BookService(BookMapper bookMapper) { 
		  this.bookMapper = bookMapper;
		  
	  }
	 
	 public Store getStoreInfoById(String storeName){ 
		 return bookMapper.getStoreInfoById(storeName); 
	  }
	 
	 public int addBookMember(Book book) {
		 return bookMapper.addBookMember(book);
	 }
	 
	 public String getNewBookCode() {
			return bookMapper.getNewBookCode();
	 }
	 
	 public Store getStoreInfoByCode(String storeCode) {
		 return bookMapper.getStoreInfoByCode(storeCode);
	 }
	 


}
