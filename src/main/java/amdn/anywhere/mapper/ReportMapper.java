package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Report;

@Mapper
public interface ReportMapper {
	
	//게시판 신고
	 public int reportDelete(String reportCode);
	
	//게시판 확정 처리
	public int reportBoardCon(Report report);
	
	//게시판 신고 정보 가져오기
	public Report getReportBoardCode(String reportCode);
	
	//게시판신고목록
	public List<Report> getReportBoardList();
	
}
