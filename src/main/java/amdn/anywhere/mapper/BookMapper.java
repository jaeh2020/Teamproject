package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Menu;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.domain.Store;

@Mapper
public interface BookMapper {
	
	//예약자정보화면에서 상태코드 조회
	public Statement getStateCode(String stateCode);
	
	//주문정보화면에서 메뉴리스트 조회
	public List<Menu> getMenuList();

	//상점명 조회
	public Store getStoreInfo(String storeName);
	
	//예약자정보 등록
	public int addBookMember(Book book);
	
	//주문코드 자동 증가코드 조회
	public String getNewBookCode();
}
