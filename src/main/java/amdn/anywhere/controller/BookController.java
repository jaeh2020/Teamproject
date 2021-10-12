package amdn.anywhere.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Store;
import amdn.anywhere.service.BookService;



@Controller
@RequestMapping("/book")
public class BookController {
	
	private final BookService bookService;
	
		public BookController(BookService bookService) { 
			this.bookService = bookService;
		}
		
	@PostMapping(value="/addBookOrder", produces = "application/json")
	@ResponseBody
		public String addBookOrder(@RequestBody List<Map<String,Object>> paramList, Order order
								  ,Book book) {
			System.out.println("paramList:::"+paramList);
			System.out.println("paramList 0번째:::"+paramList.get(0).get("bookUserName"));
			String bookUserName = (String) paramList.get(0).get("bookUserName");
			book.setBookUserName(bookUserName);
		
			//메뉴정보 insert하기위해 정보 넘기기
			/*
		
			//결제예정 그룹코드 자동증가
			order.setPayGroCode(bookService.getnewOGroupCode());
			
			String newBookCode = bookService.getNewBookCode();
			String newOrderCode = bookService.getNewOrderCode();
			
			//예약코드 자동증가 생성 후 book테이블에 insert
			if(book != null && newBookCode != null) {
				book.setBookCode(newBookCode);
				bookService.addBookMember(book);
			}
					
			//주문코드 자동증가 생성 후 order테이블에 insert
			if(order != null && newOrderCode != null && newBookCode != null) {
				order.setBookCode(newBookCode);
				order.setoCode(newOrderCode);
				bookService.addBookOrder(order);
			}
			*/
		return "success";
	}
	
	
	
	
	
	@GetMapping("/addBookOrder")
		public String getaddBookOrder(Model model) {

		return "/book/addBookOrder";
		}
	
	
	
	@PostMapping("/addBookMember")
		public String addBookMember(Model model
								   ,Book book
								   ,@RequestParam(name="storeCode", required = false) String storeCode) {
				
			//메뉴 조회
			List<Menu> menuList = bookService.getMenuList(storeCode);
			
			model.addAttribute("menuList", menuList);
			model.addAttribute("title", "주문정보입력");
			model.addAttribute("location", "주문정보");
			model.addAttribute("book", book);
				
			
		//원래 redirect로 가야하는데 바로 insert되지않고 데이터만 가져가야해서 forward로 구현
		return "/book/addBookOrder";
	}
		
	
	@GetMapping("/addBookMember")
		public String getaddBookMember(@RequestParam(name="storeName", required = false) String storeName
									  ,@RequestParam(name="stateCode", required = false) String stateCode
				  					  ,Model model
				  					  ,HttpSession session) {
				
		//예약리스트 조회
		List<Book> bookList = bookService.getBookList();
		
		
		//상태코드 가져오기
		Statement statement = bookService.getStateCode(stateCode);
		
		
		//상점명 조회
		Store store = bookService.getStoreInfo(storeName);
		
		
		//예약코드 자동증가
		//String newBookCode = bookService.getNewBookCode();
		
			
		//세션아이디(로그인되어있는 아이디)
		String memberId = (String) session.getAttribute("SID");

		model.addAttribute("bookList", bookList);
		model.addAttribute("store", store);
		model.addAttribute("statement", statement);
		model.addAttribute("memberId", memberId);
		model.addAttribute("title", "예약정보입력");
		model.addAttribute("location", "예약정보");
		
		return "/book/addBookMember";
		}
	
}
