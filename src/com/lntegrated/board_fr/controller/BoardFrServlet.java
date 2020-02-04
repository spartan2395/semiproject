package com.lntegrated.board_fr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lntegrated.board_fr.dao.BoardFrDao;
import com.lntegrated.board_fr.dao.Pagemaker;
import com.lntegrated.board_fr.dto.BoardFrDto;
import com.lntegrated.comments.dao.CommDao;
import com.lntegrated.comments.dto.CommDto;

/**
 * Servlet implementation class BoardFrServlet
 */
@WebServlet("/BoardFrServlet")
public class BoardFrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String command = request.getParameter("command");
		BoardFrDao dao = new BoardFrDao();


		if(command.equals("boardlist")) {
			List<BoardFrDto> list = dao.boardFrList();
			
//			Pagemaker pagemaker = new Pagemaker();
//			String pagenum = request.getParameter("pagenum");
//			if(pagenum==null) {
//				pagenum=""+1;
//			}
//			int cpagenum = Integer.parseInt(pagenum);
//
//			pagemaker.setTotalcount(list.size());
//			pagemaker.setPagenum(cpagenum-1);
//			pagemaker.setCurrentblock(cpagenum);
//			pagemaker.setLastblock(pagemaker.getTotalcount());
//			
//			pagemaker.prevnext(cpagenum);
//			pagemaker.setStartPage(pagemaker.getCurrentblock());
//			pagemaker.setEndPage(pagemaker.getLastblock(), pagemaker.getCurrentblock());
//			
			request.setAttribute("list", list);
//			request.setAttribute("page", pagemaker);

			dispatch("commu_fr.jsp", request, response);
		}

		
		else if(command.equals("select")) {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			dao.boardUpadteViews(board_no);
			BoardFrDto dto = dao.boardFrInfo(board_no);
			CommDao cdao = new CommDao();
			List<CommDto> list =cdao.commList(board_no);
			request.setAttribute("dto", dto);
			request.setAttribute("list", list);

			dispatch("commu_frselect.jsp", request, response);

		}

		else if(command.equals("insertform")) {
			dispatch("commu_frinsert.jsp", request, response);
		}
		else if(command.equals("insertres")) {
			String id_u = request.getParameter("id_u");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			BoardFrDto dto = new BoardFrDto(id_u, title, content);
			// int board_no = dto.getBoard_no();->0

			int res = dao.boardInsert(dto);
			if(res > 0) {
				jsResponse("작성되었습니다.", "BoardFrServlet?command=boardlist", response);
			}
			else {
				jsResponse("작성 실패", "BoardFrServlet?command=boardlist", response);
			}
		}
		else if(command.equals("updateform")) {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			BoardFrDto dto = dao.boardFrInfo(board_no);
			request.setAttribute("dto", dto);
			dispatch("commu_frupdate.jsp", request, response);
		}
		else if(command.equals("updateres")) {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			String id_u = request.getParameter("id_u");
			String title = request.getParameter("title");
			String content = request.getParameter("content");


			BoardFrDto dto = new BoardFrDto(board_no, id_u, title, content);

			int res = dao.boardUpdateInfo(dto);
			if(res >0) {
				jsResponse("수정되었습니다.", "BoardFrServlet?command=select&board_no="+board_no, response);
			}
			else {
				jsResponse("수정 실패", "BoardFrServlet?command=boardlist", response);
			}
		}

		else if(command.equals("delete")) {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			CommDao commdao = new CommDao();
			CommDto commdto = new CommDto(board_no);
			int childres = commdao.commAllDelete(commdto);
			
			int res = dao.boardDelete(board_no);
			
			if(res >0) {
				if(childres>0) {
					jsResponse("삭제되었습니다.", "BoardFrServlet?command=boardlist", response);
				}else {
					jsResponse("삭제되었습니다.", "BoardFrServlet?command=boardlist", response);
				}
			}
			else {
				jsResponse("삭제 실패", "BoardFrServlet?command=boardlist", response);
			}
		} else if(command.equals("search")) {
			String title_search = request.getParameter("search_qtext");
			List<BoardFrDto> searchlist = dao.boardFrSearchList(title_search);
					
		}


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		doGet(request, response);
	}
	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String s = "<script type = 'text/javascript'>"
					+ "alert('" + msg + "');"
					+ "location.href = '"+url+"';"
					+ "</script>";
		PrintWriter out = response.getWriter();
		out.println(s);
	}
}
