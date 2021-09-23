package amdn.anywhere.service;

import java.util.List;

import org.springframework.stereotype.Service;

import amdn.anywhere.domain.Message;
import amdn.anywhere.mapper.MessageMapper;

@Service
public class MessageService {

	private final MessageMapper messageMapper;
	
	public MessageService(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
	}
	
	public List<Message> getMessageList(){
		List<Message> messageList = messageMapper.getMessageList();
		
		return messageList;
	}
}
