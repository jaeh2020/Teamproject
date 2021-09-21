package amdn.anywhere.service;

import java.util.ArrayList;
import java.util.List;

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
