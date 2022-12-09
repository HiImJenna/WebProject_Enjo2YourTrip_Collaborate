package kr.co.enjo2.service.restaurant;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;

public class RestaurantRecommandPizzaService implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
      ActionForward forward = null;
      
      try {
         String userId = (String) request.getSession().getAttribute("userid");
         
         if( userId==null) {
            response.setContentType("text/html; charset=UTF-8");
               PrintWriter out = response.getWriter();
               out.println("</script><script>alert(\'로그인이 필요한 서비스입니다.\'); history.go(-1);</script>");
         }else {
            forward = new ActionForward();
            forward.setPath("/WEB-INF/views/restaurant/restaurantRecommandPizza.jsp");
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      
      
      return forward;
   }

}