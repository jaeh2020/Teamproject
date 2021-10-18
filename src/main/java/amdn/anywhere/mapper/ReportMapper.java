package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Penalty;
import amdn.anywhere.domain.PenaltyStandard;
import amdn.anywhere.domain.Report;

@Mapper
public interface ReportMapper {
	
	//기타 벌점 등록
	public int penaltyInsert(Penalty penalty);
	
	//벌점점수가져오기
	public PenaltyStandard getPenaltyScore(String penaltyStandard);
	
	//벌점 삭제 처리
	public int penaltyDelete(String penaltyCode);
	
	//벌점 목록
	public List<Penalty> getPenaltyList();

	//벌점 등록
	public int boardPenalty(Penalty penalty);
	
	//벌점 코드 자동증가
	public String getNewPenaltyCode();
	
	//게시판 신고 삭제 처리
	 public int reportDelete(String reportCode);
	
	//게시판 확정 처리
	public int reportBoardCon(Report report);
	
	//게시판 신고 정보 가져오기
	public Report getReportBoardCode(String reportCode);
	
	//게시판신고목록
	public List<Report> getReportBoardList();
	
}
