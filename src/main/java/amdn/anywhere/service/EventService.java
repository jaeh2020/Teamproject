package amdn.anywhere.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Event;
import amdn.anywhere.mapper.EventMapper;

@Service
@Transactional
public class EventService {
	
	private EventMapper eventMapper;
	
	public EventService(EventMapper eventMapper) {
		this.eventMapper = eventMapper;
	}
	//1.이벤트 목록 가져오기
	public List<Event> getEventList(Map<String, Object> paramMap){
		return eventMapper.getEventList(paramMap);
	}
	//2. 이벤트 종료하기
	public int finishEvent(String eventCode) {
		return eventMapper.finishEvent(eventCode);
	}
	//3. 이벤트 등록 
	public int addEvent(Event event) {
		//이벤트 시작일자와 현재 날짜 비교해서 상태 구분하기
		Date now = new Date();
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date eventStr = form.parse(event.getEventStr());
			System.out.println(now);
			System.out.println(eventStr);
			
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
}
