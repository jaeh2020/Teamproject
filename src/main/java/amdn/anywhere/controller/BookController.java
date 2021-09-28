package amdn.anywhere.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.Questionnaire;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.BookMapper;
import amdn.anywhere.service.BookService;



@Controller
@RequestMapping("/book")
public class BookController {
	
	private final BookService bookService;
	
		public BookController(BookService bookService) { 
			this.bookService = bookService;
		}
		
	//주문정보 입력 후 insert
	@PostMapping("/addBookOrder")
		public String addBookOrder(Order order) {

			if(order != null) bookService.addBookOrder(order);


		return "redirect:/";
	}
	
	@GetMapping("/addBookOrder")
		public String getaddBookOrder(Model model) {
		

		
		//주문코드 자동증가
		String newOrderCode = bookService.getNewOrderCode();
		
		//메뉴 조회
		List<Menu> menuList = bookService.getMenuList();
		
				
		model.addAttribute("oCode", newOrderCode);
		model.addAttribute("menuList", menuList);
		model.addAttribute("title", "주문정보입력");
		model.addAttribute("location", "주문정보");
		
		return "/book/addBookOrder";
		}
	
	
	
	@PostMapping("/addBookMember")
		public String addBookMember(@RequestParam(name="bookCode", required = false) String bookCode
								  ,Book book) {
		
		//예약정보입력>주문입력 post방식 전송
			bookService.getBookList(bookCode);
	
		
		//예약자정보입력 예약테이블에 insert 
			if(book != null) bookService.addBookMember(book);

		return "redirect:/book/addBookOrder";
	}
		
	
	@GetMapping("/addBookMember")
		public String getaddBookMember(@RequestParam(name="storeName", required = false) String storeName
									  ,@RequestParam(name="stateCode", required = false) String stateCode
				  					  ,Model model
				  					  ,HttpSession session) {
		
		
		//예약리스트 조회
		List<Book> bookList = bookService.getBookList(stateCode);
		
		
		//상태코드 가져오기
		Statement statement = bookService.getStateCode(stateCode);
		
		
		//상점정보 가져오기
		Store store = bookService.getStoreInfo(storeName);
		
		
		//예약코드 자동증가
		String newBookCode = bookService.getNewBookCode();
		
			
		//세션아이디(로그인되어있는 아이디)
		String memberId = (String) session.getAttribute("SID");


		model.addAttribute("bookCode", newBookCode);
		model.addAttribute("bookList", bookList);
		model.addAttribute("store", store);
		model.addAttribute("statement", statement);
		model.addAttribute("memberId", memberId);
		model.addAttribute("title", "예약정보입력");
		model.addAttribute("location", "예약정보");
		
		return "/book/addBookMember";
		}
	
}
