package amdn.anywhere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.QuestionAnswer;
import amdn.anywhere.domain.SurveyResult;
import amdn.anywhere.domain.SurveyStatisticForCate;

@Mapper
public interface QuestionAnswerMapper {

	public int addQuestionAnswer(List<QuestionAnswer> questionAnswerList);
	
	public List<SurveyResult> getResultForSurvey(Map<String, Object> paramMap); 
	
	//설문 결과 통계 - 설문코드로 항목별 백분율 가져오기
	public List<SurveyStatisticForCate> getPercentageForCate(String surveyCode);
}
