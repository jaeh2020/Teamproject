package amdn.anywhere.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.QuestionCate;
import amdn.anywhere.domain.Questionnaire;
import amdn.anywhere.domain.Survey;
import amdn.anywhere.service.QuestionService;

@Controller
@RequestMapping("/survey")
public class QuestionController{
	private QuestionService questionService;
	
	public QuestionController(QuestionService questionService){
		this.questionService = questionService;
	}
	//11. 설문조사 삭제 처리
	@GetMapping("/deleteSurvey")
	public String deleteSurvey(String surveyCode) {
		questionService.deleteSurvey(surveyCode);
		return "redirect:/survey/surveyList";
	}
	//10. 설문조사 현황 페이지 이동
	@GetMapping("/surveyList")
	public String surveyList(Model model) {
		//설문지 생성 목록 가져오기
		List<Survey> surveyList= questionService.getSurveyList(null);
		System.out.println(surveyList);
		model.addAttribute("title", "설문조사 현황");
		model.addAttribute("location", "설문조사 현황");
		model.addAttribute("surveyList", surveyList);
		return "/survey/surveyList";
	}
	//9.항목코드 중복 검사
	@GetMapping(value="/checkCateCode" , produces = "application/json")
	@ResponseBody
	public boolean checkCateCode(
			 @RequestParam(value="checkCateCode", required = false) String cateCode) {
		
		boolean result = false;
		QuestionCate qCate = null;
		qCate = questionService.selectQCate("q_cate_" + cateCode);
		System.out.println(qCate + "<<<<<<<<<<<<<<<<<<<<<qCate");
		if(qCate == null) {
			result = true;
		}
		return result;
	}
	//8. 항목 수정버튼
	@GetMapping(value="/modifyCate", produces = "application/json")
	@ResponseBody
	public int modifyCate(
			 @RequestParam(value="oldCode", required = false) String oldCode
		    ,@RequestParam(value="newCode", required = false) String newCode
			,@RequestParam(value="newName", required = false) String newName
			,HttpSession session){
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("oldCode", oldCode);
		paramMap.put("newCode", newCode);
		paramMap.put("newName", newName);
		paramMap.put("updateId", session.getAttribute("SID"));
		questionService.modifyQCate(paramMap);
		
		return 0;
	}
	//7. 항목 삭제버튼
	@GetMapping("/deleteQCate")
	public String deleteQCate(
			 @RequestParam(name="cateCode", required = false) String cateCode
			,@RequestParam(name="cateName", required = false) String cateName) {
		
		questionService.deleteQCate(cateCode, cateName);
		
		return "redirect:/survey/questionManage";
				
	}
	
	
	//6. 삭제리스트, 추가리스트 있는 문항 삭제/추가하기(미완성)
	@GetMapping("/saveList")
	public String saveQuestion(
			  @RequestParam(name="qDeleteList", required = false) List<String> qDeleteList
			, @RequestParam(name="qInsertList", required = false) List<String> qInsertList
			, @RequestParam(name="qCateCode", required = false) String qCateCode
			, HttpSession session
			, Model model) {
		
		if(qDeleteList.isEmpty() && qInsertList.isEmpty()) {
			return "redirect:/survey/updateQuestion";
			
		}else {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("qInsertList", qInsertList);
			paramMap.put("qCateCode", qCateCode);
			paramMap.put("addId", (String)session.getAttribute("SID"));
			
			questionService.addQuestion(paramMap);
			questionService.deleteQuestion(qDeleteList);
			
			return "redirect:/survey/updateQuestion";
		}
	}
	//5. 항목 추가하기
	@PostMapping("/addQCate")
	public String addQCate(
				      @RequestParam(name="newCateCode", required = false)String newCateCode
					, @RequestParam(name="newCateName", required = false)String newCateName
					, @RequestParam(name="defaultCode", required = false)String defaultCode
					, HttpSession session) {
			
		QuestionCate qCate = new QuestionCate();
		qCate.setCateCode(defaultCode + newCateCode);
		qCate.setCateName(newCateName);
		qCate.setCateAddId("id001");//관리자 아이디 가정
		questionService.addQCate(qCate); 
		return "redirect:/survey/questionManage";
	}
	
	//4. question List 가져오기 - ajax
	@GetMapping(value="/questionList", produces = "application/json")
	@ResponseBody
	public List<Questionnaire> getQuestionList(
				@RequestParam(name="cateCode", required = false) String cateCode){
		
		List<Questionnaire> questionList = null;
		if(cateCode != null) {
			questionList = questionService.getQuestionList(cateCode);
		}
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
	@GetMapping("/updateQuestion")
	public String updateQuestions(Model model) {
		
		model.addAttribute("title", "설문조사 항목별 문항관리");
		model.addAttribute("location1URL", "questionManage");
		model.addAttribute("location1", "항목 관리");
		model.addAttribute("location2", "문항 관리");
		
		return "/survey/updateQuestion";
	}
	//1. 항목 리스트 
	@GetMapping("/questionManage")
	public String getQuestionCate(Model model) {

		List<QuestionCate> cateList = questionService.getQuestionCateList();

		model.addAttribute("title", "설문조사 항목관리");
		model.addAttribute("location2", "항목 관리");
		model.addAttribute("cateList", cateList);
		
		return "/survey/questionManage";
	} 
}

