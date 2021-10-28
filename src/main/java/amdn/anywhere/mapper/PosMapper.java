package amdn.anywhere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Order;
import amdn.anywhere.domain.Standby;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Table;
import amdn.anywhere.domain.Waiting;

@Mapper
public interface PosMapper {
	
	//table상태 update
	public int modifyPosTable(Map<String, String> paramMap);
	
	//standby테이블 상태=주문완료, 완료일시
	public int modifyPosStanbyState(Map<String, String> paramMap);
	
	//waiting테이블 입장대기인원 update
	public int modifyWaitingNum(Map<String, String> paramMap);
	
	//웨이팅소비자목록조회-standby
	public List<Standby> getPosStandby(String storeCode);
	
	//웨이팅승인시 standby테이블 insert
	public int addPosStandby(Map<String, String> paramMap);
	
	//standby테이블 자동증가
	public String getNewBookStandbyCode();
	
	//웨이팅현황 조회
	public Waiting getPosWaiting(String storeCode);
	
	//테이블번호변경.상태 변경시 update
	public int modifyPosTableState(Map<String, String> paramMap);
	
	//주문승인.웨이팅승인 버튼 클릭시 book테이블 상태 변경
	public int modifyPosBookState(Map<String, String> paramMap);
	
	//주문승인.웨이팅승인 버튼 클릭시 order테이블 상태 변경
	public int modifyPosOrderState(Map<String, String> paramMap);
	
	//나의매장 테이블번호 조회
	public List<Table> getPosTableList(String storeCode);
	
	//pos상태목록 가져오기
	public List<Statement> getPosStateList();

	//나의매장 주문pos list조회
	public List<Order> getPosOrderList(Map<String, String> paramMap);


}
