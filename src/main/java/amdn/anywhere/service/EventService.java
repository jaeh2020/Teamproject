package amdn.anywhere.service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import amdn.anywhere.domain.Event;
import amdn.anywhere.mapper.EventMapper;

@Service
@Transactional
public class EventService {
	
	private final EventMapper eventMapper;
	
	public EventService(EventMapper eventMapper) {
		this.eventMapper = eventMapper;
	}
	//1.이벤트 목록 가져오기
	public List<Event> getEventList(Map<String, Object> paramMap){
		return eventMapper.getEventList(paramMap);
	}
	//2. 이벤트 상태 변경
	public int updateEvent(Map<String, String> paramMap) {
		return eventMapper.updateEvent(paramMap);
	}
	//3. 이벤트 등록 
	public int addEvent(Event event) {
		//이벤트 시작일자와 현재 날짜 비교해서 상태 구분하기
		Date now = new Date();
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date eventStr = form.parse(event.getEventStr());
	
			if(eventStr.after(now)) {
				event.setStateCode("state_event_ready");
			}else {
				event.setStateCode("state_event_ing");
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return eventMapper.addEvent(event);
	}
	//4. 이벤트 삭제하기
	public int deleteEvent(String eventCode) {
		return eventMapper.deleteEvent(eventCode);
	}
	//5. 이벤트 파일 업로드
	public int uploadImages(Map<String, Object> paramMap, HttpSession session) {
		MultipartFile img = (MultipartFile) paramMap.get("img");
		MultipartFile bannerImg = (MultipartFile) paramMap.get("bannerImg");
		try {
			byte[] imgBytes = img.getBytes();
			byte[] bannerBytes = bannerImg.getBytes();

			//저장경로 지정
			Path path1 = Paths.get(session.getServletContext().getRealPath("/WEB-INF/classes/static/images/event/") + paramMap.get("newImgName"));
			Path path2 = Paths.get(session.getServletContext().getRealPath("/WEB-INF/classes/static/images/event/") + paramMap.get("newBannerName"));
			
			//Path path1 = Paths.get(System.getProperty("user.dir") + "/src/main/resources/static/images/event/"+ paramMap.get("newImgName"));
			//Path path2 = Paths.get(System.getProperty("user.dir") + "/src/main/resources/static/images/event/"+paramMap.get("newBannerName"));
			
			Files.write(path1,imgBytes);
			Files.write(path2,bannerBytes);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//6. 이벤트 수정하기
	public int modifyEvent(Event event) {
		return eventMapper.modifyEvent(event);
	}
}
