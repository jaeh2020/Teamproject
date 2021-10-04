package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.FoodMainCate;

@Mapper
public interface MenuMapper {

	//나의매장 정보 리스트 조회 - 메뉴조회
	public List<FoodMainCate> getFoodMainList(String bizId);

}
