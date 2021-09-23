package amdn.anywhere.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.QuestionCate;
import amdn.anywhere.domain.Questionnaire;
import amdn.anywhere.service.QuestionService;

@Controller
@RequestMapping("/survey")
public class QuestionController{
	private QuestionService questionService;
	
	public QuestionController(QuestionService questionService){
		this.questionService = questionService;
	}
	//7. 항목 삭제버튼
	@GetMapping("/deleteQCate")
	public String deleteQCate(
			@RequestParam(name="cateCode", required = false) String cateCode
			,@RequestParam(name="cateName", required = false) String cateName) {
		System.out.println(cateCode);
		System.out.println(cateName);
		questionService.deleteQCate(cateCode, cateName);
		
		return "redirect:/survey/questionManage";
				
	}
	
	
	//6. 삭제리스트, 추가리스트 있는 문항 삭제/추가하기(미완성)
	@GetMapping("/saveList")
	public String saveQuestion(
			@RequestParam(name="qDeleteList", required = false) List<String> qDeleteList
			,@RequestParam(name="qInsertList", required = false) List<String> qInsertList
			,@RequestParam(name="qCateCode", required = false) String qCateCode
			, HttpSession session
			, Model model) {
		System.out.println(qDeleteList + "<<<<<qDeleteList saveQuestion QuestionController.java");
		System.out.println(qInsertList + "<<<<<qInsertList saveQuestion QuestionController.java");
		System.out.println(qCateCode + "<<<<<qCateCode saveQuestion QuestionController.java");
		//세션 아이디 가정
		session.setAttribute("SID", "id001");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("qInsertList", qInsertList);
		paramMap.put("qCateCode", qCateCode);
		paramMap.put("addId", (String)session.getAttribute("SID"));
		
		questionService.insertQuestion(paramMap);
		questionService.deleteQuestion(qDeleteList);
		
		return "redirect:/survey/questionManage";
	}
	//5. 항목 추가하기
	@PostMapping("/addQCate")
	public String addQCate(
					@RequestParam(name="newCateCode", required = false)String newCateCode
					, @RequestParam(name="newCateName", required = false)String newCateName
					, HttpSession session) {
			
		//세션 아이디 가정
		session.setAttribute("SID", "id001");
		QuestionCate qCate = new QuestionCate();
		qCate.setCateCode(newCateCode);
		qCate.setCateName(newCateName);
		qCate.setCateAddId((String)session.getAttribute("SID"));
		System.out.println(qCate + "<<<<<<<<<<<qCate QuestionController.java");
		questionService.addQCate(qCate); 
		return "redirect:/survey/questionManage";
	}
	
	//4. question List 가져오기 - ajax
	@GetMapping(value="/questionList", produces = "application/json")
	@ResponseBody
	public List<Questionnaire> getQuestionList(
				@RequestParam(name="cateCode", required = false) String cateCode){
		
		List<Questionnaire> questionList = questionService.getQuestionList(cateCode);
		return questionList;
	}
	
	
	//3. select list 가져오기 - ajax
	@GetMapping(value="/selectList", produces = "application/json")
	@ResponseBody
	public List<QuestionCate> getSelectList(){
		List<QuestionCate> selectList = questionService.getQuestionCateList();
		
		return selectList;
	}
	

	//2. 문항 수정 페이지이동
	@GetMapping("/updateQuestions")
	public String updateQuestions(Model model) {
		System.out.println("updateQuestions.QuestionController.java");
		model.addAttribute("title", "설문조사 항목추가");
		return "/survey/updateQuestion";
	}
	//1. 항목 리스트 
	@GetMapping("/questionManage")
	public String getQuestionCate(Model model) {
		System.out.println("----1------QuestionController");
		List<QuestionCate> cateList = questionService.getQuestionCateList();
		System.out.println(cateList + "<<<<<<<<<<<<<<<<<<<cateList"); 
		model.addAttribute("title", "설문조사 항목관리");
		model.addAttribute("location", "항목 관리");
		model.addAttribute("cateList", cateList);
		
		return "/survey/questionManage";
	} 
}

