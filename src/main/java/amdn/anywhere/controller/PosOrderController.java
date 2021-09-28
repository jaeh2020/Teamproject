package amdn.anywhere.controller;

import java.util.List;

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
import amdn.anywhere.domain.Questionnaire;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.BookMapper;
import amdn.anywhere.service.BookService;



@Controller
@RequestMapping("/pos")
public class PosOrderController {

	
	@GetMapping("/posOrder")
		public String getaddBookOrder(Model model) {
		
		model.addAttribute("title", "주문정보입력");
		
		return "/pos/posOrder";
	}
	
}
