package amdn.anywhere.controller;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.NumberOfMember;
import amdn.anywhere.domain.RecruitTasterByBiz;
import amdn.anywhere.domain.Report;
import amdn.anywhere.domain.Store;
import amdn.anywhere.service.StatisticService;
import amdn.anywhere.service.StoreService;
import amdn.anywhere.service.TasterService;

@Controller
public class AdminController {
	private final StoreService storeService;
	private final TasterService tasterService;
	private final StatisticService statisticService;
	public AdminController(TasterService tasterService,StoreService storeService,StatisticService statisticService
						  ) {
		this.storeService = storeService;
		this.tasterService = tasterService;
		this.statisticService = statisticService;
	}
	@GetMapping("/admin")
	public String admin(Model model) {
		
		//1. 평가단 모집 현황
		List<RecruitTasterByBiz> recruitList = tasterService.getRecruitBBList(null, null, "y");
		if(recruitList.size() != 0)	model.addAttribute("tasterRecruit", recruitList);
		
		//2. 입점 매장 리스트
		List<Store> storeList = statisticService.getRecentStoreList();
		if(storeList.size() != 0) model.addAttribute("storeList", storeList);
		
		//3. 최근 게시글 리스트 
		List<Board> boardList = statisticService.getRecentBoardList();
		if(boardList.size() != 0) model.addAttribute("boardList", boardList);
		
		//4. 최근 신고 리스트
		List<Report> reportList = statisticService.getRecentReport();
		if(reportList.size() != 0)  model.addAttribute("reportList", reportList);
		
		//5. 기타 합계들
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		int totalPrice = statisticService.getTotalPrice();
		DecimalFormat df = new DecimalFormat("###,###");
		String strTotalPrice= df.format(totalPrice);
		
		paramMap.put("storeNum", statisticService.getTotalStore());
		paramMap.put("totalPrice", strTotalPrice);
		paramMap.put("orderNum", statisticService.getTotalCountsOfOrder());
		paramMap.put("numOfMember", statisticService.getNumOfMember());

		model.addAttribute("title", "AMDN admin");
		model.addAttribute("location", "관리자 메인페이지");
		model.addAttribute("paramMap", paramMap);
		
		return "/admin";
	}
}
