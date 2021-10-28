package amdn.anywhere.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.Standby;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Store;
import amdn.anywhere.domain.StoreCancel;
import amdn.anywhere.domain.Table;
import amdn.anywhere.domain.Waiting;
import amdn.anywhere.mapper.MainMapper;
import amdn.anywhere.mapper.PosMapper;

@Service
public class PosService {
		
	private final PosMapper posMapper;
	
	@Autowired
	public PosService(PosMapper posMapper) { 
		 this.posMapper = posMapper; 
	}
	
	//table update
	public int modifyPosTable(Map<String, String> paramMap) {
		return posMapper.modifyPosTable(paramMap);
	}
	
	//standby테이블 상태=주문완료, 완료일시
	public int modifyPosStanbyState(Map<String, String> paramMap) {
		return posMapper.modifyPosStanbyState(paramMap);
	}
	
	
	//waiting테이블 입장대기인원 update
	public int modifyWaitingNum(Map<String, String> paramMap) {
		return posMapper.modifyWaitingNum(paramMap);
	}
	
	
	//웨이팅소비자목록조회-standby
	public List<Standby> getPosStandby(String storeCode){
		List<Standby> standbyList = posMapper.getPosStandby(storeCode);
		
		return standbyList;
	}
	
	
	//웨이팅승인시 standby테이블 insert
	public int addPosStandby(Map<String, String> paramMap) {
		return posMapper.addPosStandby(paramMap);
	}
	
	
	//standby코드 자동증가
	public String getNewBookStandbyCode() {
		return posMapper.getNewBookStandbyCode();
	}

	
	//웨이팅현황 조회
	public Waiting getPosWaiting(String storeCode) {
		return posMapper.getPosWaiting(storeCode);
	}
	
	
	//테이블번호.상태 변경시 update
	public int modifyPosTableState(Map<String, String> paramMap) {
		return posMapper.modifyPosTableState(paramMap);
	}
	
	//주문승인.웨이팅승인 버튼 눌렀을시 book테이블 상태 update
	public int modifyPosBookState(Map<String, String> paramMap) {
		return posMapper.modifyPosBookState(paramMap);
	}
	
	
	//주문승인.웨이팅승인 버튼 눌렀을시 order테이블 상태 update
	public int modifyPosOrderState(Map<String, String> paramMap) {
		return posMapper.modifyPosOrderState(paramMap);
	}
	
	
	//나의 테이블번호 조회
	public List<Table> getPosTableList(String storeCode){
		List<Table> posTableList = posMapper.getPosTableList(storeCode);
		
		return posTableList;
	}

	//pos상태목록 가져오기
	public List<Statement> getPosStateList(){
		List<Statement> posStateList = posMapper.getPosStateList();
		
		return posStateList;
	}

	//나의매장 주문pos list조회
	public List<Order> getPosOrderList(Map<String, String> paramMap){
		List<Order> myPosOrderList = posMapper.getPosOrderList(paramMap);
		
		return myPosOrderList;
	}
	
}
