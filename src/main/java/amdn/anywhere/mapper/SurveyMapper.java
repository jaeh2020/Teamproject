package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Survey;

@Mapper
public interface SurveyMapper {
	//1. 설문조사 목록 조회
	public List<Survey> getSurveyList(String recruitCode);
	//2.설문조사 코드 자동생성
	public String createSurveyCode();
	//3. 설문조사 등록
	public int addSurvey(Survey surveyInfo);
	//4. 설문조사 삭제
	public int deleteSurvey(String surveyCode);
	//5. 설문조사 참여인원 업뎃
	public int updateSurvey(String recruitCode);
	
}
