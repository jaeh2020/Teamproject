package amdn.anywhere.service;

import java.util.List;

import org.springframework.stereotype.Service;

import amdn.anywhere.domain.Point;
import amdn.anywhere.mapper.PointMapper;

@Service
public class PointService {

	private final PointMapper pointMapper;
	
	public PointService(PointMapper pointMapper) {
		this.pointMapper = pointMapper;
	}
	
	//포인트 적립 등록
	public int addPoint(Point point) {
		return pointMapper.addPoint(point);
	}
	
	//포인트 적립코드 자동증가
	public String getPointCode() {
		return pointMapper.getPointCode();
	}
	
	//포인트 내역 개인 조회
	public List<Point> getPointListInfoById(String userId) {
		List<Point> getPointList = pointMapper.getPointListInfoById(userId);
		
		return getPointList;
	}
	
	//포인트 내역 전체 조회
	public List<Point> getPointList(){
		List<Point> pointList = pointMapper.getPointList();
		return pointList;
	}
}
