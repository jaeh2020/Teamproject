package amdn.anywhere.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		 List<Board> boardList = boardService.getBoardList();
		
		model.addAttribute("title", "게시판 목록");
		model.addAttribute("boardList", boardList);
		return "board/boardList";
	}
	
	
	
	@GetMapping("/boardWirte")
	public String reviewList(Model model) {
		model.addAttribute("title", "게시판 등록");
		return "board/boardWirte";
	}
	
	
}
