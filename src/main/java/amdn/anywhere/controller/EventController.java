package amdn.anywhere.controller;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import amdn.anywhere.domain.Event;
import amdn.anywhere.domain.Store;

import amdn.anywhere.service.EventService;
import amdn.anywhere.service.StoreService;

@Controller
@RequestMapping("/event")
public class EventController {
	
	private final EventService eventService;
	private final StoreService storeService;
	public EventController(EventService eventService, StoreService storeService) {
		this.eventService = eventService;
		this.storeService = storeService;
	}
	//8. 이벤트 등록시 매장검색 프로세스
	@PostMapping("/searchStore")
	public String searchStore(@RequestParam(value="searchKey", required = false) String searchKey, Model model){
		System.out.println(searchKey);
		List<Store> storeList = storeService.searchStore(searchKey);
		model.addAttribute("storeList", storeList);
		return "/event/searchStore";
	}

	//7. 이벤트 등록할 때 매장 검색화면 띄우기
	@GetMapping("/searchStore")
	public String searchStore(Model model) {
		//매장 리스트 가져오기
		List<Store> storeList= storeService.getStoreList();
		model.addAttribute("storeList", storeList);
		return "/event/searchStore";
	}
	//6. 이벤트 등록 프로세스
	@PostMapping("/addEventProcess")
	public String addEventProcess(Model model, HttpSession session
				,@RequestParam(value="img", required = false) MultipartFile img, Event event
				,@RequestParam(value="bannerImg", required = false) MultipartFile bannerImg){
		event.setAdminId((String) session.getAttribute("SID"));
		//dto 에 세팅
		event.setEventImgName(img.getOriginalFilename());
		event.setEventBannerName(bannerImg.getOriginalFilename());
		//서버에 저장될 파일 이름 생성 : 나노시간 _원래 파일명
		String newImgName = Long.toString(System.nanoTime()) + "_" + img.getOriginalFilename(); 
		String newBannerName = Long.toString(System.nanoTime()) + "_" + bannerImg.getOriginalFilename(); 
		//dto 에 세팅
		event.setImgStoredPath(newImgName);
		event.setBannerStoredPath(newBannerName);
		
		//이벤트 등록 처리
		eventService.addEvent(event);
		//파일을 서버에 저장하기
		try {
			byte[] imgBytes = img.getBytes();
			byte[] bannerBytes = bannerImg.getBytes();

			//저장경로 지정

			Path path1 = Paths.get(System.getProperty("user.dir") + "/src/main/resources/static/images/event/"+ newImgName);
			Path path2 = Paths.get(System.getProperty("user.dir") + "/src/main/resources/static/images/event/"+ newBannerName);
			
			Files.write(path1,imgBytes);
			Files.write(path2,bannerBytes);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
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
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("eventCode", eventCode);
		paramMap.put("state", "finish");
		eventService.updateEvent(paramMap);
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
