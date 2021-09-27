package amdn.anywhere.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Message;
import amdn.anywhere.domain.MessageCheck;
import amdn.anywhere.domain.MessageCommon;
import amdn.anywhere.domain.Questionnaire;
import amdn.anywhere.mapper.MessageMapper;

@Service
@Transactional
public class MessageService {

	private final MessageMapper messageMapper;
	
	public MessageService(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
	}
	
	//알림메세지 체크 등록
	public int addMessageCheck(MessageCheck messageCheck) {
		return messageMapper.addMessageCheck(messageCheck);
	}
	
	//addmessage...
	public int addMessage(Message message) {
		return messageMapper.addMessage(message);
	}
	
	//알림메세지 체크 조회
	public List<MessageCheck> getMessageCheckList(){
		List<MessageCheck> messageCheckList = messageMapper.getMessageCheckList();
		
		return messageCheckList;
	}
	
	//공통 메시지 조회
	public List<MessageCommon> getMessageCommonList(){
		List<MessageCommon> messageCommonList = messageMapper.getMessageCommonList();
		
		return messageCommonList;
	}
	
	//메시지 알림 조회(ajax)
	public List<Message> getMessageL(String messageCode){
		List<Message> messageList = messageMapper.getMessageL(messageCode);
		
		return messageList;
	}
	//메시지 알림 조회
	public List<Message> getMessageList(){
		List<Message> messageList = messageMapper.getMessageList();
		
		return messageList;
	}
}
