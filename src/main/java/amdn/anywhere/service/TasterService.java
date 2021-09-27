package amdn.anywhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.QuestionCate;
import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.QuestionsMapper;
import amdn.anywhere.mapper.TasterMapper;

@Service
@Transactional
public class TasterService {
	private TasterMapper tasterMapper;
	private QuestionsMapper questionsMapper;
	
	public TasterService(TasterMapper tasterMapper, QuestionsMapper questionsMapper) {
		this.questionsMapper = questionsMapper;
		this.tasterMapper = tasterMapper;
	}
	// 1. 모집신청- 매장리스트 조회
	public Map<String, Object> getListForRecruit(String bizId){
		
		List<Store> storeList = tasterMapper.getStoreList(bizId);
		List<QuestionCate> qCateList = questionsMapper.getQuestionCateList();
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("storeList", storeList);
		paramMap.put("qCateList", qCateList);
		
		return paramMap;
	}
}
