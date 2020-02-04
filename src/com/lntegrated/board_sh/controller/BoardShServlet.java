package com.lntegrated.board_sh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lntegrated.board_sh.dao.BoardShDao;
import com.lntegrated.board_sh.dto.BoardShDto;
import com.lntegrated.board_sh.dto.Criteria;
import com.lntegrated.board_sh.dto.PageMaker;


@WebServlet("/BoardShServlet")
public class BoardShServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");		
		
		String command = request.getParameter("command");
		BoardShDao dao = new BoardShDao();
		
		if(command.equals("boardlist")) {
			String paramPage = request.getParameter("page");
			System.out.println(paramPage);

			Criteria cri = new Criteria();
			
			
			if(paramPage==null) {
				cri.setPage(1);
				cri.setPageCount(5);
			} else {
				int page = Integer.parseInt(paramPage);
				cri.setPage(page);
				cri.setPageCount(5);
			}
		
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(dao.countBoard());
			
			List<BoardShDto> list = dao.sharing_List(cri.getPage(), cri.getPageCount());

			request.setAttribute("list", list);
			request.setAttribute("pageMaker", pageMaker);
			
			dispatch("infoshare.jsp", request, response);
		
		}else if(command.equals("insert")) {
			response.sendRedirect("infoshareinsert.jsp");
		}else if(command.equals("insertres")) {
			String id_u = request.getParameter("id_u");
			String hostitle = request.getParameter("hostitle");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			BoardShDto dto =new BoardShDto(id_u, title, content, hostitle);
			
			int res=dao.sharing_insert(dto);
			if(res>0) {
				jsResponse("작성되었습니다.", "BoardShServlet?command=boardlist", response);
			} else {
				jsResponse("작성실패", "BoardShServlet?command=boardlist", response);
			}
			
		}else if(command.equals("select")) {
			int board_sh_no = Integer.parseInt(request.getParameter("board_sh_no"));
			dao.sharing_update_views(board_sh_no);
			BoardShDto dto = dao.sharing_info(board_sh_no);
			request.setAttribute("dto", dto);
			
			dispatch("infoshareselect.jsp", request, response);
		
		} else if(command.equals("update")) {
			int board_sh_no = Integer.parseInt(request.getParameter("board_sh_no"));
			BoardShDto dto = dao.sharing_info(board_sh_no);
			request.setAttribute("dto", dto);
			dispatch("infoshareupdate.jsp", request, response);
			
		} else if(command.equals("updateres")) {
			int board_sh_no = Integer.parseInt(request.getParameter("board_sh_no"));
			String hostitle = request.getParameter("hostitle");
			String id_u = request.getParameter("id_u");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			BoardShDto dto = new BoardShDto(board_sh_no, id_u, title, content, hostitle);
			int res=dao.sharing_update(dto);
			if(res>0) {
				jsResponse("수정되었습니다.", "BoardShServlet?command=select&board_sh_no="+board_sh_no, response);
			}else {
				jsResponse("수정 실패", "BoardShServlet?command=update&board_sh_no="+board_sh_no, response);
			}
		}
		
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