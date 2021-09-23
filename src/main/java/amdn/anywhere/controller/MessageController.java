package amdn.anywhere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import amdn.anywhere.domain.Message;
import amdn.anywhere.service.MessageService;

@Controller
public class MessageController {

	private final MessageService messageService;
	
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	
	@GetMapping("/messageList")
	public String getMessageList(Model model) {
		
		List<Message> messageList = messageService.getMessageList();
		
		model.addAttribute("location","알림");
		model.addAttribute("messageList", messageList);
		return "message/messageList";
	}
}
