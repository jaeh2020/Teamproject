package amdn.anywhere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import amdn.anywhere.domain.Message;
import amdn.anywhere.domain.MessageCheck;
import amdn.anywhere.domain.MessageCommon;

@Mapper
public interface MessageMapper {
	

	//메세지 알림설정(update)(ajax)
	public int modifyMsgCheck(MessageCheck messageCheck);
	
	//메세지 알림설정(insert)
	public int addMessageCheck(MessageCheck messageCheck);
	
	//아이디별 알림 설정 목록(id=session id)
	public MessageCheck getMessageCheck(String memberId);
	
	//관리자권한 알림 설정 리스트
	public List<MessageCheck> getMsgCheckList();
	
	//addmessage..
	public int addMessage(Message message);
	
	//공통 알림메세지 리스트
	public List<MessageCommon> getMessageCommonList();
	
	//받은 알림메세지 리스트(ajax)
	public List<Message> getMessageL(String messageCate1, String memberId);
	
	//알림메세지 리스트
	public List<Message> getMessageList();
}
