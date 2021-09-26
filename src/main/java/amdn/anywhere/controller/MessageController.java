package amdn.anywhere.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.Message;
import amdn.anywhere.domain.MessageCheck;
import amdn.anywhere.domain.MessageCommon;
import amdn.anywhere.domain.QuestionCate;
import amdn.anywhere.domain.Questionnaire;
import amdn.anywhere.service.MessageService;

@Controller
public class MessageController {

	private final MessageService messageService;
	
	public MessageController(MessageService messageService) {

		this.messageService = messageService;
	}

	
	
	//환경설정-공통메시지 리스트
	@GetMapping("/commonMessage")
	public String getcommonMessage(Model model) {
		
		List<MessageCommon> messageCommonList = messageService.getMessageCommonList();
		
		model.addAttribute("location","알림등록하기");
		model.addAttribute("messageCommonList",messageCommonList);

		return "message/commonMessage";
	}
	
	//관리자 입장 -> 알림체크리스트
	@GetMapping("/messageCheckList")
	public String getMessageCheckList(Model model) {
		
		List<MessageCheck> messageCheckList = messageService.getMessageCheckList();
		
		model.addAttribute("location","알림 체크 설정 관리 어쩌고..");
		model.addAttribute("messageCheckList",messageCheckList);
		return "message/messageCheckList";
	}
	
	//알림 뭐 받을지 체크,입력
	@PostMapping("/messageCheck")
	public String addMessageCheck(MessageCheck messageCheck) {
		
		if(messageCheck != null) messageService.addMessageCheck(messageCheck);
		
		return "redirect:/messageCheckList";
	}
	@GetMapping("/messageCheck")
	public String getMessageCheck(Model model) {
		model.addAttribute("location","알림 설정");
		return "message/messageCheck";
	}
	
	//메세지 알림 등록 쉽게하려고 만드는거임
	@PostMapping("/addMessage")
	public String addMessage(Message message, HttpSession httpSession) {
		System.out.println("커맨드객체 : " + message);
		
		if(message != null) messageService.addMessage(message);
		
		Message msg = new Message();
		msg.setConfirmId((String)httpSession.getAttribute("SID"));
		System.out.println(msg);
		return "redirect:/messageList";
	}
	
	@RequestMapping(value = "/addMessage", method = RequestMethod.GET)
	public String addMessage(Model model) {

		List<MessageCommon> messageCommonList = messageService.getMessageCommonList();
		
		model.addAttribute("location","알림등록하기");
		model.addAttribute("messageCommonList",messageCommonList);

		return "message/addMessage";
	}

	//알림 메시지 조회
	  @GetMapping("/messageList") 
	  public String getMessageList(Model model, HttpSession httpSession) {
	  
	  List<Message> messageList = messageService.getMessageList();
	  
	  Message msg = new Message();
	  msg.setMemberId((String)httpSession.getAttribute("SID"));
	  
	  
	  System.out.println(msg);
	  model.addAttribute("location","메세지 목록"); 
	  model.addAttribute("messageList",messageList);
	  return "message/messageList"; 
	  }
	 

}
