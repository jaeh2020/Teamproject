package amdn.anywhere.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import amdn.anywhere.domain.Event;
import amdn.anywhere.service.EventService;

@Controller
@RequestMapping("/event")
public class EventController {
	
	private EventService eventService;
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}
	@PostMapping("/addEventProcess")
	public String addEventProcess(
				@RequestParam(value="bannerImg", required = false) MultipartFile bannerImg
				,@RequestParam(value="img", required = false) MultipartFile img, Event event){
		System.out.println(bannerImg.getOriginalFilename());
		System.out.println(img.getOriginalFilename());
		System.out.println(event);
		
		
		return "redirect:/event/eventManage";
	}
	
	//5. 이벤트 등록 페이지
	@GetMapping("/addEvent")
	public String addEvent(Model model) {
		
		model.addAttribute("title", "이벤트 등록");
		model.addAttribute("location1URL", "/event/eventManage");
		model.addAttribute("location1", "이벤트 관리");
		model.addAttribute("location2", "이벤트 등록");
		return "/event/addEvent";
	}
	//4. 이벤트 종료 프로세스
	@GetMapping("/finishEvent")
	public String finishEvent(@RequestParam(value="eventCode", required = false) String eventCode) {
		eventService.finishEvent(eventCode);
		return"redirect:/event/eventManage";
	}
	//3. 이벤트 관리 페이지
	@GetMapping("/eventManage")
	public String eventManage(Model model) {
		List<Event> eventList = eventService.getEventList(null);
		model.addAttribute("title", "이벤트 관리");
		model.addAttribute("location", "이벤트 관리");
		model.addAttribute("eventList", eventList);
		return "/event/eventManage";
	}
	//2. 이벤트 상세보기 페이지
	@GetMapping("/eventDetail")
	public String eventDetail(Model model,
			@RequestParam(value="eventCode", required = false) String eventCode) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("eventCode", eventCode);
		List<Event> eventList= eventService.getEventList(paramMap);
		Event event= eventList.get(0);
		model.addAttribute("title", "이벤트 상세보기");
		model.addAttribute("location1URL", "/event/eventList");
		model.addAttribute("location1", "이벤트 목록");
		model.addAttribute("location2", "이벤트 상세보기");
		model.addAttribute("event", event);
		return "/event/eventDetail";
	}
	//1. 이벤트 목록 페이지
	@GetMapping("/eventList")
	public String eventList(Model model) {
		List<Event> eventList = eventService.getEventList(null);
		model.addAttribute("title", "이벤트 목록");
		model.addAttribute("location", "이벤트 목록");
		model.addAttribute("eventList", eventList);
		return "/event/eventList";
	}
}
