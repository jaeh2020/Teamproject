package amdn.anywhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.MemberBlackList;
import amdn.anywhere.domain.Penalty;
import amdn.anywhere.domain.PenaltyStandard;
import amdn.anywhere.domain.Report;
import amdn.anywhere.mapper.ReportMapper;

@Service
@Transactional
public class ReportService {
	
	 private final ReportMapper reportMapper;
	 
	  @Autowired 
	  public ReportService(ReportMapper reportMapper) { 
		  this.reportMapper = reportMapper;
	 }
	  
	 
	 //블랙리스트코드 자동증가
	 public String getBlackListCode() {
		 return reportMapper.getBlackListCode();
	 }
	  
	  
	 //블랙리스트 가져오기
	 public List<MemberBlackList> getmemberBlackList(){ 
		 List<MemberBlackList> memberBlackList = reportMapper.getmemberBlackList();
		 return memberBlackList;
		 
	 };
	 
	  
	  //ajax 벌점점수가져오기
	  public PenaltyStandard getPenaltyScore(String penCode) {
		  return reportMapper.getPenaltyScore(penCode);
	  };
	  
	  
	  //벌점리스트가져오기
	  public List<PenaltyStandard> getPenaltyStandardList(){
		  List<PenaltyStandard> penaltyStandardList = reportMapper.getPenaltyStandardList();
			return penaltyStandardList;
	  }

	 
	  //기타 벌점 등록
	  public int penaltyInsert(Penalty penalty) {
		  return reportMapper.penaltyInsert(penalty);
	  };

  
	  //벌점 삭제 처리
	  public int penaltyDelete(String penaltyCode) {
		  return reportMapper.penaltyDelete(penaltyCode);
	  };
	  
	 //벌점 목록
	 public List<Penalty> getPenaltyList(){
		List<Penalty> penaltyList = reportMapper.getPenaltyList();
		return penaltyList;
	 };
	 
	 //벌점 등록
	 public int boardPenalty(Penalty penalty) {
		 return reportMapper.boardPenalty(penalty);
	 };

	 //벌점 코드 자동증가
	 public String getNewPenaltyCode() {
		 return reportMapper.getNewPenaltyCode();
	 };
	  
	  //게시판 신고 삭제처리
	  public int reportDelete(String reportCode) {
		  return reportMapper.reportDelete(reportCode);
	  }
	  
	  
	  //게시판 확정 처리
	  public int reportBoardCon(Report report) {
		  return reportMapper.reportBoardCon(report);
	  }
	  
	//게시판 신고 정보 가져오기
	  public Report getReportBoardCode(String reportCode) {
		  return reportMapper.getReportBoardCode(reportCode);
	  }
	  
	  //게시판리뷰목록
	  public List<Report> getReportReviewList(){
		  
		  List<Report> reportReviewList = reportMapper.getReportReviewList();
		  
		  return reportReviewList;
	  }
	  
	  //게시판신고목록
	  public List<Report> getReportBoardList(){
		  
		  List<Report> reportBoardList = reportMapper.getReportBoardList();
		  
		  return reportBoardList;
	  }

}
