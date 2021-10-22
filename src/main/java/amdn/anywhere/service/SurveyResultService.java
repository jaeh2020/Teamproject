package amdn.anywhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Age;
import amdn.anywhere.domain.SurveyResult;
import amdn.anywhere.domain.SurveyStatisticForCate;
import amdn.anywhere.mapper.AgeMapper;
import amdn.anywhere.mapper.QuestionAnswerMapper;
import amdn.anywhere.mapper.TasterMapper;

@Service
@Transactional
public class SurveyResultService {
	private AgeMapper ageMapper;
	private TasterMapper tasterMapper;
	private QuestionAnswerMapper questionAnswerMapper;
	
	public SurveyResultService(AgeMapper ageMapper, TasterMapper tasterMapper, QuestionAnswerMapper questionAnswerMapper) {
		this.ageMapper = ageMapper;
		this.tasterMapper = tasterMapper;
		this.questionAnswerMapper = questionAnswerMapper;
	}
	//3. 항목별 백분율 값 가져오기
	public List<SurveyStatisticForCate> getPercentageForCate(String surveyCode){
		return questionAnswerMapper.getPercentageForCate(surveyCode);
	}
	//2. 설문결과에서 문항별 평균값 구하기
	public List<SurveyResult> getAvgForCate(List<SurveyResult> resultList){

		int sum = 0;
	    for(int i=0; i < resultList.size(); i++) {
	    		sum = resultList.get(i).getChoice1()*1;
	    		sum +=  resultList.get(i).getChoice2()*2;
	    		sum +=  resultList.get(i).getChoice3()*3;
	    		sum +=  resultList.get(i).getChoice4()*4;
	    		sum +=  resultList.get(i).getChoice5()*5;
	    		int avg = Math.round(sum/5);	
	    		resultList.get(i).setAvg(avg);
	    }
		return resultList;
	}
	//1. 설문코드로 연령대 그룹 가져와서 Map 에 세팅
	public Map<String, Object> getTastersAge(String surveyCode){
		List<Integer> tastersAge = tasterMapper.getTastersAge(surveyCode);
		System.out.println(tastersAge + "<<<<<<<tastersAge");
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		int cnt4 = 0;
		int cnt5 = 0;
		for(int i=0; i < tastersAge.size(); i++) {
			int age= tastersAge.get(i);
			if( age >=10 && age <=19 ) {
				cnt1 = cnt1 + 1;
			}else if( age >=20 && age <=29 ) {
				cnt2 = cnt2 + 1;
			}else if(age >=30 && age <=39 ) {
				cnt3 = cnt3 + 1;
			}else if(age >=40 && age <=49 ) {
				cnt4 = cnt4 + 1;
			}else {
				cnt5 = cnt5 + 1;
			}
		}
		System.out.println(cnt1 + cnt2 + cnt3 + cnt4 + cnt5 + "<<<<<<<cnt");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("age10", cnt1);
		paramMap.put("age20", cnt2);
		paramMap.put("age30", cnt3);
		paramMap.put("age40", cnt4);
		paramMap.put("age50", cnt5);
		
		return paramMap;
	}
}
