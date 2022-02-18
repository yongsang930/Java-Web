package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sun.swing.internal.plaf.metal.resources.metal;

import board.service.Service;
import board.service.ServiceImpl;
import model.Board;
import model.Member;

/**
 * Servlet implementation class EditBoardController
 */
@WebServlet("/EditBoardController")
public class EditBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditBoardController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Service service = new ServiceImpl();
		HttpSession session = request.getSession();
		
		int num = Integer.valueOf(request.getParameter("num"));
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		String img =  request.getParameter("pname");
		String title = request.getParameter("title");

		Member m = (Member)session.getAttribute("m");
		String type = (String.valueOf(m.getType()));
		String pname = request.getParameter("pname");
		

		Board b = new Board(num, img, title, id, null, content, type, pname);

		service.editBoard(b);

		RequestDispatcher dis = request.getRequestDispatcher("view/board/list.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
