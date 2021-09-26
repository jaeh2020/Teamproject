package amdn.anywhere.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.Questionnaire;
import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.BookMapper;
import amdn.anywhere.service.BookService;



@Controller
public class BookController {
	
	private final BookService bookService;
	
	  public BookController(BookService bookService) { 
		  this.bookService = bookService;
		  
	}
	  
	  
	//메뉴클릭하면 수량칸에 클릭한 메뉴가 화면에 뿌려짐  

	  
	  
	
	
	
	@GetMapping("/addBookMember")
	public String getaddBookMember(@RequestParam(name="storeName", required = false) String storeName
								  ,Model model
			   					  ,HttpSession session) {
		
		System.out.println("=========================");
		System.out.println("storeName : " + storeName);
		System.out.println("=========================");
		
		Store store = bookService.getStoreInfoByName(storeName);

		//상품증가코드
		String newBookCode = bookService.getNewBookCode();
		
		//세션아이디(로그인되어있는 아이디)
		String memberId = (String) session.getAttribute("SID");


		model.addAttribute("bookCode", newBookCode);
		model.addAttribute("store", store);
		/* model.addAttribute("store", store); */
		model.addAttribute("title", "예약정보입력");
		model.addAttribute("location", "예약정보");
		return "/book/addBookMember";
	}
	
	
	@PostMapping("/addBookMember")
		public String addBookMember(Book book) {
			System.out.println("=============================");
			System.out.println("예약정보수정화면->주문정보수정화면 실행");
			System.out.println("=============================");
			if(book != null) bookService.addBookMember(book);

		return "redirect:/book/addBookOrder";
	}
	
	
	@GetMapping("/addBookOrder")
	public String getaddBookOrder(Model model) {
		
		List<Menu> menuList = bookService.getMenuList();
				
		model.addAttribute("menuList", menuList);
		model.addAttribute("title", "주문정보입력");
		model.addAttribute("location", "주문정보");
		
		return "/book/addBookOrder";
	}
	
}
