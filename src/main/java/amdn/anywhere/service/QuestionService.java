package amdn.anywhere.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.QuestionAnswer;
import amdn.anywhere.domain.QuestionCate;
import amdn.anywhere.domain.QuestionChoices;
import amdn.anywhere.domain.Questionnaire;
import amdn.anywhere.domain.RecruitTasterByBiz;
import amdn.anywhere.domain.Survey;
import amdn.anywhere.mapper.QuestionAnswerMapper;
import amdn.anywhere.mapper.QuestionChoiceMapper;
import amdn.anywhere.mapper.QuestionsMapper;
import amdn.anywhere.mapper.RecruitTasterByBizMapper;
import amdn.anywhere.mapper.SurveyMapper;


@Service
@Transactional
public class QuestionService {
	private QuestionsMapper questionMapper;
	private SurveyMapper surveyMapper;
	private RecruitTasterByBizMapper recruitTasterByBizMapper;
	private QuestionChoiceMapper questionChoiceMapper;
	private QuestionAnswerMapper questionAnswerMapper;
	
	public QuestionService(
			QuestionsMapper questionMapper
			, SurveyMapper surveyMapper
			, RecruitTasterByBizMapper recruitTasterByBizMapper
			, QuestionChoiceMapper questionChoiceMapper
			, QuestionAnswerMapper questionAnswerMapper) {
		this.recruitTasterByBizMapper = recruitTasterByBizMapper; 
		this.questionMapper =  questionMapper;
		this.surveyMapper = surveyMapper;
		this.questionChoiceMapper = questionChoiceMapper;
		this.questionAnswerMapper = questionAnswerMapper;
	}
	//설문조사 참여인원 추가
	public int updateServey (String recruitCode) {
		return surveyMapper.updateSurvey(recruitCode);
	}
	//설문조사 답 등록하기
	 public int addQuestionAnswer(List<QuestionAnswer> questionAnswerList) {
		 int result = 0;
		  result = questionAnswerMapper.addQuestionAnswer(questionAnswerList);
		  
		 return result;
	 }
	
	//설문조사 삭제
	public int deleteSurvey(String surveyCode) {
		return surveyMapper.deleteSurvey(surveyCode);
	}
	//설문조사 등록
	public int addSurvey(String recruitCode) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("recruitCode", recruitCode);
		List<RecruitTasterByBiz> recruitList =recruitTasterByBizMapper.selectRecruitBB(paramMap);
		Survey newSurvey = new Survey();
		if(recruitList.get(0) != null) {
			RecruitTasterByBiz recruitInfo = recruitList.get(0);
			// 자동 코드 생성
			String newSurveyCode= surveyMapper.createSurveyCode();
			//새 설문조사에 정보 세팅
			newSurvey.setCreateCode(newSurveyCode);
			newSurvey.setStoreCode(recruitInfo.getStoreCode());
			newSurvey.setRecruitBBCode(recruitCode);
		}
		return surveyMapper.addSurvey(newSurvey);
	}
	//설문조사 목록 조회
	public List<Survey> getSurveyList(String recruitCode){
		return surveyMapper.getSurveyList(recruitCode);
	}
	
	//하나의 항목 조회
	public QuestionCate selectQCate(String cateCode) {
		return questionMapper.selectQCate(cateCode);
	}
	//항목 수정
	public int modifyQCate(Map<String, Object> paramMap) {
		return questionMapper.modifyQCate(paramMap);
	}
	
	//항목 삭제
	public int deleteQCate(String cateCode, String cateName) {
		//1.먼저 문항이 있는지 조회 후 있으면 문항 먼저 싹 삭제한다.
		List<Questionnaire> questionList = questionMapper.getQuestionList(cateCode);
		if(questionList.size() > 0) {
			for(int i = 0; i < questionList.size(); i++) {
				String qCode = questionList.get(i).getqCode();
				questionMapper.deleteQuestion(qCode);
			}
		}
		questionMapper.deleteQCate(cateCode);
		return 0; 
	}
	
	//문항 추가
	public int addQuestion(Map<String, Object> paramMap) {
		String cateCode = (String)paramMap.get("qCateCode");
		Questionnaire question = new Questionnaire();
		question.setqCateCode(cateCode);
		question.setqAddId((String)paramMap.get("addId"));
		List<String> qInsertList = (List<String>) paramMap.get("qInsertList");
		
		for(int i=0; i < qInsertList.size(); i++) {
			//문항코드 생성하기 항목 카테코드 필요.
			String newQcode = questionMapper.createQCode(cateCode);
			question.setqCode(newQcode);
			question.setqContent(qInsertList.get(i));
			questionMapper.insertQuestion(question);
		}
		return 0;
	}
	
	//문항삭제
	public int deleteQuestion(List<String> qDeleteList) {
		int result=0;
		
		for(int i=0; i< qDeleteList.size(); i++) {
			String qCode =qDeleteList.get(i);
			questionMapper.deleteQuestion(qCode);
			
		}
		result = 1;
		return result;
	}
	public int addQCate(QuestionCate qCate) {
		return questionMapper.addQCate(qCate);
	}
	
	public List<Questionnaire> getQuestionList(String cateCode, char getChoices){
		// 항목코드에 문자열 합치기
		if(cateCode.indexOf("q_cate_") == -1) {
			cateCode = "q_cate_" + cateCode;
		}
		//항목코드로 문항목록 가져오기
		List<Questionnaire> questionList =questionMapper.getQuestionList(cateCode);
		
		//선택지 정보 필요할 경우 가져와서 세팅하기
		if(getChoices == 'Y') {
			List<QuestionChoices> questionChoices = questionChoiceMapper.getQChoices();
			for(int i=0; i<questionList.size(); i++) {
				questionList.get(i).setQuestionChoices(questionChoices);
			}
		}
		return questionList;
	}
	
	public List<QuestionCate> getQuestionCateList(){
		List<QuestionCate> qCateList = new ArrayList<QuestionCate>();
		System.out.println("----2--------QuestionCateService ");
		
		qCateList= questionMapper.getQuestionCateList();
		
		return qCateList;
		
	}
	

}
