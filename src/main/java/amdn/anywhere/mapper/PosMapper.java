package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Order;

@Mapper
public interface PosMapper {

	//나의매장 주문pos list조회
	public List<Order> getPosOrderList(String storeCode);


}
