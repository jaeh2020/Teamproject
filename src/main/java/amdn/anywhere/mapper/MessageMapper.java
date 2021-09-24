package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Message;
import amdn.anywhere.domain.MessageCommon;

@Mapper
public interface MessageMapper {

	//공통 알림메시지 조회
	public List<MessageCommon> getMessageCommonList();
	
	//받은 알림메시지 조회
	public List<Message> getMessageList();
}
