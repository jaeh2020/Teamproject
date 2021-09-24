package amdn.anywhere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import amdn.anywhere.domain.Board;
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
	
	@GetMapping(value = "/boardList" ,produces = "application/json")
	/* @ResponseBody */
	public String boardList(Model model) {
		List<Board> boardList = boardService.getBoardList();
		
		model.addAttribute("title", "게시판 목록");
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
	public String reviewList(Model model) {

		String newBoardNum = boardService.getNewBoardNum();
		
		model.addAttribute("title", "게시판 등록");
		model.addAttribute("boardNum" , newBoardNum);
		return "board/boardWrite";
	}
	
	
}