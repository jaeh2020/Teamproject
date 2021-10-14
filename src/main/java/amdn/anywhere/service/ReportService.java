package amdn.anywhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	  
	  //게시판신고목록
	  public List<Report> getReportBoardList(){
		  
		  List<Report> reportBoardList = reportMapper.getReportBoardList();
		  
		  return reportBoardList;
	  }

}
