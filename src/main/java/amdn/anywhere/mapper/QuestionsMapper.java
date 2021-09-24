package amdn.anywhere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.QuestionCate;
import amdn.anywhere.domain.Questionnaire;

@Mapper
public interface QuestionsMapper {
	
	//1 항목리스트
	public List<QuestionCate> getQuestionCateList();  
	//2 문항리스트
	public List<Questionnaire> getQuestionList(String cateCode);
	//3 항목 추가
	public int addQCate(QuestionCate qCate);
	//4 문항 삭제
	public int deleteQuestion(String qCode);
	//5 문항 추가
	public int insertQuestion(Questionnaire question);
	//6 항목 삭제
	public int deleteQCate(String cateCode);
	//7 항목 수정
	public int modifyQCate(Map<String, Object> paramMap);
	//8 수정한 항목코드, 항목명 가져오기
	public QuestionCate selectQCate(String cateCode);
}
