package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import board.service.Service;
import board.service.ServiceImpl;
import model.Board;
import model.Member;
import model.Product;
import oracle.net.aso.p;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/ListController")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListController() {
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
		HttpSession session = request.getSession(false);
		Service service = new ServiceImpl();
		product.service.Service p_service = new product.service.ServiceImpl();
		order.service.Service o_service = new order.service.ServiceImpl();
		
		
		
		
		ArrayList<Integer> o_Nlist = o_service.orderPNum((String.valueOf(session.getAttribute("id"))));
		ArrayList<String> p_list = new ArrayList<String>();
		for (Integer i : o_Nlist) {
			p_list = p_service.getProductName(i);
		}
		
		ArrayList<Board> b_list = service.getAll();

		session.setAttribute("b_list", b_list);
		session.setAttribute("p_list", p_list);

		RequestDispatcher dis = request.getRequestDispatcher("/view/board/list.jsp");
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
