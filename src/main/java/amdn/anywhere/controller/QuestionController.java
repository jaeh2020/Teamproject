package amdn.anywhere.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.QuestionAnswer;
import amdn.anywhere.domain.QuestionCate;
import amdn.anywhere.domain.Questionnaire;
import amdn.anywhere.domain.RecruitTasterByBiz;
import amdn.anywhere.domain.Store;
import amdn.anywhere.domain.Survey;
import amdn.anywhere.domain.SurveyResult;
import amdn.anywhere.domain.SurveyStatisticForCate;
import amdn.anywhere.domain.Taster;
import amdn.anywhere.service.QuestionService;
import amdn.anywhere.service.StoreService;
import amdn.anywhere.service.SurveyResultService;
import amdn.anywhere.service.TasterService;

@Controller
@RequestMapping("/survey")
public class QuestionController{

	private final TasterService tasterService;
	private final QuestionService questionService;
	private final StoreService storeService;
	private final SurveyResultService surveyResultService;
	
	public QuestionController(QuestionService questionService,TasterService tasterService, StoreService storeService, SurveyResultService surveyResultService){

		this.tasterService = tasterService;
		this.questionService = questionService;
		this.storeService = storeService;
		this.surveyResultService = surveyResultService;
		
	}
	//18. ajax - 항목별 결과 가져오기
	@GetMapping(value="/getChartData", produces = "application/json")
	@ResponseBody
	public List<SurveyResult> getChartData(
			@RequestParam(name="cateCode", required = false) String cateCode
			,@RequestParam(name="surveyCode", required = false) String surveyCode){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("cateCode", cateCode);
		paramMap.put("surveyCode", surveyCode);
		
		List<SurveyResult> resultForCate = questionService.getSurveyResult(paramMap);
		resultForCate = surveyResultService.getAvgForCate(resultForCate);
		return resultForCate ; 
	}
	//17. ajax - 설문코드로 설문결과 가져오기
	@GetMapping(value="/getSurveyResult", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getSurveyResult(@RequestParam(name="surveyCode", required = false) String surveyCode){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("surveyCode", surveyCode);
		List<SurveyResult> surveyResultList= questionService.getSurveyResult(paramMap);
		
		//연령대그룹 가져오기
		paramMap.clear();
		paramMap = surveyResultService.getTastersAge(surveyCode);
		List<SurveyStatisticForCate> percentForCateList= surveyResultService.getPercentageForCate(surveyCode);
		paramMap.put("surveyResult", surveyResultList);
		paramMap.put("percentForCateList", percentForCateList);
		return paramMap;
	}
	
	//16 ajax - 매장코드로 설문목록 가져오기
	@GetMapping(value="/getSurveyList", produces = "application/json")
	@ResponseBody
	public List<Survey> getSurveyList(@RequestParam(name="storeCode", required = false) String storeCode){
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("storeCode", storeCode);
		List<Survey> surveyList= questionService.getSurveyList(paramMap);
		
		return surveyList;
	}
	
	//15. 내설문조사 결과 페이지 이동
	@GetMapping("/surveyResult")
	public String surveyResult(HttpSession session, Model model) {
		String bizId = (String) session.getAttribute("SID");
		Map<String, Object> paramMap = storeService.getMyStoreList(bizId);
		if(paramMap != null) {
			@SuppressWarnings("unchecked")//?
			List<Store> storeList = (List<Store>) paramMap.get("storeList");
			if(storeList != null) {
				model.addAttribute("storeList", storeList);				
			}
		}
		model.addAttribute("title", "설문조사 결과 확인");
		model.addAttribute("location", "설문조사 결과 확인");
		return "/survey/surveyResult";
	}
	//14. 설문조사 제출
	@PostMapping("/doSurvey")
	public String doSurvey(HttpSession session, @RequestParam Map<String, String> paramMap) {
		String id = (String) session.getAttribute("SID");
		String recruitBCode = paramMap.get("recruitCode");
		
		System.out.println(paramMap);
		Set<String> questionSet = paramMap.keySet();
		
		System.out.println(questionSet);
		List<QuestionAnswer> questionAnswerList = new ArrayList<QuestionAnswer>();
		
		//키를 담을 변수 선언: 키 셋 변수
		for(String question : questionSet) {
			
			QuestionAnswer qAnswer = new QuestionAnswer();
			
			if(question.equals("recruitCode")) continue;	
			else if(question.equals("userId")) continue; 
			else {
				
				qAnswer.setQuestionCode(question);
				qAnswer.setTasterChoice(paramMap.get(question));
				qAnswer.setRecruitBCode(paramMap.get("recruitCode"));
				qAnswer.setUserId(id);				
			}
			questionAnswerList.add(qAnswer);
		}
		 Map<String, Object> map = new HashMap<String, Object>();
		//insert처리
		int result = questionService.addQuestionAnswer(questionAnswerList);
		if(result > 0) {
			//평가단 정보 -> 설문 참여완료로 상태 업뎃.
			map.put("userId", id);
			map.put("recruitBCode", recruitBCode);
			map.put("state", "com");
			tasterService.updateTaster(map);
			
			//설문지 정보 -> 참여인원 업뎃.
			questionService.updateServey(recruitBCode);
		}
		return "redirect:/survey/mySurveyList";
	}
	
	//13. 설문조사 참여 화면 이동
	@GetMapping("/doSurvey")
	public String doSurvey(Model model
				,@RequestParam(value="recruitCode", required = false) String recruitCode) {
		
		RecruitTasterByBiz recruitInfo = tasterService.getRecruitBBList(recruitCode, null, null).get(0);
		String[] cateList = recruitInfo.getStrCateList().split(",");
		int length = cateList.length;
		List<Questionnaire> questionList = new ArrayList<Questionnaire>();
	
		for(int i=0; i < length; i++) {
			String qCate = cateList[i];
			if(qCate.equals("all")) continue;
			
			//문항가져오기
			List<Questionnaire> newQList = questionService.getQuestionList(qCate, 'Y'); 
			
			questionList.addAll(newQList);
			
		}

		model.addAttribute("title", "설문조사 참여하기");
		model.addAttribute("location1URL", "/survey/mySurveyList");
		model.addAttribute("location1", "내 설문조사");
		model.addAttribute("location2", "설문조사 참여하기");
		model.addAttribute("recruitInfo", recruitInfo);
		model.addAttribute("questionList", questionList);

		return "/survey/doSurvey";
	}
	//12. 내 설문조사 목록
	@GetMapping("/mySurveyList")
	public String mySurveyList(HttpSession session, Model model) {
		String id = (String) session.getAttribute("SID");
		//세션아이디로 평가단조회
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", id);//소비자 아이디 가정
		paramMap.put("exceptCancel", "Y");//소비자 아이디 가정
		
		List<Taster> myList = tasterService.getTasterList(paramMap);

			model.addAttribute("title", "내 설문조사");
			model.addAttribute("location", "내 설문조사");
			model.addAttribute("myList", myList);
			
		return "/survey/mySurveyList";
	}
	//11. 설문조사 삭제 처리
	@GetMapping("/deleteSurvey")
	public String deleteSurvey(String surveyCode) {
		questionService.deleteSurvey(surveyCode);
		return "redirect:/survey/surveyList";
	}
	//10. 설문조사 관리 페이지 이동
	@GetMapping("/surveyList")
	public String surveyList(Model model) {
		//설문지 생성 목록 가져오기
		List<Survey> surveyList= questionService.getSurveyList(null);
		System.out.println(surveyList);
		model.addAttribute("title", "설문조사 관리");
		model.addAttribute("location", "설문조사 관리");
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
		String id = (String) session.getAttribute("SID");
		qCate.setCateCode(defaultCode + newCateCode);
		qCate.setCateName(newCateName);
		qCate.setCateAddId(id);//관리자 아이디 가정
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
			questionList = questionService.getQuestionList(cateCode, 'N');
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
		model.addAttribute("location1URL", "/survey/questionManage");
		model.addAttribute("location1", "항목 관리");
		model.addAttribute("location2", "문항 관리");
		
		return "/survey/updateQuestion";
	}
	//1. 항목 리스트 
	@GetMapping("/questionManage")
	public String getQuestionCate(Model model) {

		List<QuestionCate> cateList = questionService.getQuestionCateList();

		model.addAttribute("title", "설문조사 항목관리");
		model.addAttribute("location", "항목 관리");
		model.addAttribute("cateList", cateList);
		
		return "/survey/questionManage";
	} 
}

