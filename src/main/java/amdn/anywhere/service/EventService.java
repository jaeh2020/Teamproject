package amdn.anywhere.service;

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
}
