package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Message;
import amdn.anywhere.domain.MessageCheck;
import amdn.anywhere.domain.MessageCommon;

@Mapper
public interface MessageMapper {

	//메세지 알림설정 db에 입력
	public int addMessageCheck(MessageCheck messageCheck);
	
	//addmessage..
	public int addMessage(Message message);
	
	//전체 소비자 알림 설정 리스트
	public List<MessageCheck> getMessageCheckList();
	
	//공통 알림메세지 리스트
	public List<MessageCommon> getMessageCommonList();
	
	//받은 알림메세지 리스트
	public List<Message> getMessageList();
}
