package amdn.anywhere.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Store;
import amdn.anywhere.mapper.StatisticMapper;

@Service
@Transactional
public class StatisticService {
	private StatisticMapper statisticMapper;
	public StatisticService(StatisticMapper statisticMapper) {
		this.statisticMapper = statisticMapper;
	}
	
	public int getTotalStore() {
		return statisticMapper.getTotalStore();
	}
	public List<Store> getRecentStoreList(){
		return statisticMapper.getRecentStoreList();
	}
}
