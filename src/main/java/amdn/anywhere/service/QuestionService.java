package amdn.anywhere.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.QuestionCate;
import amdn.anywhere.domain.Questionnaire;
import amdn.anywhere.mapper.QuestionsMapper;


@Service
@Transactional
public class QuestionService {
	private QuestionsMapper questionMapper;
	
	public QuestionService(QuestionsMapper questionMapper) {
		this.questionMapper =  questionMapper;
	}
	//문항 추가
	public int insertQuestion(Map<String, Object> paramMap) {
		Questionnaire question = new Questionnaire();
		question.setqCateCode((String)paramMap.get("qCateCode"));
		question.setqAddId((String)paramMap.get("addId"));
		List<String> qInsertList = (List<String>) paramMap.get("qInsertList");
		for(int i=0; i < qInsertList.size(); i++) {
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
	
	public List<Questionnaire> getQuestionList(String cateCode){
		List<Questionnaire> questionList =questionMapper.getQuestionList(cateCode);
		
		return questionList;
	}
	
	public List<QuestionCate> getQuestionCateList(){
		List<QuestionCate> qCateList = new ArrayList<QuestionCate>();
		System.out.println("----2--------QuestionCateService ");
		
		qCateList= questionMapper.getQuestionCateList();
		
		return qCateList;
		
	}
	

}
