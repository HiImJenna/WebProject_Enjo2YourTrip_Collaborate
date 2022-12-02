package kr.co.enjo2.service.notice;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.notice.NoticeDao;
import kr.co.enjo2.dto.notice.NoticeDto;

public class NoticeListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			int page = Integer.parseInt(request.getParameter("page"));
			
			NoticeDao dao = new NoticeDao();
			
			List<NoticeDto> noticeArr = dao.findAllByPage(page);

			JSONArray noticeList = new JSONArray();
			for (NoticeDto n : noticeArr) {
				JSONObject obj = new JSONObject();
				obj.put("number", n.getNoticeNo());
				obj.put("title", n.getTitle());
				obj.put("writer", n.getMemberId());
				obj.put("date", n.getCreatedAt());
				// 조회수 수정 필요
				obj.put("count", n.getCount());
				//JSONOBJ.put("가나다","123");
				//JSONOBJ = {가나다 : 123 , 가나다 :123 }
				noticeList.add(obj);
			}
			//[{가나다 : 123 , 가나다 :123 },{가나다 : 123 , 가나다 :123 },{가나다 : 123 , 가나다 :123 }]
			//////////// 페이지 계산 ////////////
			
			// 게시글의 총 수
			int totalCount = dao.getTotalCount();
			
			// 총 페이지의 수
			int numOfTotalPage = (totalCount / 10) + ( (totalCount % 10 == 0) ? 0 : 1);
			
			int start = 0;
			int end = 0;
			
			for(int n = 1; ; ++n) {
				start = 5 * n - 4;
				end = 5 * n;
				if (start <= page && page <= end) {
					break;
				}
			}
			
			int prev = 1;
			int next = 1;
			
			if (start == 1) {
				prev = 0;
			}
			
			end = Math.min(end, numOfTotalPage);
			if (end == numOfTotalPage) {
				next = 0;
			}
			
			JSONObject pageObj = new JSONObject();
			pageObj.put("prev", String.valueOf(prev));
			pageObj.put("next", String.valueOf(next));
			pageObj.put("start", String.valueOf(start));
			pageObj.put("end", String.valueOf(end));
			
			//////////// 페이지 계산 끝 /////////////

			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			obj.put("noticeList", noticeList);
			obj.put("pageInfo", pageObj);
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
