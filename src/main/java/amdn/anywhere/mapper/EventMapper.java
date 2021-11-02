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
	public int updateEvent(Map<String, String> paramMap);
	//3. 이벤트 등록하기
	public int addEvent(Event event);
	//4.이벤트 삭제하기
	public int deleteEvent(String eventCode);
	//5. 이벤트 수정하기
	public int modifyEvent(Event event);
}
