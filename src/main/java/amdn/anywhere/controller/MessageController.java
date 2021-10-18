package amdn.anywhere.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import amdn.anywhere.service.MessageService;

@Controller
public class MessageController {

	private final MessageService messageService;
	
	
	private static final Logger log = LoggerFactory.getLogger(MessageController.class);

	
	public MessageController(MessageService messageService) {

		this.messageService = messageService;
	}
	
	
	//체크박스 -ajax
	@GetMapping(value= "/msCheck", produces = "application/json")
	@ResponseBody
	public String myJson(	@RequestParam(value = "ckArr[]") List<String> ckArr
							,@RequestParam(value="memberId", required = false) String memberId
							,HttpSession httpSession
							,Model model
							,MessageCheck messageCheck) {

		log.info("ckArr : {}", ckArr);
		log.info("modi memberId : {}", memberId);
		
		//세션아이디 세팅
		MessageCheck msc = new MessageCheck();
		msc.setMemberId((String)httpSession.getAttribute("SID"));
		
		for(String checkedOption : ckArr) {
			if("orderReservation".equals(checkedOption)) 	msc.setOrderReservation("y");
			if("messagePay".equals(checkedOption)) 			msc.setMessagePay("y");
			if("messageWaiting".equals(checkedOption)) 		msc.setMessageWaiting("y");
			if("messageFavorite".equals(checkedOption)) 	msc.setMessageFavorite("y");
			if("messageEvaluator".equals(checkedOption)) 	msc.setMessageEvaluator("y");
			if("messageMemberShip".equals(checkedOption)) 	msc.setMessageMemberShip("y");
			if("messageBoard".equals(checkedOption)) 		msc.setMessageBoard("y");
			if("messageReview".equals(checkedOption)) 		msc.setMessageReview("y");
			if("messagePoint".equals(checkedOption)) 		msc.setMessagePoint("y");
			if("messageEvent".equals(checkedOption)) 		msc.setMessageEvent("y");
			if("messageSms".equals(checkedOption)) 			msc.setMessageSms("y");
			if("messageEmail".equals(checkedOption)) 		msc.setMessageEmail("y");
			System.out.println(checkedOption+"<<checkedOption");
		}
		/*
		 * ArrayList<String> ckList = new ArrayList<String>(); for(int i=0; i <
		 * ckArr.size(); i++){ ckList.add(ckArr.get(i)); }
		 */
		log.info("msc 값 : {}", msc);

		messageService.modifyMsgCheck(msc);
		
		return "redirect:/messageList";
	}
	
	
	//알림 뭐 받을지 체크,입력
	@PostMapping("/message/messageCheck")
	public String addMessageCheck(MessageCheck messageCheck) {
		
		if(messageCheck != null) messageService.addMessageCheck(messageCheck);
		
		return "redirect:/messageCheckList";
	}
	
	//id별 알림체크 조회
	@GetMapping("/message/messageCheck")
	public String getMessageCheck(  @RequestParam(value = "memberId", required = false) String memberId
									,HttpSession httpSession
									,Model model) {
		
		MessageCheck msc = new MessageCheck();
		msc.setMemberId((String)httpSession.getAttribute("SID"));
		
		MessageCheck messageCheck = messageService.getMessageCheck(memberId);
		
		model.addAttribute("messageCheck", messageCheck);
		
		log.info("msc!!! : {}", msc);
		log.info("memberId : {}", memberId);
		return "message/messageCheck";
	}
	
	//관리자가 알림체크 조회
	@GetMapping("message/messageCheckList")
	public String getMessageCheckList(Model model) {
			
		  List<MessageCheck> msgCheckList = messageService.getMsgCheckList();

		  model.addAttribute("title","메세지 체크목록"); 
		  model.addAttribute("location","메세지 체크목록"); 
		  model.addAttribute("msgCheckList",msgCheckList);
		  
		  return "message/messageCheckList"; 
	}
	
	//환경설정-공통메시지 리스트
	@GetMapping("/message/commonMessage")
	public String getcommonMessage(Model model) {
		
		List<MessageCommon> messageCommonList = messageService.getMessageCommonList();
		
		model.addAttribute("title","공통 알림 목록"); 
		model.addAttribute("location","공통 알림 목록");
		model.addAttribute("messageCommonList",messageCommonList);

		return "message/commonMessage";
	}
	
	
	
	//메세지 알림 등록 쉽게하려고
	@PostMapping("/message/addMessage")
	public String addMessage(Message message, HttpSession httpSession) {
		System.out.println("커맨드객체 : " + message);
		
		if(message != null) messageService.addMessage(message);
		
		Message msg = new Message();
		msg.setConfirmId((String)httpSession.getAttribute("SID"));
		System.out.println(msg);
		return "redirect:/messageList";
	}
	
	@RequestMapping(value = "/message/addMessage", method = RequestMethod.GET)
	public String addMessage(Model model) {

		List<MessageCommon> messageCommonList = messageService.getMessageCommonList();
		
		model.addAttribute("title","알림등록하기"); 
		model.addAttribute("location","알림등록하기");
		model.addAttribute("messageCommonList",messageCommonList);

		return "message/addMessage";
	}
	
	//알림 메세지 조회 ajax
	@GetMapping(value="/messageL", produces = "application/json")
	@ResponseBody
	public List<Message> getMessageL( @RequestParam(name="messageCate1", required = false) String messageCate1
									 ,@RequestParam(name = "memberId", required = false) String memberId){
		
		List<Message> messageL = messageService.getMessageL(messageCate1, memberId);

		System.out.println(messageL + "messageL");
		System.out.println(memberId + " : memberIdmemberIdmemberIdmemberIdmemberId");
		
		return messageL;
	}

	//알림 메시지 조회
	  @GetMapping("/message/messageList") 
	  public String getMessageList(Model model, HttpSession httpSession) {
		  							
	  List<Message> messageList = messageService.getMessageList();

	  model.addAttribute("title","메세지 목록"); 
	  model.addAttribute("location","메세지 목록"); 
	  model.addAttribute("messageList",messageList);
	  
	  return "message/messageList"; 
	  }
	 
	
}
