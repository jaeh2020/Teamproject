package amdn.anywhere.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.QuestionCate;
import amdn.anywhere.domain.Questionnaire;
import amdn.anywhere.service.QuestionService;

@Controller
public class QuestionController{
	private QuestionService questionService;
	
	public QuestionController(QuestionService questionCateService){
		this.questionService = questionCateService;
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
	//2. 페이지이동
	@GetMapping("/addQCate")
	public String addQCate(Model model) {
		System.out.println("addQCate.QuestionController.java");
		model.addAttribute("title", "설문조사 항목추가");
		return "question/addCate";
	}
	//1. 항목 리스트 
	@GetMapping("/questionCate")
	public String getQuestionCate(Model model) {
		System.out.println("----1------QuestionController");
		List<QuestionCate> cateList = questionService.getQuestionCateList();
		System.out.println(cateList + "<<<<<<<<<<<<<<<<<<<cateList"); 
		model.addAttribute("title", "설문조사 항목관리");
		model.addAttribute("location", "항목 관리");
		model.addAttribute("cateList", cateList);
		
		return "question/cateInfo";
	} 
}

