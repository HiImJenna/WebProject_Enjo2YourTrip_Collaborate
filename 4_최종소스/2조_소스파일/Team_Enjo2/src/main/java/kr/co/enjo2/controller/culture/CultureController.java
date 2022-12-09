package kr.co.enjo2.controller.culture;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.service.culture.CultureCommentDelete;
import kr.co.enjo2.service.culture.CultureCommentWrite;
import kr.co.enjo2.service.culture.CultureGathering;
import kr.co.enjo2.service.culture.CultureGatheringDetail;
import kr.co.enjo2.service.culture.CultureGatheringDetailFromJoin;
import kr.co.enjo2.service.culture.CultureJoin;
import kr.co.enjo2.service.culture.CultureJoinFromCulturePlace;
import kr.co.enjo2.service.culture.CultureJoinFromJoinList;
import kr.co.enjo2.service.culture.CultureJoinlist;
import kr.co.enjo2.service.culture.CultureJoinlistDelete;
import kr.co.enjo2.service.culture.CultureMainViewService;
import kr.co.enjo2.service.culture.CultureMeetBoardDelete;
import kr.co.enjo2.service.culture.CultureReview;
import kr.co.enjo2.service.culture.CultureReviewComment;
import kr.co.enjo2.service.culture.CultureReviewDetail;
import kr.co.enjo2.service.culture.CultureReviewList;
import kr.co.enjo2.service.culture.CultureReviewWrite;
import kr.co.enjo2.service.culture.CultureUpdate;
import kr.co.enjo2.service.culture.CultureUpdatePage;
import kr.co.enjo2.service.culture.CultureWrite;
import kr.co.enjo2.service.culture.CultureWritePage;

@WebServlet("*.culture")
public class CultureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CultureController() {}
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response, String HttpMethodType) throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if (url_Command.equals("/mainView.culture")) {
    		// 문화 메인 이동
    		action = new CultureMainViewService();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/culture-gathering.culture")) {
    		// 문화 모임
    		action = new CultureGathering();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/culture-review.culture")) {
    		// 문화 리뷰
    		action = new CultureReview();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/writePage.culture")) {
    		// 글작성 페이지 이동
    	    action = new CultureWritePage();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/write.culture")) {
    		// 글 작성 요청
    		action = new CultureWrite();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/culture-gathering-detail.culture")) {
    		// 문화 모임 상세
    		action = new CultureGatheringDetail();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/culture-gathering-comment-write.culture")) {
    		// 문화 모임 댓글 작성
    		action = new CultureCommentWrite();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/culture-gathering-join.culture")) {
    		// 문화 모임 참여
    		action = new CultureJoin();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/culture-gathering-board-update-page.culture")) {
    		// 문화 모임 게시글 수정 페이지 이동
    		action = new CultureUpdatePage();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/culture-gathering-board-update.culture")) {
    		// 문화 모임 게시글 수정 요청
    		action = new CultureUpdate();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/culture-gathering-board-comment-delete.culture")) {
    		 // 문화 모임 댓글 삭제
    	    action = new CultureCommentDelete();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/culture-place-search.culture")) {
    		// 문화 공간 검색
   		    action = new CultureReview();
	   		forward = action.execute(request, response);
	   	}else if(url_Command.equals("/culture-review-comment.culture")) {   		
	   		// 문화 공간 후기 댓글
   		    action = new CultureReviewComment();
	   		forward = action.execute(request, response);
	   	}else if(url_Command.equals("/culture-review-detail.culture")) {
	   		// 문화 후기 상세
    		action = new CultureReviewDetail();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/culture-review-write.culture")) {
    		// 문화 후기 작성
    		action = new CultureReviewWrite();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/culture-join-list.culture")) {
    		// 문화 참여 리스트
    		action = new CultureJoinlist();
    		forward = action.execute(request, response);
    	}else if(url_Command.equals("/culture-join-list-delete.culture")) {
    		// 문화 참여 삭제
             action = new CultureJoinlistDelete();
    		 forward = action.execute(request, response);
    	}else if(url_Command.equals("/culture-Review-list.culture")) {
    		// 문화 후기 리스트
            action = new CultureReviewList();
   		    forward = action.execute(request, response);
   	    }else if(url_Command.equals("/culture-gathering-join-from-list.culture")) {
   	    	// 문화 모임 참여 리스트
            action = new CultureJoinFromJoinList();
   		    forward = action.execute(request, response);
   	    }else if(url_Command.equals("/culture-gathering-join-from-culture-place.culture")) {
   	    	// 문화 참여 하기
            action = new CultureJoinFromCulturePlace();
   		    forward = action.execute(request, response);
   	    }else if(url_Command.equals("/culture-gathering-detail-from-join.culture")) {
    		// 문화 참여 하기2
            action = new CultureGatheringDetailFromJoin();
   		    forward = action.execute(request, response);
   	    }
   	    else if(url_Command.equals("/culture-gathering-board-delete.culture")) {
   	    	// 모임 게시판 삭제
            action = new CultureMeetBoardDelete();
   		    forward = action.execute(request, response);
   	    }
    	
    	if(forward != null) {
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
