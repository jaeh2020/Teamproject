package amdn.anywhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amdn.anywhere.domain.FoodMainCate;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.mapper.MenuMapper;
@Service
public class MenuService {
	private MenuMapper menuMapper;
	
	@Autowired
	public MenuService(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}
	
	//메뉴 대분류 가져오기
	public List<FoodMainCate> getFoodMainCateList(){
		List<FoodMainCate> foodMainCateList = menuMapper.getFoodMainCateList();
		return foodMainCateList;
	}
	
	
	//나의매장정보 리스트 조회
	public Map<String, Object> getMyMenuList(String bizId){
		
		List<Menu> myMenuList = menuMapper.getMyMenuList(bizId);
			
		Map<String, Object> paramMap = new HashMap<String, Object>();
			
		paramMap.put("myMenuList", myMenuList);

		return paramMap;
	}

}
