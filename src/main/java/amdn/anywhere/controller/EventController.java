package amdn.anywhere.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import amdn.anywhere.domain.Event;
import amdn.anywhere.domain.FileDto;
import amdn.anywhere.service.EventService;

@Controller
@RequestMapping("/event")
public class EventController {
	
	private EventService eventService;
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}
	//6. 이벤트 등록 프로세스
	@PostMapping("/addEventProcess")
	public String addEventProcess(Model model,
				@RequestParam(value="bannerImg", required = false) MultipartFile bannerImg
				,@RequestParam(value="img", required = false) MultipartFile img, Event event) throws IllegalStateException, IOException{
		System.out.println(bannerImg.getOriginalFilename());
		System.out.println(img.getOriginalFilename());
		System.out.println(event);
		
		List<FileDto> fileList = new ArrayList<FileDto>();
		FileDto dto1 = new FileDto( UUID.randomUUID().toString()
									, bannerImg.getOriginalFilename()
									, bannerImg.getContentType());
		FileDto dto2 = new FileDto( UUID.randomUUID().toString()
									, img.getOriginalFilename()
									, img.getContentType());
		fileList.add(dto1);
		fileList.add(dto2);
		
		File newFileName1 = new File(dto1.getFileId() + "_" + dto1.getFileName()); 
		File newFileName2 = new File(dto2.getFileId() + "_" + dto2.getFileName());
		bannerImg.transferTo(newFileName1);
		img.transferTo(newFileName2);
		System.out.println("완료");
		System.out.println(dto1);
		System.out.println(dto2);
	
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
