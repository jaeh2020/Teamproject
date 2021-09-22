package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.QuestionCate;
import amdn.anywhere.domain.Questionnaire;

@Mapper
public interface QuestionsMapper {
	
	//1 항목리스트
	public List<QuestionCate> getQuestionCateList();  
	//2 문항리스트
	public List<Questionnaire> getQuestionList(String cateCode);
}
