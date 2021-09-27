package amdn.anywhere.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes.Name;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.BoardCate;
import amdn.anywhere.domain.QuestionCate;
import amdn.anywhere.service.BoardService;

@Controller
public class BoardController {
private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	
	

	@GetMapping("/boardModify")
	public String boardModify(Model model) {
		model.addAttribute("title", "게시판 수정");
		return "board/boardModify";
	}
	
	
	@GetMapping("/boardView")
	public String boardView(Model model) {
		model.addAttribute("title", "게시판 조회");
		return "board/boardView";
	}
	
	
	
	// 회원정보보기 - ajax
	@PostMapping(value="/memberSearch", produces = "application/json")
	@ResponseBody
	public Map<String,Object> getBoardList(@RequestParam("memberId") String memberId){
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("memberId", memberId);
		map.put("memberName", "홍길동");
		map.put("memberAge", 20);
				
		return map;
	}
	
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		List<Board> boardList = boardService.getBoardList();
		
		model.addAttribute("title", "게시판 목록");
		model.addAttribute("location", "소비자 게시판");
		model.addAttribute("boardList", boardList);
		return "board/boardList";
	}
	

	@PostMapping("/boardWrite")
	public String boardWrite(Board board) {
		System.out.println("====================");
		System.out.println("커맨드객체 board : " + board);
		System.out.println("====================");
		
		if(board != null) boardService.boardWrite(board);
		return "redirect:/boardList";
	}
	
	
	@GetMapping("/boardWrite")
	public String reviewList(Model model
	/*
	 * ,@RequestParam(name = "boardCateCode" , required = false) String
	 * boardCateCode
	 */) {

		String newBoardNum = boardService.getNewBoardNum();
		/* BoardCate boardCate = boardService.getBoardCateCode(boardCateCode); */
		
		model.addAttribute("title", "게시판 등록");
		model.addAttribute("boardNum" , newBoardNum);
		/* model.addAttribute("boardCate" , boardCate); */
		return "board/boardWrite";
	}
	
	
}
