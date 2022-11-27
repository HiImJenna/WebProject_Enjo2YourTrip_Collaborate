package kr.co.enjo2.controller.basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.service.notice.NoticeWrite;
import kr.co.enjo2.service.member.JoinViewService;
import kr.co.enjo2.service.member.ManagementService;
import kr.co.enjo2.service.member.MemberEditOkService;
import kr.co.enjo2.service.member.MemberEditService;
import kr.co.enjo2.service.member.MemberLoginOkService;
import kr.co.enjo2.service.member.MemberLoginViewService;
import kr.co.enjo2.service.member.MemberLogoutService;
import kr.co.enjo2.service.member.MemberRegisterOkService;
import kr.co.enjo2.service.member.MemberUnregisterOkService;
import kr.co.enjo2.service.member.MemberUnregisterService;
import kr.co.enjo2.service.member.MyMeetingService;
import kr.co.enjo2.service.member.MyMenuService;
import kr.co.enjo2.service.member.NickNameCheckService;
import kr.co.enjo2.service.notice.NoticeAddService;
import kr.co.enjo2.service.notice.NoticeContentService;
import kr.co.enjo2.service.notice.NoticeDeleteOkService;
import kr.co.enjo2.service.notice.NoticeEditOkService;
import kr.co.enjo2.service.notice.NoticeEditService;
import kr.co.enjo2.service.notice.NoticeListService;

@WebServlet({ "/BasicController", "*.do" })
public class BasicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BasicController() {}
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response, String HttpMethodType) throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(url_Command.equals("/loginView.do")) {
    		// 로그인 페이지 가기
    		action = new MemberLoginViewService();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/loginOk.do")) {
    		// 로그인 하기 (로그인 요청)
    		action = new MemberLoginOkService();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/logout.do")) {
    		// 로그아웃 하기
    		action = new MemberLogoutService();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/joinView.do")) {
    		// 회원가입 페이지 가기
    		action = new JoinViewService();
    		forward = action.execute(request, response);
    	}  else if(url_Command.equals("/joinOk.do")) {
    		// 회원가입 하기 (회원가입 요청)
    		action = new MemberRegisterOkService();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/myMenu.do")) {
    		// 마이 메뉴
    		action = new MyMenuService();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/myMeeting.do")) {
    		// 나의 모임 현황
    		action = new MyMeetingService();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/management.do")) {
    		// 공지사항
    		action = new ManagementService();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/memberEdit.do")) {
    		// 회원정보 수정 페이지 가기
    		action = new MemberEditService();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/memberEditOk.do")) {
    		// 회원정보 수정 요청
    		action = new MemberEditOkService();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/memberUnregister.do")) {
    		// 회원탈퇴 페이지 가기
    		action = new MemberUnregisterService();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/memberUnregisterOk.do")) {
    		// 회원탈퇴 요청
    		action = new MemberUnregisterOkService();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/noticeWrite.do")) {
    		// 글쓰기 페이지
    		action = new NoticeWrite();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/noticeWriteOk.do")) {
    		//공지사항 글쓰기
    		action = new NoticeAddService();
    		forward = action.execute(request, response);
		} else if(url_Command.equals("/noticeList.do")) {
    		// 공지사항 이전, 번호, 이후 리스트 볼수 있음
    		action = new NoticeListService();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/checkNickname.do")) {
    		// 닉네임 확인
    		action = new NickNameCheckService();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/noticeContent.do")) {
            //공지사항 글 확인 
            action = new NoticeContentService();
            forward = action.execute(request, response); 
         } else if(url_Command.equals("/noticeEdit.do")) {
             // 공지사항 게시글 수정하기
             action = new NoticeEditService();
             forward = action.execute(request, response);
         } else if(url_Command.equals("/noticeEditOk.do")) {
             // 공지사항 게시글 수정 완료하기
             action = new NoticeEditOkService();
             forward = action.execute(request, response);
             // noticeDelete.do
         } else if(url_Command.equals("/noticeDelete.do")) {
             // 공지사항 게시글 수정 완료하기
             action = new NoticeDeleteOkService();
             forward = action.execute(request, response);
         }
    	
    	
    	if(forward != null) {
    		if(forward.isRedirect()) { //true 
    			response.sendRedirect(forward.getPath());
    		} else { //false (모든 자원 ) 사용
    			//UI
    			//UI + 로직
    			//forward url 주소 변환 없어 View 내용을 받을 수 있다
    			RequestDispatcher dis  = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "POST");
	}

}
