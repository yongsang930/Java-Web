package order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.Order;
import order.service.Service;
import order.service.ServiceImpl;

/**
 * Servlet implementation class ListAllController
 */
@WebServlet("/ListAllController")
public class ListAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListAllController() {
		super();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		Service service = new ServiceImpl();
		Member m = (Member)session.getAttribute("m");
		ArrayList<Order> o_AllList = service.sellerPrAll(m.getId());
		
		session.setAttribute("o_AllList", o_AllList);
		
		RequestDispatcher dis = request.getRequestDispatcher("/view/seller/listAll.jsp");
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
