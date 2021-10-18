package amdn.anywhere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.QuestionAnswer;
import amdn.anywhere.domain.SurveyResult;

@Mapper
public interface QuestionAnswerMapper {

	public int addQuestionAnswer(List<QuestionAnswer> questionAnswerList);
	
	public List<SurveyResult> getResultForSurvey(Map<String, Object> paramMap); 
}
