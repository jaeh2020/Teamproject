package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Menu;

@Mapper
public interface MenuMapper {
	
	//메뉴 대분류 가져오기
	public List<FoodMainCate> getFoodMainCateList();
	
	//나의매장 메뉴리스트 조회
	public List<Menu> getMyMenuList(String bizId);
	

}
