package amdn.anywhere.component;

import org.springframework.stereotype.Component;

import amdn.anywhere.service.MainService;

import org.springframework.scheduling.annotation.Scheduled;

@Component
public class Schedule {
	
	private final MainService mainService;
	
	public Schedule(MainService mainService) {
		
		this.mainService = mainService;
	}

	//1시간마다 count한 실시간 검색어현황 insert
	@Scheduled(cron = "0 0 0/1 * * *")
		public void searchAddScheduler() {
			mainService.addSearchScheduler();
		}

}
