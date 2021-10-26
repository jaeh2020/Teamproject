package amdn.anywhere.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.NumberOfMember;
import amdn.anywhere.domain.Report;
import amdn.anywhere.domain.Store;

@Mapper
public interface StatisticMapper {
	
	public int getTotalStore();
	
	public List<Store> getRecentStoreList();
	
	public List<Board> getRecentBoardList();
	
	public List<Report> getRecentReport();
	
	public int getTotalCountsOfOrder();
	
	public int getTotalPrice();
	
	public List<NumberOfMember> getNumOfMember();
	
}
