package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.QuestionChoices;

@Mapper
public interface QuestionChoiceMapper {
	
	public List<QuestionChoices> getQChoices();
}
