package amdn.anywhere.controller;

import java.util.HashMap;
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
import amdn.anywhere.domain.MemberUser;
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
	
	
	//영수증 출력 페이지
	@GetMapping("/orderReceipt")
	public String orderReceipt(@RequestParam(name = "bookCode", required = false) String bookCode
			,Model model){
		
		Map<String, Object> paramMap = bookService.getOrderList(bookCode);
		
		model.addAttribute("orderDetail", paramMap.get("orderDetail"));
		model.addAttribute("title", "영수증출력");
		model.addAttribute("location", "영수증출력");
		
		return "/book/orderReceipt";
	}
	
	
	@GetMapping("/orderDetail")
		public String orderDetail(@RequestParam(name = "bookCode", required = false) String bookCode
								 ,Model model){
		
		//예약주문내역리스트 상세조회
		Map<String, Object> paramMap = bookService.getOrderList(bookCode);
		
		model.addAttribute("orderDetail", paramMap.get("orderDetail"));
		model.addAttribute("title", "나의주문예약정보 상세내역");
		model.addAttribute("location", "나의주문예약정보 상세내역");
		
		return "/book/orderDetail";
	}
		
		
	//전체 주문내역리스트 조회	
	@GetMapping("/bookOrderList")
	public String bookOrderList(Model model
								,@RequestParam(name = "dateBefore", required = false) String dateBefore
							  	,@RequestParam(name = "dateAfter", required = false) String dateAfter) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dateBefore", dateBefore);
		paramMap.put("dateAfter", dateAfter);
		
		System.out.println(dateBefore + ": dateBefore");
		System.out.println(dateAfter + ": dateAfter");
		
		//주문리스트 조회
		List<Order> orderList = bookService.getOrderAllList(paramMap);
	
		model.addAttribute("orderList", orderList);
		model.addAttribute("title", "주문내역");
		model.addAttribute("location", "주문내역");
		
		return "/book/bookOrderList";
	}
	
	
	//나의 주문내역리스트 조회	
	@GetMapping("/bookMyOrderList")
		public String bookMyOrderList(Model model
								  	,@RequestParam(name = "userId", required = false) String userId
								  	,@RequestParam(name = "dateBefore", required = false) String dateBefore
								  	,@RequestParam(name = "dateAfter", required = false) String dateAfter) {
		
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dateBefore", dateBefore);
		paramMap.put("dateAfter", dateAfter);
		paramMap.put("userId", userId);
		
		System.out.println(dateBefore + ": dateBefore");
		System.out.println(dateAfter + ": dateAfter");
		System.out.println(userId + ": userId");
		
		List<Order> userOrderList = bookService.getOrderUserInfoById(paramMap);
		
		model.addAttribute("userOrderList", userOrderList);
		model.addAttribute("title", "나의주문내역");
		model.addAttribute("location", "나의주문내역");
		
		return "/book/bookMyOrderList";
	}
	
		
		
	//주문정보입력 처리
	@PostMapping(value="/addBookOrder", produces = "application/json")
	@ResponseBody
		public String addBookOrder(@RequestBody List<Map<String,Object>> paramList
								  ,Order order
								  ,Book book) {
			System.out.println("paramList:::"+paramList);
			System.out.println("paramList 0번째:::"+paramList.get(0).get("storeCode"));
			System.out.println("paramList 0번째:::"+paramList.get(0).get("userId"));
			System.out.println("paramList 0번째:::"+paramList.get(0).get("bookUserName"));
			System.out.println("paramList 0번째:::"+paramList.get(0).get("bookUserPhone"));
			System.out.println("paramList 0번째:::"+paramList.get(0).get("bookPeoNum"));
			System.out.println("paramList 0번째:::"+paramList.get(0).get("stateCode"));
			System.out.println("paramList 0번째:::"+paramList.get(0).get("bookPickup"));
			
			//paramList에서 예약정보 불러오기
			String storeCode = (String) paramList.get(0).get("storeCode");
			String userId = (String) paramList.get(0).get("userId");
			String bookUserName = (String) paramList.get(0).get("bookUserName");
			String bookUserPhone = (String) paramList.get(0).get("bookUserPhone");
			int bookPeoNum = (int) paramList.get(0).get("bookPeoNum");
			String stateCode = (String) paramList.get(0).get("stateCode");
			String bookPickup = (String) paramList.get(0).get("bookPickup");
			
			//불러온 예약정보 DTO에 setter
			book.setStoreCode(storeCode);
			book.setUserId(userId);
			book.setBookUserName(bookUserName);
			book.setBookUserPhone(bookUserPhone);
			book.setBookPeoNum(bookPeoNum);
			book.setStateCode(stateCode);
			book.setBookPickup(bookPickup);
		
		
			//결제예정 그룹코드 자동증가
			order.setPayGroCode(bookService.getnewOGroupCode());
			
			String newBookCode = bookService.getNewBookCode();
			
			//예약코드 자동증가 생성 후 book테이블에 insert
			if(book != null && newBookCode != null) {
				book.setBookCode(newBookCode);
				bookService.addBookMember(book);
			}
					
			//주문코드 자동증가 생성 후 order테이블에 insert
			if(order != null && newBookCode != null) {
				order.setBookCode(newBookCode);
				bookService.addBookOrder(order);
			}
			
		return "success";
	}
	
	
	
	
	//주문정보 입력
	@GetMapping("/addBookOrder")
		public String getaddBookOrder(Model model) {

		return "/book/addBookOrder";
		}
	
	
	
	
	//예약정보입력 처리
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
		
	
	
	//예약정보입력 화면
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
