package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Age;

@Mapper
public interface AgeMapper {
	//연령대 코드로 조회
	public List<Age> getAgeList(String ageCode);
}
