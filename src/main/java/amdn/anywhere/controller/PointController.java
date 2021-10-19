package amdn.anywhere.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import amdn.anywhere.domain.Point;
import amdn.anywhere.service.PointService;

@Controller
public class PointController {

	private final PointService pointService;
	
	public PointController(PointService pointService) {
		this.pointService = pointService;
	}
	
	//개인별 포인트 조회
	@GetMapping("/point/userPointList")
	public String userPointList(Model model) {
		
		List<Point> pointList = pointService.getPointList();
		
		model.addAttribute("title", "포인트 내역");
		model.addAttribute("location", "포인트 내역");
		model.addAttribute("pointList", pointList);
		
		
		return "/point/userPointList";
	}
	
	//관리자 입장 포인트 내역 전체 조회
	@GetMapping("/point/pointList")
	public String pointList(Model model) {
		
		List<Point> pointList = pointService.getPointList();
		
		model.addAttribute("title", "포인트 내역");
		model.addAttribute("location", "포인트 내역");
		model.addAttribute("pointList", pointList);

		
		return "/point/pointList";
	}
}
