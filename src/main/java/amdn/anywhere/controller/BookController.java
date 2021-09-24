package amdn.anywhere.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.BookMapper;
import amdn.anywhere.service.BookService;



@Controller
public class BookController {
	
	private final BookService bookService;
	
	  public BookController(BookService bookService) { 
		  this.bookService = bookService;
		  
	}
	
	
	@GetMapping("/addBookMember")
	public String getaddBookMember(@RequestParam(name="storeName", required = false) String storeName
			   					  ,@RequestParam(name="storeCode", required = false) String storeCode
			   					  ,Model model
			   					  ,HttpSession session) {
		
		System.out.println("=========================");
		System.out.println("storeName : " + storeName);
		System.out.println("storeCode : " + storeCode);
		System.out.println("=========================");
		
		Store store = bookService.getStoreInfoById(storeName);
		Store storec = bookService.getStoreInfoByCode(storeCode);
		
		//상품증가코드
		String newBookCode = bookService.getNewBookCode();
		
		//아이디
		String userId = (String) session.getAttribute("SID");

		model.addAttribute("newBookCode", newBookCode);
		model.addAttribute("store", store);
		model.addAttribute("addBookMember", "예약정보입력");
		return "/book/addBookMember";
	}
	
	
	@PostMapping("/addBookMember")
		public String addBookMember(Book book) {
			System.out.println("=============================");
			System.out.println("dto만들어서 db에 담긴정보 나와야함");
			System.out.println("=============================");
			if(book != null) bookService.addBookMember(book);

		return "redirect:/book/addBookOrder";
	}
	
	@GetMapping("/addBookOrder")
	public String getaddBookOrder(Model model) {
		model.addAttribute("addBookOrder", "주문정보입력");
		return "/book/addBookOrder";
	}
	
}
