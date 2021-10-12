package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.QuestionAnswer;

@Mapper
public interface QuestionAnswerMapper {

	public int addQuestionAnswer(QuestionAnswer questionAnswerList);
	
}
