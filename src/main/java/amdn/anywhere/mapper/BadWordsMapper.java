package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.BadWords;

@Mapper
public interface BadWordsMapper {
	//금지어 리스트 조회
	public List<BadWords> getBadWordsList();
}
