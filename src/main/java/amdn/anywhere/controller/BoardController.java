package amdn.anywhere.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.BoardCate;
import amdn.anywhere.domain.Member;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.service.BoardService;

@Controller
/* @RequestMapping("/board") */
public class BoardController {
	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	
	 // 게시글 수정

	@GetMapping("/boardModify")
	public String boardModify(Model model) {
		model.addAttribute("title", "게시판 수정");
		return "board/boardModify";
	}

	
	
	
	
	// 게시글 보기
	@GetMapping("/boardView")
	public String boardView(Model model
			    			,@RequestParam(name = "boardNum" , required = false) String boardNum) {
		
	
		
		//게시물 정보 가져오기
		Board board = boardService.getBoardInfoByCode(boardNum);
		
		
		
		model.addAttribute("title", "게시판 조회");
		model.addAttribute("board", board);
		
		return "board/boardView";
	}

	
	
	  //ajax - 회원 정보 보기
	  @GetMapping(value="/memberSearch", produces = "application/json")
	  @ResponseBody 
	  public Member getMemberList(@RequestParam(name="memberId", required = false) String memberId){ 		  
		  Member member = boardService.getMemberRead(memberId);
		  if(member == null) member = new Member();		  		  
		  return member; 
		  
	  }
	  
	
	  // 게시글 목록
	@GetMapping("/boardList")
	public String boardList(Model model) {
		List<Board> boardList = boardService.getBoardList();
		
		
		model.addAttribute("title", "게시판 목록");
		model.addAttribute("location", "소비자 게시판");
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
	}
	
	 // 게시글 작성
	@PostMapping("/boardWrite")
	public String boardWrite(Board board) {
		System.out.println("====================");
		System.out.println("커맨드객체 board : " + board);
		System.out.println("====================");
		

		if (board != null)
			boardService.boardWrite(board);
		return "redirect:/boardList";
	}

	@GetMapping("/boardWrite")
	public String reviewList(Model model
							,HttpSession session
			,@RequestParam(name = "boardCateCode" , required = false) String boardCateCode
			,@RequestParam(name = "boardStatementCode" , required = false) String boardStatementCode) {

		//게시글 번호 가져오기
		String newBoardNum = boardService.getNewBoardNum();
		//로그인 아이디 가져오기
		String memberId = (String) session.getAttribute("SID");
		//게시글 카테고리 코드 가져오기
		BoardCate boardCate = boardService.getBoardCateCode(boardCateCode);
		//상태코드 가져오기
		Statement boardStatement = boardService.getboardStatement(boardStatementCode);

		model.addAttribute("title", "게시판 등록");
		model.addAttribute("boardNum", newBoardNum);
		model.addAttribute("memberId", memberId);
		model.addAttribute("boardCate", boardCate);
		model.addAttribute("boardStatement", boardStatement);
		
		return "board/boardWrite";
	}

}
