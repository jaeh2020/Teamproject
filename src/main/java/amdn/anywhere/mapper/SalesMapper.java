package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Sales;

@Mapper
public interface SalesMapper {
	public List<Sales> getSalesList();

}
