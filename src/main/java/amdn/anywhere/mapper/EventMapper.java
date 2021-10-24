package amdn.anywhere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Event;

@Mapper
public interface EventMapper {
	//1. 이벤트 목록 조회
	public List<Event> getEventList(Map<String, Object> paramMap);
	//2. 이벤트 종료하기
	public int finishEvent(String eventCode);
	//3. 이벤트 등록하기
	public int addEvent(Event event);
}
