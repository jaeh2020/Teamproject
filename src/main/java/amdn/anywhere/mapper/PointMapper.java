package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Point;

@Mapper
public interface PointMapper {

	//포인트 내역 조회
	public List<Point> getPointList();
}
