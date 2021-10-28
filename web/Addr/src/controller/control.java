package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import service.EventService;

/**
 * Servlet implementation class control
 */
@WebServlet("/control")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public control() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		String resultView = "addr/";
		EventService service = new EventService();
		if (type.equals("insert")) {
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			int postal = Integer.parseInt((request.getParameter("postal")));

			Member vo = new Member(0, name, tel, address, postal);
			service.insert(vo);
			resultView += "index.jsp";
		} else if (type.equals("list")) {
			ArrayList<Member> data = service.list();
			request.setAttribute("data", data);
			resultView += "list.jsp";
		} else if (type.equals("update")) {
			int sno = Integer.parseInt((request.getParameter("num")));
			Member m = service.getMember(sno);
			request.setAttribute("m", m);
			resultView += "update";
		} else if (type.equals("edit")) {
			int sno = Integer.parseInt((request.getParameter("num")));
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			int postal = Integer.parseInt((request.getParameter("postal")));

			Member vo = new Member(sno, name, tel, address, postal);
			service.edit(vo);
		} else if (type.equals("delete")) {
			int num = Integer.parseInt((request.getParameter("num")));
			service.delete(num);
			resultView = "control?type=list";
		}
		RequestDispatcher dis = request.getRequestDispatcher(resultView);
		dis.forward(request, response);
	}

}
