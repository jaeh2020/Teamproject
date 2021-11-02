package amdn.anywhere.interceptor;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//세션의 정보가 없으면 로그인페이지로 이동
		HttpSession session = request.getSession();
		
		// 아이디
		String sessionId = (String) session.getAttribute("SID");
		// 레벨정보
		String sessionLv = (String) session.getAttribute("SLEVEL");	
		
		String sessionLevel = "";		
		if(sessionLv != null) sessionLevel = (String) session.getAttribute("SLEVEL");
		
		// URI 정보
		String requestUri = request.getRequestURI();
		
		log.info("sessionLevel : {}", sessionLevel);
		
		if(sessionId == null || sessionLevel.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter printwriter = response.getWriter();

			printwriter.print("<script>alert('로그인이 필요합니다!'); window.location.href='/member/login';</script>");
			printwriter.flush();
			printwriter.close();

			return false;
		}else {
			requestUri	 = requestUri.trim();
			
			//권한에 따른 주소 설정 ( 권한에 해당하는 주소가 아닐 시 메인페이지로 이동 )
			//관리자일경우
			if(sessionLevel.equals("level_admin")) {
				if(requestUri.indexOf("/taster/myApplyForTaster") 	  > -1 ||
				   requestUri.indexOf("/taster//applyTaster")         > -1	) {
					
					response.setContentType("text/html; charset=UTF-8");

					PrintWriter printwriter = response.getWriter();

					printwriter.print("<script>alert('권한이 없습니다!');history.go(-1);</script>");
					printwriter.flush();
					printwriter.close();
					return false;
				}
			}
			//소비자일경우
			if(sessionLevel.equals("level_user")) {
				if( requestUri.indexOf("/event/eventManage") 	  > -1 ||
					requestUri.indexOf("/taster/applyRecruit")    > -1 ||
					requestUri.indexOf("/taster/myRecruitList")   > -1 ||
					requestUri.indexOf("/taster/recruitList")     > -1 ||
					requestUri.indexOf("/survey/questionManage")  > -1 ||
					requestUri.indexOf("/survey/surveyList")      > -1 ||
					requestUri.indexOf("/survey/surveyResult")    > -1 ||
					requestUri.indexOf("/admin")   				  > -1 ||
					requestUri.indexOf("/taster/tasterList")      > -1    ) {
					
					response.setContentType("text/html; charset=UTF-8");

					PrintWriter printwriter = response.getWriter();

					printwriter.print("<script>alert('권한이 없습니다!');history.go(-1);</script>");
					printwriter.flush();
					printwriter.close();
					return false;
				}
			}
			
			if(sessionLevel.equals("level_biz")) {
				if( requestUri.indexOf("/event/eventManage") 	  		> -1 ||
						requestUri.indexOf("/taster/myApplyForTaster")  > -1 ||
						requestUri.indexOf("/taster/recruitList")       > -1 ||
						requestUri.indexOf("/survey/questionManage")    > -1 ||
						requestUri.indexOf("/survey/surveyList")        > -1 ||
						requestUri.indexOf("/taster/recruitDetail")     > -1 ||
						requestUri.indexOf("/admin")     				> -1 ||
						requestUri.indexOf("/taster/tasterList")        > -1    ) {
					
					response.setContentType("text/html; charset=UTF-8");

					PrintWriter printwriter = response.getWriter();

					printwriter.print("<script>alert('권한이 없습니다!');history.go(-1);</script>");
					printwriter.flush();
					printwriter.close();

					return false;
				}
			}
			
		}
		return true;
	}

}
