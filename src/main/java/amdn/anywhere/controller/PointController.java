package amdn.anywhere.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import amdn.anywhere.domain.Point;
import amdn.anywhere.service.PointService;

@Controller
public class PointController {

	private final PointService pointService;
	
	public PointController(PointService pointService) {
		this.pointService = pointService;
	}
	
	@PostMapping("/point/addPoint")
	public String addPoint(Point point) {
		System.out.println("포인트포인트 : " +point);
		
		//자동증가코드
		String pointCode = pointService.getPointCode();
		
		if(point != null) {			
			point.setPointNum(pointCode);
			pointService.addPoint(point);
		}
		System.out.println(pointCode);
	
		return "redirect:/point/pointList";
	}
	
	//포인트 적립(나중에는 페이지 없이 주문하면 바로 적립되게 하기)
	@GetMapping("/point/addPoint")
	public String addPoint(Model model) {
		
		model.addAttribute("title", "포인트 적립");
		model.addAttribute("location", "포인트 적립");
		
		
		return "/point/addPoint";
	}
	
	//개인별 소멸 포인트 조회
	@GetMapping("/point/userDelPointList")
	public List<Point> userDelPointList(@RequestParam(name = "userId", required = false) String userId
								,Model model) {
		
		List<Point> pointList = pointService.getPointListInfoById(userId);
		
		model.addAttribute("title", "포인트 내역");
		model.addAttribute("location", "포인트 내역");
		model.addAttribute("pointList", pointList);
		
		return pointList;
	}
	
	//개인별 적립 포인트 조회
	@GetMapping("/point/userAddPointList")
	public List<Point> userAddPointList(@RequestParam(name = "userId", required = false) String userId
								,Model model) {
		
		List<Point> pointList = pointService.getPointListInfoById(userId);
		
		model.addAttribute("title", "포인트 내역");
		model.addAttribute("location", "포인트 내역");
		model.addAttribute("pointList", pointList);
		
		return pointList;
	}
	
	//관리자 입장 포인트 소멸 내역 전체 조회
	@GetMapping("/point/pointDelList")
	public String pointDelList(Model model) {
		
		List<Point> point = pointService.getPointList();
		
		model.addAttribute("title", "포인트 내역");
		model.addAttribute("location", "포인트 내역");
		model.addAttribute("point", point);
		System.out.println("point :::::" +point);
		
		return "/point/pointDelList";
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
