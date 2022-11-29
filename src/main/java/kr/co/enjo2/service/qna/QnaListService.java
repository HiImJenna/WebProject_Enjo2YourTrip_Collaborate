package kr.co.enjo2.service.qna;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.qna.QnaDao;
import kr.co.enjo2.dto.qna.QnaDto;

public class QnaListService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
		
		try {
			String pageStr = request.getParameter("page");
			int page = (pageStr == null) ? 1 : Integer.parseInt(pageStr);
			
			QnaDao qnaDao = new QnaDao();
			List<QnaDto> qnaArr = qnaDao.findAllByPage(page);

			//조회수가 필요함!!!
//QnaDto [qnaNo=7, memberId=user2, qnaRef=7, title=문의글_2, content=이 글은 테스트 문의글2 입니다., createdAt=2022-11-28 00:05]
//QnaDto [qnaNo=8, memberId=admin, qnaRef=7, title=문의글_2의 답글_1, content=이 글은 테스트 문의글_2의 답글_1 입니다., createdAt=2022-11-28 00:05]
//QnaDto [qnaNo=9, memberId=user2, qnaRef=7, title=문의글_2의 답글_2, content=이 글은 테스트 문의글_2의 답글_2 입니다., createdAt=2022-11-28 00:05]
//QnaDto [qnaNo=10, memberId=admin, qnaRef=7, title=문의글_2의 답글_3, content=이 글은 테스트 문의글_2의 답글_3 입니다., createdAt=2022-11-28 00:05]
//QnaDto [qnaNo=11, memberId=user2, qnaRef=7, title=문의글_2의 답글_4, content=이 글은 테스트 문의글_2의 답글_4 입니다., createdAt=2022-11-28 00:05]
//QnaDto [qnaNo=1, memberId=user1, qnaRef=1, title=문의글_1, content=이 글은 테스트 문의글1 입니다., createdAt=2022-11-28 00:05]
//QnaDto [qnaNo=2, memberId=admin, qnaRef=1, title=문의글_1의 답글_1, content=이 글은 테스트 문의글1의 답글_1 입니다., createdAt=2022-11-28 00:05]
//QnaDto [qnaNo=3, memberId=user1, qnaRef=1, title=문의글_1의 답글_2, content=이 글은 테스트 문의글1의 답글_2 입니다., createdAt=2022-11-28 00:05]
//QnaDto [qnaNo=4, memberId=admin, qnaRef=1, title=문의글_1의 답글_3, content=이 글은 테스트 문의글1의 답글_3 입니다., createdAt=2022-11-28 00:05]
//QnaDto [qnaNo=5, memberId=user1, qnaRef=1, title=문의글_1의 답글_4, content=이 글은 테스트 문의글1의 답글_4 입니다., createdAt=2022-11-28 00:05]
//QnaDto [qnaNo=6, memberId=admin, qnaRef=1, title=문의글_1의 답글_5, content=이 글은 테스트 문의글1의 답글_5 입니다., createdAt=2022-11-28 00:05]
			
			int len = qnaArr.size();
			int ref = -1;
			JSONArray qnaList = new JSONArray();
			for(int i = 0; i < len; ++i) {
				int arrRef = qnaArr.get(i).getQnaRef();
				if (ref != arrRef) {
					i = makeJsonQnaList(qnaArr, qnaList, i, arrRef);
					ref = arrRef;
				}
			}
			
			//////////////////// 페이지 계산 ////////////////////////
			
			// 계시글 수 DB에서 얻기 (무조건 부모 기준)
			//int totalPageCount = qnaDao.getTotalCount();
			int totalPageCount = 2;
			
			int numOfTotalPage = (totalPageCount / 10) + ( (totalPageCount % 10 == 0) ? 0 : 1);
			
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
			
			//////////////////  페이지 계산 ////////////////////////
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			obj.put("qnaList", qnaList);
			obj.put("pageInfo", pageObj);
			String result = obj.toJSONString();
			out.print(result);
			response.setStatus(200);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return forward;
	}
	
	private int makeJsonQnaList(List<QnaDto> qnaArr, JSONArray qnaList, int idx, int ref) {
		int size = qnaArr.size();
		JSONObject parent = makeJsonQna(qnaArr.get(idx++));
		JSONArray child = new JSONArray();
		for(; idx < size; ++idx) {
			if (ref != qnaArr.get(idx).getQnaRef()) {
				break;
			}
			child.add(makeJsonQna(qnaArr.get(idx)));
		}
		parent.put("child", child);
		qnaList.add(parent);
		return idx - 1;
	}
	
	private JSONObject makeJsonQna(QnaDto qna) {
		JSONObject obj = new JSONObject();
		obj.put("no", qna.getQnaNo());
		obj.put("title", qna.getTitle());
		obj.put("writer", qna.getMemberId());
		obj.put("date", qna.getCreatedAt());
		// 임시
		obj.put("count", "0");
		return obj;
	}
}
