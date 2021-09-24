package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Book;
import amdn.anywhere.domain.Store;

@Mapper
public interface BookMapper {
	
	//상점코드 조회
	public Store getStoreInfoByCode(String storeCode);
	
	//상점명 조회
	public Store getStoreInfoById(String storeName);
	
	//예약자정보 등록
	public int addBookMember(Book book);
	
	//예약정보 증가코드 조회
	public String getNewBookCode();

}
