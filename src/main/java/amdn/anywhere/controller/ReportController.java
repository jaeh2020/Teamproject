
package amdn.anywhere.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import amdn.anywhere.domain.Report;
import amdn.anywhere.service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController {

	
	 private final ReportService reportService;
	 
	 public ReportController(ReportService reportService) { 
		 this.reportService = reportService; 
		 }
	 
	
	 //게시판 삭제 처리
	 @GetMapping("/reportDelete")
	 public String reportDelete(Report report
			 					, @RequestParam(name = "reportCode" , required = false) String reportCode) {
		 
		 System.out.println("report" + report);
		 
		 reportService.reportDelete(reportCode);
		 
		 return "redirect:/report/reportBoardList";
	 }
	
	 
	 
	 //게시판 확정 처리
	 @PostMapping("/reportBoardCom")
	 public String reportBoardCom(Report report) {
		
		System.out.println("report +" + report);
		
		reportService.reportBoardCon(report);
		
		return "redirect:/report/reportBoardList";
	}
	 
	 
	 
	 //게시판 신고 확정
	@GetMapping("/reportBoardCom")
	public String reportBoardCom(Model model
								,HttpSession session
								,@RequestParam(name = "reportCode" , required = false) String reportCode) {
		
		//신고확정자 아이디 가져오기
		String memberId = (String)session.getAttribute("SID");
		//신고 게시물 조회 
		Report report = reportService.getReportBoardCode(reportCode);
		
		model.addAttribute("title", "게시판 신고 확정");
		model.addAttribute("location", "게시판 신고 목록");
		model.addAttribute("memberId", memberId);
		model.addAttribute("report", report);
	
		
		return "report/reportBoardCom";
	}
	 
	//게시판 신고 목록
	@GetMapping("/reportBoardList")
	public String reportBoardList(Model model) {
		
		List<Report> reportBoardList = reportService.getReportBoardList();

		model.addAttribute("title", "게시판 신고 목록");
		model.addAttribute("location", "게시판 신고 목록");
		model.addAttribute("reportBoardList", reportBoardList);

		return "/report/reportBoardList";
	}

}
