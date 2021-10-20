
package amdn.anywhere.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import amdn.anywhere.domain.Board;
import amdn.anywhere.domain.BoardReply;
import amdn.anywhere.domain.Member;
import amdn.anywhere.domain.Report;
import amdn.anywhere.domain.Statement;
import amdn.anywhere.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	

	
	//소상공인 게시글 신고 작성처리
	@PostMapping("/boardBizReport")
	public String boardBizReportWrite(Report report
			) {
		
		System.out.println("report" + report);
		
		
		if (report != null) {
			report.setReportCode(boardService.getNewReportNum());
			boardService.boardReport(report);
		}
		
		return "redirect:/board/boardBizList";
	}
	
	
	//게시글 신고 작성처리
	@PostMapping("/boardReport")
	public String boardReportWrite(Report report
							 ) {
		
		System.out.println("report" + report);
		
		
		if (report != null) {
			report.setReportCode(boardService.getNewReportNum());
			boardService.boardReport(report);
		}
		
		return "redirect:/board/boardList";
	}
	
	
	
	//소상공인 게시글 신고 작성
	@GetMapping("/boardBizReport")
	public String boardBizReport(Model model
			,HttpSession session
			,@RequestParam(name = "reportCateCode" , required = false) String reportCateCode
			,@RequestParam(name = "reportStatementCode" , required = false) String reportStatementCode
			,@RequestParam(name = "boardNum" , required = false) String boardNum) {
		
		//신고자 아이디 가져오기
		String reportId = (String)session.getAttribute("SID");
		//게시글 번호 가져오기
		Board board = boardService.getBoardInfoByCode(boardNum);
		//신고 상태코드 가져오기
		Statement reportStatement = boardService.getReportStatement(reportStatementCode);
		
		
		model.addAttribute("title", "게시판 신고");
		model.addAttribute("reportId", reportId);
		model.addAttribute("board" , board);
		model.addAttribute("reportStatement" , reportStatement);
		
		return "/board/boardBizReport";
	}
	
	//게시글 신고 작성
	@GetMapping("/boardReport")
	public String boardReport(Model model
							  ,HttpSession session
							  ,@RequestParam(name = "reportCateCode" , required = false) String reportCateCode
							  ,@RequestParam(name = "reportStatementCode" , required = false) String reportStatementCode
							  ,@RequestParam(name = "boardNum" , required = false) String boardNum) {
		
		//신고자 아이디 가져오기
		String reportId = (String)session.getAttribute("SID");
		//게시글 번호 가져오기
		Board board = boardService.getBoardInfoByCode(boardNum);
		//신고 상태코드 가져오기
		Statement reportStatement = boardService.getReportStatement(reportStatementCode);
	
		
		model.addAttribute("title", "게시판 신고");
		model.addAttribute("reportId", reportId);
		model.addAttribute("board" , board);
		model.addAttribute("reportStatement" , reportStatement);
	
		
		
		return "/board/boardReport";
	}

	
	
	//게시글 댓글 삭제처리
	@GetMapping("/deleteComment")
	public String deleteComment(BoardReply boardReply
								,@RequestParam(name = "boardReplyCode" , required = false) String boardReplyCode
								,@RequestParam(name = "boardNum" , required = false) String boardNum
								, HttpSession session) {
		
	
			 //로그인 정보 가져오기
			 String memberId = (String) session.getAttribute("SID");
			 boardReply.setMemberId(memberId);
		 
			 System.out.println("boardReply 화면 값" + boardReply);
			
			 boardService.deleteComment(boardReplyCode);
			
			 return "redirect:/board/boardView?boardNum="+ boardNum ;
	}

	
	
	//소상공인 게시글 수정 처리
	@PostMapping("/boardNoticeModify")
	public String boardNoticeModify(Board board) {
		
		
		System.out.println("board 수정화면 값" + board);
		
		boardService.boardModify(board);
		
		return "redirect:/board/boardNoticeList";
	}
	
	//소상공인 게시글 수정 처리
	@PostMapping("/boardBizModify")
	public String boardBizModify(Board board) {
		
		
		System.out.println("board 수정화면 값" + board);
		
		boardService.boardModify(board);
		
		return "redirect:/board/boardBizList";
	}
	
	//게시글 수정 처리
	@PostMapping("/boardModify")
	public String boardModify(Board board) {
		
		
		System.out.println("board 수정화면 값" + board);
		
		boardService.boardModify(board);
		
		return "redirect:/board/boardList";
	}
	
	
	// 공지사항 수정
	@GetMapping("/boardNoticeModify")
	public String boardNoticeModify(Model model
			,@RequestParam(name = "boardNum" , required = false) String boardNum) {
		
		//게시글 수정정보 가져오기
		Board board = boardService.getBoardInfoByCode(boardNum); 
		
		model.addAttribute("title", "공지사항 수정");
		model.addAttribute("board" , board); 
		
		return "/board/boardNoticeModify";
	}
	
	// 소상공인 게시글 수정
	@GetMapping("/boardBizModify")
	public String boardBizModify(Model model
			,@RequestParam(name = "boardNum" , required = false) String boardNum) {
		
		//게시글 수정정보 가져오기
		Board board = boardService.getBoardInfoByCode(boardNum); 
		
		model.addAttribute("title", "소상공인 게시판 수정");
		model.addAttribute("board" , board); 
		
		return "/board/boardBizModify";
	}
	
	// 게시글 수정
	@GetMapping("/boardModify")
	public String boardModify(Model model
							,@RequestParam(name = "boardNum" , required = false) String boardNum) {
	
		//게시글 수정정보 가져오기
		 Board board = boardService.getBoardInfoByCode(boardNum); 
		
		model.addAttribute("title", "소비자 게시판 수정");
		model.addAttribute("board" , board); 
		
		return "/board/boardModify";
	}
	
	
	//공지사항 삭제처리
	@PostMapping("/boardNoticeDelete")
	public String boardNoticeDelete(Board board
									,@RequestParam(name = "boardNum" , required = false) String boardNum ) {
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("boardNum", boardNum);
		
		boardService.boardDelete(paramMap);
		
		return "redirect:/board/boardNoticeList";
	}
	
	//소상공인 게시글 삭제처리
	@GetMapping("/boardBizDelete")
	public String boardBizDelete(Board board
			,@RequestParam(name = "boardNum" , required = false) String boardNum ) {
		
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("boardNum", boardNum);
		
		//삭제버튼 클릭시 delete
		boardService.commentdel(paramMap);
		boardService.boardDelete(paramMap);
		
		
		return "redirect:/board/boardBizList";
	}
	
	//소비자 게시글 삭제처리
	@GetMapping("/boardDelete")
	public String boardDelete(Board board
							  ,@RequestParam(name = "boardNum" , required = false) String boardNum ) {
		
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("boardNum", boardNum);
		
		//삭제버튼 클릭시 delete
		boardService.commentdel(paramMap);
		boardService.boardDelete(paramMap);
		
		
		return "redirect:/board/boardList";
	}
	
	
	//게시물 댓글 등록
	@PostMapping("/boardView")
	public String boardView(BoardReply boardReply
			, HttpSession session
			, @RequestParam(name = "boardNum" , required = false) String boardNum) {
		
		//로그인 정보 가져오기
		String memberId = (String) session.getAttribute("SID");
		boardReply.setMemberId(memberId);
		
		System.out.println("커맨드 객체 boardReply" + boardReply);
		
	
		//게시글 댓글 자동증가 생성 후 insert
			if (boardReply != null) {
				boardReply.setBoardReplyCode(boardService.getNewBoardReplyNum());
				boardService.addComment(boardReply);
				
			}
			
		return "redirect:/board/boardView?boardNum=" + boardNum;
	}
	
	
	
	
	
	//공지사항 게시글 조회
	@GetMapping("/boardNoticeView")
	public String boardNoticeView(Model model
								,@RequestParam(name = "boardNum" , required = false) String boardNum
								,@RequestParam(name = "boardReplyCode", required = false) String boardReplyCode
								,HttpSession session) {
		
		//게시물 정보 가져오기
		Board board = boardService.getBoardInfoByCode(boardNum);
		//조회 수 증가
		Integer boardCnt = 0;
		boardCnt = boardService.updateBoardCnt(boardNum);
		//로그인 아이디 가져오기
		String memberId = (String) session.getAttribute("SID");
		//게시글 댓글 목록
		List<BoardReply> boardCommentList = boardService.getBoardCommentList(boardNum);
		
		
		model.addAttribute("boardCommentList", boardCommentList);	
		model.addAttribute("title", "공지사항 게시판 조회");
		model.addAttribute("board", board);
		model.addAttribute("boardCnt", boardCnt);
		model.addAttribute("memberId", memberId);
		
		return "/board/boardNoticeView"; 
	}
	
	//소상공인 게시글 조회
	@GetMapping("/boardBizView")
	public String boardBizView(Model model
			,@RequestParam(name = "boardNum" , required = false) String boardNum
			,@RequestParam(name = "boardReplyCode", required = false) String boardReplyCode
			,HttpSession session) {
		
		//게시물 정보 가져오기
		Board board = boardService.getBoardInfoByCode(boardNum);
		//조회 수 증가
		Integer boardCnt = 0;
		boardCnt = boardService.updateBoardCnt(boardNum);
		//로그인 아이디 가져오기
		String memberId = (String) session.getAttribute("SID");
		//게시글 댓글 목록
		List<BoardReply> boardCommentList = boardService.getBoardCommentList(boardNum);
		
		
		model.addAttribute("boardCommentList", boardCommentList);	
		model.addAttribute("title", "소상공인 게시판 조회");
		model.addAttribute("board", board);
		model.addAttribute("boardCnt", boardCnt);
		model.addAttribute("memberId", memberId);
		
		
		return "/board/boardBizView"; 
	}
	
	// 게시글 조회
	@GetMapping("/boardView")
	public String boardView(Model model
			    			,@RequestParam(name = "boardNum" , required = false) String boardNum
			    			,@RequestParam(name = "boardReplyCode", required = false) String boardReplyCode
			    			,HttpSession session) {
		
		//게시물 정보 가져오기
		Board board = boardService.getBoardInfoByCode(boardNum);
		//조회 수 증가
		Integer boardCnt = 0;
		boardCnt = boardService.updateBoardCnt(boardNum);
		//로그인 아이디 가져오기
		String memberId = (String) session.getAttribute("SID");
		//게시글 댓글 목록
		List<BoardReply> boardCommentList = boardService.getBoardCommentList(boardNum);

		
		model.addAttribute("boardCommentList", boardCommentList);	
		model.addAttribute("title", "소비자 게시판 조회");
		model.addAttribute("board", board);
		model.addAttribute("boardCnt", boardCnt);
		model.addAttribute("memberId", memberId);

		
		 return "/board/boardView"; 
		}
	
	
	  //회원 정보 보기 - ajax
	  @GetMapping(value="/memberSearch", produces = "application/json")
	  @ResponseBody 
	  public Member getMemberList(@RequestParam(name="memberId", required = false) String memberId){ 		  
		  Member member = boardService.getMemberRead(memberId);
		  if(member == null) member = new Member();		  		  
		  
		  return member; 
		  
	  }
	  
	
	  //공지사항 게시글 목록
	  @GetMapping("/boardNoticeList")
	  public String boardNoticeList(Model model) {
		  
		List<Board> boardNoticeList = boardService.getBoardNoticeList(); 
		  
		  
		  model.addAttribute("title", "공지사항 목록");
		  model.addAttribute("location", "공지사항");
		  model.addAttribute("boardNoticeList", boardNoticeList); 
		  
		  return "/board/boardNoticeList";
	  }
	  //소상공인 게시글 목록
	  @GetMapping("/boardBizList")
	  public String boardBizList(Model model) {
		
		List<Board> boardBizList = boardService.getBoardBizList();
		
		
		model.addAttribute("title", "소상공인 게시판 목록");
		model.addAttribute("location", "소상공인 게시판");
		model.addAttribute("boardBizList", boardBizList);
		
		return "/board/boardBizList";
	}
		
	  
	  // 소비자 게시글 목록
	@GetMapping("/boardList")
	public String boardList(Model model) {
		List<Board> boardList = boardService.getBoardList();
		
		
		model.addAttribute("title", "게시판 목록");
		model.addAttribute("location", "소비자 게시판");
		model.addAttribute("boardList", boardList);
		
		return "/board/boardList";
	}
	
	// 공지사항 작성 처리
	@PostMapping("/boardNoticeWrite")
	public String boardNoticeWrite(Board board) {
		System.out.println("====================");
		System.out.println(" 커맨드객체 board : " + board);
		System.out.println("====================");
		
		//게시글 자동증가 생성 후 insert
		if (board != null) {
			board.setBoardNum(boardService.getNewBoardNum());
			boardService.boardNoticeWrite(board);
		}
		
		
		return "redirect:/board/boardNoticeList";
	}
	
	// 소상공인 게시글 작성 처리
	@PostMapping("/boardBizWrite")
	public String boardBizWrite(Board board) {
		System.out.println("====================");
		System.out.println(" 커맨드객체 board : " + board);
		System.out.println("====================");
		
		//게시글 자동증가 생성 후 insert
		if (board != null) {
			board.setBoardNum(boardService.getNewBoardNum());
			boardService.boardBizWrite(board);
		}
		
		
		return "redirect:/board/boardBizList";
	}
	
	// 게시글 작성 처리
	@PostMapping("/boardWrite")
	public String boardWrite(Board board) {
		System.out.println("====================");
		System.out.println(" 커맨드객체 board : " + board);
		System.out.println("====================");
		
		//게시글 자동증가 생성 후 insert
		if (board != null) {
			board.setBoardNum(boardService.getNewBoardNum());
			boardService.boardWrite(board);
		}
			
		
		return "redirect:/board/boardList";
	}
	
	
	
	//공지사항 작성 
	@GetMapping("/boardNoticeWrite")
	public String boardNoticeWrite(Model model
			,HttpSession session
			,@RequestParam(name = "boardStatementCode" , required = false) String boardStatementCode) {
		
		//로그인 아이디 가져오기
		String memberId = (String) session.getAttribute("SID");
		
		//상태코드 가져오기
		Statement boardStatement = boardService.getboardStatement(boardStatementCode);
		
		model.addAttribute("title", "공지사항 등록");
		model.addAttribute("memberId", memberId);
		model.addAttribute("boardStatement", boardStatement);
		
		return "/board/boardNoticeWrite";
	}
	
	//소상공인 게시글 작성 
	@GetMapping("/boardBizWrite")
	public String boardBizWrite(Model model
								,HttpSession session
								,@RequestParam(name = "boardStatementCode" , required = false) String boardStatementCode) {
	
		//로그인 아이디 가져오기
		String memberId = (String) session.getAttribute("SID");
		
		//상태코드 가져오기
		Statement boardStatement = boardService.getboardStatement(boardStatementCode);
	
		model.addAttribute("title", "소상공인 게시판 등록");
		model.addAttribute("memberId", memberId);
		model.addAttribute("boardStatement", boardStatement);
		
		return "/board/boardBizWrite";
		}
	
	
	
	// 게시글 작성 
	@GetMapping("/boardWrite")
	public String boardWrite(Model model
							,HttpSession session
							,@RequestParam(name = "boardStatementCode" , required = false) String boardStatementCode) {
	
		
		//로그인 아이디 가져오기
		String memberId = (String) session.getAttribute("SID");
		
		//상태코드 가져오기
		Statement boardStatement = boardService.getboardStatement(boardStatementCode);
	
		model.addAttribute("title", "소비자 게시판 등록");
		model.addAttribute("memberId", memberId);
		model.addAttribute("boardStatement", boardStatement);
		
		return "/board/boardWrite";
		}

}

