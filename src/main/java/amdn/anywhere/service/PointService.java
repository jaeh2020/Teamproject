package amdn.anywhere.service;

import java.util.List;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import amdn.anywhere.domain.Point;
import amdn.anywhere.domain.PointDel;
import amdn.anywhere.mapper.PointMapper;

@Service
public class PointService {

	private final PointMapper pointMapper;
	
	public PointService(PointMapper pointMapper) {
		this.pointMapper = pointMapper;
	}
	
	//포인트 소멸 등록
	public int addPointDel(Map<String, String> pointDelMap) {
		return pointMapper.addPointDel(pointDelMap);
	}
	
	//포인트 소멸시간 찾기
	public String pointDelTime(String userId) {
		return pointMapper.pointDelTime(userId);
	}
	
	//포인트 소멸코드 자동증가
	public String getPointDelCode() {
		return pointMapper.getPointDelCode();
	}
	
	//포인트 적립 등록
	public int addPoint(Point point) {
		return pointMapper.addPoint(point);
	}
	
	//가입 시 포인트 적립
	public int addJoinPoint(Point point) {
		return pointMapper.addJoinPoint(point);
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
