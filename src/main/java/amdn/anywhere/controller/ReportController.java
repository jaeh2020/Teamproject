
package amdn.anywhere.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.MemberBlackList;
import amdn.anywhere.domain.Penalty;
import amdn.anywhere.domain.PenaltyStandard;
import amdn.anywhere.domain.Report;
import amdn.anywhere.service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController {

	
	 private final ReportService reportService;
	 
	 public ReportController(ReportService reportService) { 
		 this.reportService = reportService; 
		 }
	 
	 
	 
	 
	 //블랙리스트 목록
	@GetMapping("/memberBlackList")
	public String memberBlackList(Model model) {
		
		 List<MemberBlackList> memberBlackList = reportService.getmemberBlackList(); 
		

		model.addAttribute("title", "블랙리스트 목록");
		model.addAttribute("location", "블랙리스트 목록");
		model.addAttribute("memberBlackList", memberBlackList);
		

		return "/report/memberBlackList";
	}
	
	
	 //벌점유형선택하여 점수 불러오기 ajax
	@GetMapping(value="/penaltyScore", produces = "application/json")
	@ResponseBody
	public PenaltyStandard getPenaltyStandardList(
				@RequestParam(name="penaltyStandard", required = false) String penaltyStandard){		
		
		return reportService.getPenaltyScore(penaltyStandard);
	}

	 //추가벌점등록처리
	@PostMapping("/penaltyInsert")
	public String penaltyInsert(Penalty penalty
			                   ,@RequestParam(name = "penaltyStandard" , required = false) String penaltyStandard
							  ) {
		
		System.out.println("penalty" + penalty);
		
		
		if (penalty != null) {
			penalty.setPenaltyCode(reportService.getNewPenaltyCode());
			reportService.getPenaltyScore(penaltyStandard);
			reportService.penaltyInsert(penalty);
		}
		
		return "redirect:/report/penaltyList";
	}
	 
	  
	 //추가벌점등록
	 @GetMapping("/penaltyInsert")
	 public String penaltyInsert(Model model
			 					,HttpSession session
			 					) {
		 
		//벌점 등록자 아이디 가져오기
		String memberId = (String)session.getAttribute("SID");
		
		
		//벌점목록가져오기
		List<PenaltyStandard> penaltyStandardList = reportService.getPenaltyStandardList();
		
		
		 model.addAttribute("title", "벌점 등록");
		 model.addAttribute("location", "벌점 등록");
		 model.addAttribute("memberId", memberId);
		 model.addAttribute("penaltyStandardList", penaltyStandardList);
		
		 return "/report/penaltyInsert";
	 }
	 
	 
	 
	 //벌점 삭제 처리
	 @GetMapping("/penaltyDelete")
	 public String penaltyDelete(Penalty penalty
			 					, @RequestParam(name = "penaltyCode" , required = false) String penaltyCode) {
		 
		 System.out.println("penalty" + penalty);
		 
		 reportService.penaltyDelete(penaltyCode);
		 
		 return "redirect:/report/penaltyList";
	 }
 		
	
	 
	 //벌점 목록
		@GetMapping("/penaltyList")
		public String penaltyList(Model model) {
			
		List<Penalty> penaltyList = reportService.getPenaltyList();

			model.addAttribute("title", "벌점 목록");
			model.addAttribute("location", "벌점 목록");
			model.addAttribute("penaltyList", penaltyList);
			

			return "/report/penaltyList";
		}
	
	 
	 //벌점 부과 폼 작성처리
		@PostMapping("/penaltyAdd")
		public String penaltyAdd(Penalty penalty
				) {
			
			System.out.println("penalty" + penalty);
			
			
			if (penalty != null) {
				penalty.setPenaltyCode(reportService.getNewPenaltyCode());
				reportService.boardPenalty(penalty);
			}
			
			return "redirect:/report/reportBoardList";
		}
	 
	 //벌점 부과 폼 작성
	@GetMapping("/penaltyAdd")
	public String penaltyAdd(Model model
							,HttpSession session
							,@RequestParam(name = "reportCode" , required = false)String reportCode
							,@RequestParam(name = "boardNum" , required = false)String boardNum) {
		
			//벌점 부여자 아이디 가져오기
			String memberId = (String)session.getAttribute("SID");
			//신고 코드 가져오기
			Report getReportCode = reportService.getReportBoardCode(reportCode);
			
		
			model.addAttribute("title", "벌점 부과");
			model.addAttribute("memberId", memberId);
			model.addAttribute("getReportCode", getReportCode);
			
			
			
			return "report/penaltyAdd";
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
