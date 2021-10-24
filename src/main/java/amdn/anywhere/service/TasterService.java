package amdn.anywhere.service;

import java.util.ArrayList;
import java.util.Calendar;
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
import amdn.anywhere.domain.TasterCancel;
import amdn.anywhere.mapper.AgeMapper;
import amdn.anywhere.mapper.QuestionsMapper;
import amdn.anywhere.mapper.RecruitTasterByBizMapper;
import amdn.anywhere.mapper.TasterCancelMapper;
import amdn.anywhere.mapper.TasterMapper;

@Service
@Transactional
public class TasterService {
	private TasterMapper tasterMapper;
	private QuestionsMapper questionsMapper;
	private RecruitTasterByBizMapper recruitTasterByBizMapper;
	private AgeMapper ageMapper;
	private TasterCancelMapper tasterCancelMapper;
	
	public TasterService(TasterMapper tasterMapper, QuestionsMapper questionsMapper, RecruitTasterByBizMapper recruitTasterByBizMapper, AgeMapper ageMapper, TasterCancelMapper tasterCancelMapper) {
		this.recruitTasterByBizMapper = recruitTasterByBizMapper;
		this.questionsMapper = questionsMapper;
		this.tasterMapper = tasterMapper;
		this.ageMapper = ageMapper;
		this.tasterCancelMapper = tasterCancelMapper;
	}
	//12 회원별 평가단 취소 횟수 조회
	public int checkCancelTimes(String userId) {
		int result = tasterCancelMapper.checkCancelTimes(userId);
		System.out.println(result);
		return result;
	}
	//11 평가단 취소 처리하기
	public int cancelTaster (Map<String, Object> paramMap) {
		int result = 0;
		//취소 테이블에 등록
		result = tasterCancelMapper.cancelTaster(paramMap);

		return result;
	}
	//10 취소자 명단 가져오기
	public List<TasterCancel> getTasterCancelList(Map<String, Object> paramMap){
		return tasterCancelMapper.getTasterCancelList(paramMap); 
	}
	//9 평가단 생년월일로 나이 추출하기
	public int getAgeFromBirth(String memberBirth) {
		int birthYear = Integer.parseInt(memberBirth.substring(0, 4));
		int nowYear = Calendar.getInstance().get(Calendar.YEAR);
		int age = nowYear - birthYear +1;
		return age;
	}
	//8 평가단 상태 업테이트
	public int updateTaster(Map<String, Object> paramMap) {

		return tasterMapper.updateTaster(paramMap);
	}
	//7 평가단 신청 처리
	public int addTaster(Taster taster) {
		//코드 생성 및 세팅
		String newCode = tasterMapper.createTasterCode();
		taster.setApplyCode(newCode);
		String recruitCode = taster.getRecruitBCode();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("recruitCode", recruitCode);
		String storeCode = recruitTasterByBizMapper.selectRecruitBB(paramMap).get(0).getStoreCode();
		taster.setStoreCode(storeCode);
	
		return tasterMapper.addTaster(taster);
	}
	//6 평가단 목록 가져오기
	public List<Taster> getTasterList(Map<String, Object> paramMap){
		//평가단 목록 가져온후 
		List<Taster> tasterList = tasterMapper.getTasterList(paramMap);
		// 평가단별 모집정보 세팅하기
		Map<String, String> map = new HashMap<String, String>();
		for(int i=0; i < tasterList.size(); i++) {
			String recruitCode = tasterList.get(i).getRecruitBCode();
			map.put("recruitCode", recruitCode);
			RecruitTasterByBiz recruitTasterByBiz= recruitTasterByBizMapper.selectRecruitBB(map).get(0);
			tasterList.get(i).setRecruitTasterByBiz(recruitTasterByBiz);
			map.clear();
		}
		return tasterList;
	}

	//4-1 모집 신청 처리 -모집코드 자동 생성
	public String createRecruitCode() {
		return recruitTasterByBizMapper.createRecruitCode();
	}
	//4 모집 신청 처리 
	public int addRecruit(RecruitTasterByBiz recruitTasterByBiz) {
		int result = 0;
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
		result = recruitTasterByBizMapper.insertRecruit(recruitTasterByBiz);
		return result;
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
	public int updateRecruitBBiz(Map<String, Object> paramMap) {
		return recruitTasterByBizMapper.updateRecruitBBiz(paramMap);
	}
	
	//1. 모집 리스트
	public List<RecruitTasterByBiz> getRecruitBBList(String recruitCode, String bizId, String adminPg){
		Map<String, String> paramMap = new HashMap<String, String>();
		if(recruitCode != null) {
			paramMap.put("recruitCode", recruitCode);
		}
		if(bizId != null) {
			paramMap.put("bizId", bizId);		
		}if(adminPg != null) {
			paramMap.put("admin", adminPg);		
		}
		
		//연령코드 String 을 분할한 다음 연령대명 조회 후 세팅하기
		List<RecruitTasterByBiz> recruitBBList= recruitTasterByBizMapper.selectRecruitBB(paramMap);
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
