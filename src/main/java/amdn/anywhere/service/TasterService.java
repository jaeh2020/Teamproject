package amdn.anywhere.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Age;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.QuestionCate;
import amdn.anywhere.domain.RecruitTasterByBiz;
import amdn.anywhere.domain.Store;
import amdn.anywhere.domain.Taster;
import amdn.anywhere.mapper.AgeMapper;
import amdn.anywhere.mapper.QuestionsMapper;
import amdn.anywhere.mapper.RecruitTasterByBizMapper;
import amdn.anywhere.mapper.TasterMapper;

@Service
@Transactional
public class TasterService {
	private TasterMapper tasterMapper;
	private QuestionsMapper questionsMapper;
	private RecruitTasterByBizMapper recruitTasterByBizMapper;
	private AgeMapper ageMapper;
	
	public TasterService(
				TasterMapper tasterMapper
				, QuestionsMapper questionsMapper
				, RecruitTasterByBizMapper recruitTasterByBizMapper
				, AgeMapper ageMapper) {
		this.recruitTasterByBizMapper = recruitTasterByBizMapper;
		this.questionsMapper = questionsMapper;
		this.tasterMapper = tasterMapper;
		this.ageMapper = ageMapper;
	}
	//8 평가단 상태 업테이트
	public int updateTaster(Map<String, String> paramMap) {
		return tasterMapper.updateTaster(paramMap);
	}
	//7 평가단 신청 처리
	public int addTaster(Taster taster) {
		//코드 생성 및 세팅
		String newCode = tasterMapper.createTasterCode();
		taster.setApplyCode(newCode);
		
		String storeCode = recruitTasterByBizMapper.selectRecruitBB(taster.getRecruitBCode()).get(0).getStoreCode();
		taster.setStoreCode(storeCode);
	
		return tasterMapper.addTaster(taster);
	}
	//6 평가단 목록 가져오기
	public List<Taster> getTasterList(Map<String, Object> paramMap){
		//평가단 목록 가져온후 
		List<Taster> tasterList = tasterMapper.getTasterList(paramMap);
		// 평가단별 모집정보 세팅하기
		for(int i=0; i < tasterList.size(); i++) {
			RecruitTasterByBiz recruitTasterByBiz= recruitTasterByBizMapper.selectRecruitBB(tasterList.get(i).getRecruitBCode()).get(0);
			tasterList.get(i).setRecruitTasterByBiz(recruitTasterByBiz);
		}
		return tasterList;
	}

	//4-1 모집 신청 처리 -모집코드 자동 생성
	public String createRecruitCode() {
		return recruitTasterByBizMapper.createRecruitCode();
	}
	//4 모집 신청 처리 
	public int addRecruit(RecruitTasterByBiz recruitTasterByBiz) {
		//1. 모집코드 자동생성 처리
		String newRecruitCode = createRecruitCode();
		recruitTasterByBiz.setRecruitTBizCode(newRecruitCode);
		//2. 상태코드 세팅
		//recruitTasterByBiz.setStateCode();
		//3. 리스트를 String으로 
		String cateList = String.join(",", recruitTasterByBiz.getCateList());
		String spCateList = String.join(",", recruitTasterByBiz.getSpecialCateList());
		String ageList = String.join(",", recruitTasterByBiz.getAgeCodeList());
		
		recruitTasterByBiz.setStrCateList(cateList);
		recruitTasterByBiz.setStrSpecialCateList(spCateList);
		recruitTasterByBiz.setStrAgeCodeList(ageList);
		
		//4. insert
		recruitTasterByBizMapper.insertRecruit(recruitTasterByBiz);
		return 0;
	}
	// 3-2. 모집신청 폼 - 평가할 메뉴목록 조회
	public List<Menu> getMenuList(String storeCode){	
		return tasterMapper.getMenuList(storeCode);
	}
	
	// 3-1. 모집신청 폼- 매장리스트 조회
	public Map<String, Object> getListForRecruit(String bizId){
		
		List<Store> storeList = tasterMapper.getStoreList(bizId);
		List<QuestionCate> qCateList = questionsMapper.getQuestionCateList();
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("storeList", storeList);
		paramMap.put("qCateList", qCateList);
		
		return paramMap;
	}
	//2. 모집 (상태:state, 조회수:view, 현재모집인원:nowNum) 업데이트
	public int updateRecruitBBiz(Map<String, String> paramMap) {
		return recruitTasterByBizMapper.updateRecruitBBiz(paramMap);
	}
	//1. 모집 리스트
	public List<RecruitTasterByBiz> getRecruitBBList(String recruitCode){
		//연령코드 String 을 분할한 다음 연령대명 조회 후 세팅하기
		List<RecruitTasterByBiz> recruitBBList= recruitTasterByBizMapper.selectRecruitBB(recruitCode);
		if(recruitBBList != null) {
			for(int i=0; i < recruitBBList.size(); i++) {
				String[] ageCodeList = recruitBBList.get(i).getStrAgeCodeList().split(",");
				List<Age> ageList = new ArrayList<Age>();
				for(String ageCode : ageCodeList) {
					ageList.add(ageMapper.getAgeList(ageCode).get(0));					
				}
				recruitBBList.get(i).setAgeList(ageList);
			}
		}
		return recruitBBList;
	}
}
