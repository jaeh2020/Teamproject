package amdn.anywhere.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.NumberOfMember;
import amdn.anywhere.domain.Report;
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
	public List<Board> getRecentBoardList(){
		return statisticMapper.getRecentBoardList();
	}
	public List<Report> getRecentReport(){
		return statisticMapper.getRecentReport();
	}
	public int getTotalCountsOfOrder() {
		return statisticMapper.getTotalCountsOfOrder();
	}
	public int getTotalPrice() {
		return statisticMapper.getTotalPrice();
	}
	public List<NumberOfMember> getNumOfMember(){
		return statisticMapper.getNumOfMember();
	}
}
