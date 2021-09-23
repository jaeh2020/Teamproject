package amdn.anywhere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import amdn.anywhere.domain.Message;
import amdn.anywhere.domain.MessageCommon;
import amdn.anywhere.service.MessageService;

@Controller
public class MessageController {

	private final MessageService messageService;
	
	public MessageController(MessageService messageService) {

		this.messageService = messageService;
	}

	//환경설정-공통메시지 등록
	@GetMapping("/commonMessage")
	public String getcommonMessage(Model model) {
		
		List<MessageCommon> messageCommonList = messageService.getMessageCommonList();
		
		model.addAttribute("location","알림등록하기");
		model.addAttribute("messageCommonList",messageCommonList);
		return "message/commonMessage";
	}
	
	//알림 뭐 받을지 체크
	@GetMapping("/messageCheck")
	public String getMessageCheck(Model model) {
		model.addAttribute("location","알림 설정");
		return "message/messageCheck";
	}
	
	//공통 메시지 조회
	@GetMapping("/addMessage")
	public String getaddMessage(Model model) {
		
		List<MessageCommon> messageCommonList = messageService.getMessageCommonList();
		
		model.addAttribute("location","알림등록하기");
		model.addAttribute("messageCommonList",messageCommonList);
		return "message/addMessage";
	}

	//알림 메시지 조회
	@GetMapping("/messageList")
	public String getMessageList(Model model) {
		
		List<Message> messageList = messageService.getMessageList();
		
		model.addAttribute("location","알림");
		model.addAttribute("messageList", messageList);
		return "message/messageList";
	}
}
