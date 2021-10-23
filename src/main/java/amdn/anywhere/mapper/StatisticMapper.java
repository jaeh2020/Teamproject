package amdn.anywhere.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticMapper {
	public int getTotalStore();
}
