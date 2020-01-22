package com.lntegrated.board_fr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lntegrated.board_fr.dao.BoardFrDao;
import com.lntegrated.board_fr.dto.BoardFrDto;

/**
 * Servlet implementation class BoardFrServlet
 */
@WebServlet("/BoardFrServlet")
public class BoardFrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String command = request.getParameter("command");
		BoardFrDao dao = new BoardFrDao();


		if(command.equals("boardlist")) {
			List<BoardFrDto> list = dao.boardFrList();
			request.setAttribute("list", list);

			dispatch("commu_fr.jsp", request, response);
		}

		else if(command.equals("select")) {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			BoardFrDto dto = dao.boardFrInfo(board_no);
			request.setAttribute("dto", dto);

			dispatch("commu_frselect.jsp", request, response);

		}

		else if(command.equals("insertform")) {
			dispatch("commu_frinsertform.jsp", request, response);
		}
		else if(command.equals("insertres")) {
			String id_u = request.getParameter("id_u");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			BoardFrDto dto = new BoardFrDto(id_u, title, content);

			int res = dao.boardInsert(dto);
			if(res > 0) {
				jsResponse("작성되었습니다.", "BoardFrServlet?command=boardlist", response);
			}
			else {
				jsResponse("작성 실패", "BoardFrServlet?command=boardlist", response);
			}
		}
		else if(command.equals("updateform")) {
			dispatch("commu_frupdate", request, response);
		}
		else if(command.equals("updateres")) {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			String id_u = request.getParameter("id_u");
			String title = request.getParameter("title");
			String content = request.getParameter("content");


			BoardFrDto dto = new BoardFrDto(board_no, id_u, title, content);

			int res = dao.boardUpdateInfo(dto);
			if(res >0) {
				jsResponse("수정되었습니다.", "BoardFrServlet?command=boardlist", response);
			}
			else {
				jsResponse("수정 실패", "BoardFrServlet?command=boardlist", response);
			}
		}
		else if(command.equals("delete")) {
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
