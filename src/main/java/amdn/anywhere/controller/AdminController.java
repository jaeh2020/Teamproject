package amdn.anywhere.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import amdn.anywhere.domain.RecruitTasterByBiz;
import amdn.anywhere.domain.Store;
import amdn.anywhere.service.StatisticService;
import amdn.anywhere.service.StoreService;
import amdn.anywhere.service.TasterService;

@Controller
public class AdminController {
	private StoreService storeService;
	private TasterService tasterService;
	private StatisticService statisticService;
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
		if(recruitList.size() != 0) {
			model.addAttribute("tasterRecruit", recruitList);
		}
		//2. 입점 매장 리스트
		List<Store> storeList = statisticService.getRecentStoreList();
		if(storeList.size() != 0) {
			model.addAttribute("storeList", storeList);
		}
		//기타
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("storeNum", statisticService.getTotalStore());
		
		model.addAttribute("title", "AMDN admin");
		model.addAttribute("location", "관리자 메인페이지");
		model.addAttribute("paramMap", paramMap);
		
		return "/admin";
	}
}
