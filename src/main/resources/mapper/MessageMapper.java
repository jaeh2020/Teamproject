package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Message;

@Mapper
public interface MessageMapper {

	//알림 목록 조회
	public List<Message> getMessageList();
}
