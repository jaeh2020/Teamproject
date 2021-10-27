package amdn.anywhere.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Point;
import amdn.anywhere.domain.PointDel;

@Mapper
public interface PointMapper {
	
	//포인트 소멸 등록
	public int addPointDel(Map<String, String> pointDelMap);
	
	//포인트 소멸 시간
	public String pointDelTime(String userId);
	
	//포인트 소멸 코드 자동증가
	public String getPointDelCode();
	
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
