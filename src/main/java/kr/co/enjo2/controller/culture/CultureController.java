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
       
    public CultureController() {
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response, String HttpMethodType) throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if (url_Command.equals("/mainView.culture")) {
   
    		action = new CultureMainViewService();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/culture-gathering.culture")) {
 
    		action = new CultureGathering();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/culture-review.culture")) {
 
    		action = new CultureReview();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/writePage.culture")) {

    	    action = new CultureWritePage();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/write.culture")) {
 
    		action = new CultureWrite();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/culture-gathering-detail.culture")) {
    		
            
    		action = new CultureGatheringDetail();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/culture-gathering-comment-write.culture")) {
 
    		action = new CultureCommentWrite();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/culture-gathering-join.culture")) {
    		
    		action = new CultureJoin();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/culture-gathering-board-update-page.culture")) {
    		
    		action = new CultureUpdatePage();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/culture-gathering-board-update.culture")) {
    		
    		action = new CultureUpdate();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/culture-gathering-board-comment-delete.culture")) {
    		 
    	    action = new CultureCommentDelete();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/culture-place-search.culture")) {

   		    action = new CultureReview();
	   		forward = action.execute(request, response);
	   		
	   	}else if(url_Command.equals("/culture-review-comment.culture")) {   		
   		  
   		    action = new CultureReviewComment();
	   		forward = action.execute(request, response);
	   		
	   	}else if(url_Command.equals("/culture-review-detail.culture")) {
 
    		action = new CultureReviewDetail();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/culture-review-write.culture")) {
 
    		action = new CultureReviewWrite();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/culture-join-list.culture")) {
    		
    		action = new CultureJoinlist();
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/culture-join-list-delete.culture")) {
    		
             action = new CultureJoinlistDelete();
    		 forward = action.execute(request, response);
    		 
    	}else if(url_Command.equals("/culture-Review-list.culture")) {
    		
            action = new CultureReviewList();
   		    forward = action.execute(request, response);
   	    }else if(url_Command.equals("/culture-gathering-join-from-list.culture")) {
    		
            action = new CultureJoinFromJoinList();
   		    forward = action.execute(request, response);
   	    }else if(url_Command.equals("/culture-gathering-join-from-culture-place.culture")) {
    		
            action = new CultureJoinFromCulturePlace();
   		    forward = action.execute(request, response);
   		    
   	    }else if(url_Command.equals("/culture-gathering-detail-from-join.culture")) {
    		
            action = new CultureGatheringDetailFromJoin();
   		    forward = action.execute(request, response);
   	    }
   	    
   	    
   	    else if(url_Command.equals("/culture-gathering-board-delete.culture")) {
    		
            action = new CultureMeetBoardDelete();
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
