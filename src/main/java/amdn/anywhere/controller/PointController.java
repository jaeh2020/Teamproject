package amdn.anywhere.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import amdn.anywhere.domain.MemberUser;
import amdn.anywhere.domain.Message;
import amdn.anywhere.domain.Point;
import amdn.anywhere.domain.PointDel;
import amdn.anywhere.service.MemberService;
import amdn.anywhere.service.MessageService;
import amdn.anywhere.service.PointService;

@Controller
public class PointController {

	private final PointService pointService;
	private final MessageService messageService;
	private final MemberService memberService;

	public PointController(PointService pointService, MessageService messageService, MemberService memberService) {
		this.pointService = pointService;
		this.messageService = messageService;
		this.memberService = memberService;
	}

	//포인트 소멸
	@PostMapping("/point/addPointDel")
	public String addPointDel(Point point, PointDel pointDel, Message message, MemberUser memberUser) {
		System.out.println("포인트포인트 : " + point);
	
		//자동증가코드
		String pointDelCode = pointService.getPointDelCode();
		String messageCode = messageService.getMessageCode();

		
		//오늘 날짜 String으로 변경하기
		LocalDate date = LocalDate.now(); //오늘 날짜 LocalDate 객체 생성
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String today = date.format(dateTimeFormatter); //LocalDate 객체를 String 객체로 바꿈
		
		// 결과 출력 
		System.out.println(today+"현재시간");
		System.out.println(pointService.pointDelTime(point.getUserId())+"testt");
		System.out.println(pointService.pointDelTime(point.getUserId()).equals(today)+"뭐니!!");
		
		//오늘 날짜랑 소멸날짜가 같으면 소멸테이블에 입력
		if(pointService.pointDelTime(point.getUserId()).equals(today) == true) {
			
			pointDel.setPointDelNum(pointDelCode);
			pointDel.setUserId(point.getUserId());
			pointDel.setPointNum(point.getPointNum());
			pointDel.setPointDelTime(point.getPredDelTime());
			//pointService.addPointDel(pointDel);
			
			//소멸 메시지 발송!!!
			message.setMessageNum(messageCode);
			message.setMemberId(point.getUserId());
			message.setMessageCode("msg_point_delete");
			messageService.addMessage(message);
			
			//user테이블 포인트 업데이트!!!
			memberUser.setUserId(point.getUserId());
			memberService.modifyPointDel(memberUser);
		}
		

		return "redirect:/point/pointDelList";
	}

	// 포인트 소멸(나중에는 페이지 없이 주문하면 바로 적립되게 하기)
	@GetMapping("/point/addPointDel")
	public String addDelPoint(Model model) {

		model.addAttribute("title", "포인트 적립");
		model.addAttribute("location", "포인트 적립");

		return "/point/addPointDel";
	}

	@PostMapping("/point/addPoint")
	public String addPoint(Point point, Message message, PointDel pointDel, MemberUser memberUser) {
		System.out.println("포인트포인트 : " + point);

		// 자동증가코드
		String pointCode = pointService.getPointCode();
		String messageCode = messageService.getMessageCode();
		
		//포인트 적립 + 메세지 전송
		point.setPointNum(pointCode);
		pointService.addPoint(point);
		
		//메시지 전송
		message.setMessageNum(messageCode);
		message.setMemberId(point.getUserId());
		message.setMessageCode("msg_point_collect");
		messageService.addMessage(message);
			
		//user테이블 포인트 업데이트!!!
		memberUser.setUserId(point.getUserId());
		memberService.modifyPoint(memberUser);
		
		return "redirect:/point/pointList";
	}

	// 포인트 적립(나중에는 페이지 없이 주문하면 바로 적립되게 하기)
	@GetMapping("/point/addPoint")
	public String addPoint(Model model) {

		model.addAttribute("title", "포인트 적립");
		model.addAttribute("location", "포인트 적립");

		return "/point/addPoint";
	}

	// 개인별 소멸 포인트 조회
	@GetMapping("/point/userDelPointList")
	public List<Point> userDelPointList(@RequestParam(name = "userId", required = false) String userId, Model model) {

		List<Point> pointList = pointService.getPointListInfoById(userId);

		model.addAttribute("title", "포인트 내역");
		model.addAttribute("location", "포인트 내역");
		model.addAttribute("pointList", pointList);

		return pointList;
	}

	// 개인별 적립 포인트 조회
	@GetMapping("/point/userAddPointList")
	public List<Point> userAddPointList(@RequestParam(name = "userId", required = false) String userId, Model model) {

		List<Point> pointList = pointService.getPointListInfoById(userId);

		model.addAttribute("title", "포인트 내역");
		model.addAttribute("location", "포인트 내역");
		model.addAttribute("pointList", pointList);

		return pointList;
	}

	// 관리자 입장 포인트 소멸 내역 전체 조회
	@GetMapping("/point/pointDelList")
	public String pointDelList(Model model) {

		List<Point> point = pointService.getPointList();

		model.addAttribute("title", "포인트 내역");
		model.addAttribute("location", "포인트 내역");
		model.addAttribute("point", point);
		System.out.println("point :::::" + point);

		return "/point/pointDelList";
	}

	// 관리자 입장 포인트 내역 전체 조회
	@GetMapping("/point/pointList")
	public String pointList(Model model) {

		List<Point> pointList = pointService.getPointList();

		model.addAttribute("title", "포인트 내역");
		model.addAttribute("location", "포인트 내역");
		model.addAttribute("pointList", pointList);

		return "/point/pointList";
	}
}
