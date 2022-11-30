package kr.co.enjo2.service.basic;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.notice.NoticeDao;
import kr.co.enjo2.dao.qna.QnaDao;
import kr.co.enjo2.dto.notice.NoticeDto;
import kr.co.enjo2.dto.qna.QnaDto;

public class MainPageInfoService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			
			System.out.println("=======================");
			System.out.println("MainPageInfoService");
			
			NoticeDao noticeDao = new NoticeDao();
			QnaDao qnaDao = new QnaDao();
			
			List<NoticeDto> list1 = noticeDao.findMainInfo();
			List<QnaDto> list2 = qnaDao.findMainInfo();
			System.out.println(list1);
			System.out.println(list2);
			
			JSONArray noticeList = new JSONArray();
			for(NoticeDto n : list1) {
				JSONObject obj = new JSONObject();
				obj.put("no", n.getNoticeNo());
				obj.put("title", n.getTitle());
				obj.put("date", n.getCreatedAt());
				noticeList.add(obj);
			}
			JSONArray qnaList = new JSONArray();
			for(QnaDto n : list2) {
				JSONObject obj = new JSONObject();
				obj.put("no", n.getQnaNo());
				obj.put("title", n.getTitle());
				obj.put("date", n.getCreatedAt());
				qnaList.add(obj);
			}
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			obj.put("noticeList", noticeList);
			obj.put("qnaList", qnaList);
			String result = obj.toJSONString();
			out.print(result);
			response.setStatus(200);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.setStatus(400);
		}
		
		return null;
	}
}
