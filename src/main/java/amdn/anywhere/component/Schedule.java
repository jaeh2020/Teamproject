package amdn.anywhere.component;

import org.springframework.stereotype.Component;

import amdn.anywhere.domain.Event;
import amdn.anywhere.domain.RecruitTasterByBiz;
import amdn.anywhere.service.EventService;
import amdn.anywhere.service.MainService;
import amdn.anywhere.service.TasterService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.EventFilter;

import org.springframework.scheduling.annotation.Scheduled;

@Component
public class Schedule {
	
	private final MainService mainService;
	private final EventService eventService;
	private final TasterService tasterService;
	
	public Schedule(MainService mainService, EventService eventService,TasterService tasterService) {
		
		this.mainService = mainService;
		this.eventService= eventService;
		this.tasterService= tasterService;
	}

	//1시간마다 count한 실시간 검색어현황 insert
	@Scheduled(cron = "0 0 0/1 * * *")
		public void searchAddScheduler() {
			mainService.addSearchScheduler();
		}
	
	//하루에 한번 이벤트 기간 조회 및 update 하기
	@Scheduled(cron = "0 0 0 * * ?")
	public void checkEventPeriod() {
		//매일 자정에 실행
		//현재 날짜 가져오기
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today= df.format(new Date());
		Map<String, String> paramMap = new HashMap<String, String>();
		
		List<Event> eventList= eventService.getEventList(null);
		for(Event e : eventList) {
			try {
				Date eventStr = df.parse(e.getEventStr());
				Date eventFin = df.parse(e.getEventFin());
				Date date= df.parse(today);
				
				if(date.compareTo(eventStr) >= 0) {
					System.out.println("시작일이 오늘이거나 지난 경우");
					
					paramMap.put("eventCode", e.getEventCode());
					paramMap.put("state", "start");
					eventService.updateEvent(paramMap);
					paramMap.clear();
				}else if(date.compareTo(eventFin) > 0) {
					
					paramMap.put("eventCode", e.getEventCode());
					paramMap.put("state", "finish");
					eventService.updateEvent(paramMap);
					paramMap.clear();
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
	}
	//평가단 모집 기간 조회 및 update
	@Scheduled(cron = "0 0 0 * * ?")
	public void checkTasterRecruitPeriod(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today= df.format(new Date());
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		List<RecruitTasterByBiz> recruitList = tasterService.getRecruitBBList(null, null, null);
		for(RecruitTasterByBiz r : recruitList) {
			try {
				Date recruitFin = df.parse(r.getRecruitFinTime());
				Date date= df.parse(today);
				if(date.compareTo(recruitFin) > 0) {
					paramMap.put("recruitBCode", r.getRecruitTBizCode());
					paramMap.put("state", "종료");
					tasterService.updateRecruitBBiz(paramMap);
					paramMap.clear();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
}
