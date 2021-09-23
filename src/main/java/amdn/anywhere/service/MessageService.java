package amdn.anywhere.service;

import java.util.List;

import org.springframework.stereotype.Service;

import amdn.anywhere.domain.Message;
import amdn.anywhere.domain.MessageCommon;
import amdn.anywhere.mapper.MessageMapper;

@Service
public class MessageService {

	private final MessageMapper messageMapper;
	
	public MessageService(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
	}
	
	//공통 메시지 조회
	public List<MessageCommon> getMessageCommonList(){
		List<MessageCommon> messageCommonList = messageMapper.getMessageCommonList();
		
		return messageCommonList;
	}
	
	//메시지 알림 조회
	public List<Message> getMessageList(){
		List<Message> messageList = messageMapper.getMessageList();
		
		return messageList;
	}
}
