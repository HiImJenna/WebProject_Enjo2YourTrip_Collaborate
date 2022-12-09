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
import kr.co.enjo2.service.member.ChartService;
import kr.co.enjo2.service.notice.NoticeWrite;
import kr.co.enjo2.service.qna.QnaContentEditOkService;
import kr.co.enjo2.service.qna.QnaContentEditViewService;
import kr.co.enjo2.service.qna.QnaContentService;
import kr.co.enjo2.service.qna.QnaDeleteOkService;
import kr.co.enjo2.service.qna.QnaListService;
import kr.co.enjo2.service.qna.QnaReplyOkService;
import kr.co.enjo2.service.qna.QnaReplyViewService;
import kr.co.enjo2.service.qna.QnaViewService;
import kr.co.enjo2.service.qna.QnaWriteService;
import kr.co.enjo2.service.basic.FlightListService;
import kr.co.enjo2.service.basic.MainPageInfoService;
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
import kr.co.enjo2.service.member.MyFlightService;
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
    	}else if(url_Command.equals("/myFlight.do")) {
    		// 나의 모임 현황
    		action = new MyFlightService();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/management.do")) {
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
         } else if(url_Command.equals("/chart.do")) {
             // 공지사항 게시글 수정 완료하기
             action = new ChartService();
             forward = action.execute(request, response);
         } else if(url_Command.equals("/qnaList.do")) {
             // QNA (문의) 리스트 JSON 전달
             action = new QnaListService();
             forward = action.execute(request, response);
         } else if(url_Command.equals("/qnaWriteView.do")) {
             // QNA 작성 페이지 이동
             action = new QnaViewService();
             forward = action.execute(request, response);
         } else if(url_Command.equals("/qnaWriteOk.do")) {
             // QNA 작성 하기
             action = new QnaWriteService();
             forward = action.execute(request, response);
         } else if(url_Command.equals("/qnaContent.do")) {
             // 특정 QNA 보기
             action = new QnaContentService();
             forward = action.execute(request, response);
         } else if(url_Command.equals("/qnaEdit.do")) {
             // 특정 QNA 수정 화면
             action = new QnaContentEditViewService();
             forward = action.execute(request, response);
         } else if(url_Command.equals("/qnaEditOk.do")) {
             // 특정 QNA 수정 요청
             action = new QnaContentEditOkService();
             forward = action.execute(request, response);
         } else if(url_Command.equals("/qnaDelete.do")) {
             // 특정 QNA 삭제 요청
             action = new QnaDeleteOkService();
             forward = action.execute(request, response);
         } else if(url_Command.equals("/mainInfo.do")) {
             // 메인 페이지 비동기 정보 전달
             action = new MainPageInfoService();
             forward = action.execute(request, response);
         } else if(url_Command.equals("/flightList.do")) {
          // 승객예매정보 이전, 번호, 이후 리스트 볼수 있음(관리자 기능)
          action = new FlightListService();
          forward = action.execute(request, response);
        } else if(url_Command.equals("/qnaReplyView.do")) {
             // QnA 답글 페이지 요청
             action = new QnaReplyViewService();
             forward = action.execute(request, response);
         } else if(url_Command.equals("/qnaReplyWriteOk.do")) {
             // QnA 답글 작성
             action = new QnaReplyOkService();
             forward = action.execute(request, response);
         }
    	
    	if(forward != null) {
    		// forward 및 redirect 처리
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		} else {
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
