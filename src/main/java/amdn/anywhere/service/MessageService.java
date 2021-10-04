package amdn.anywhere.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amdn.anywhere.domain.Message;
import amdn.anywhere.domain.MessageCheck;
import amdn.anywhere.domain.MessageCommon;
import amdn.anywhere.mapper.MessageMapper;

@Service
@Transactional
public class MessageService {

	private final MessageMapper messageMapper;
	
	public MessageService(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
	}
	
	//알림메세지 체크 수정화면
	public int modifyMsgCheck(MessageCheck messageCheck) {
		return messageMapper.modifyMsgCheck(messageCheck);
	}
	
	//아이디별 알림체크 화면
	public MessageCheck getMessageCheck(String memberId) {
		return messageMapper.getMessageCheck(memberId);
	}
	
	//관리자 권한 알림체크 리스트
	public List<MessageCheck> getMsgCheckList(){
		List<MessageCheck> msgCheckList = messageMapper.getMsgCheckList();
		
		return msgCheckList;
	}
	
	//알림메세지 체크 등록
	public int addMessageCheck(MessageCheck messageCheck) {
		return messageMapper.addMessageCheck(messageCheck);
	}
	

	//addmessage...
	public int addMessage(Message message) {
		return messageMapper.addMessage(message);
	}
	
	//공통 메시지 조회
	public List<MessageCommon> getMessageCommonList(){
		List<MessageCommon> messageCommonList = messageMapper.getMessageCommonList();
		
		return messageCommonList;
	}
	
	//메시지 알림 조회(ajax)
	public List<Message> getMessageL(String messageCate1){
		List<Message> messageL = messageMapper.getMessageL(messageCate1);
		
		return messageL;
	}
	//메시지 알림 조회
	public List<Message> getMessageList(){
		List<Message> messageList = messageMapper.getMessageList();
		
		return messageList;
	}
}
