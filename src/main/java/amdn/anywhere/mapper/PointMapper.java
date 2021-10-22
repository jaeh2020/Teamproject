package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Point;

@Mapper
public interface PointMapper {

	//포인트 적립 등록
	public int addPoint(Point point);
	
	//가입 시 포인트 적립
	public int addJoinPoint(Point point);
	
	//포인트 적립 코드 자동증가
	public String getPointCode();
	
	//포인트 내역 개인 조회
	public List<Point> getPointListInfoById(String userId);
	
	//포인트 내역 조회
	public List<Point> getPointList();
}
