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
import model.Product;
import order.service.Service;
import order.service.ServiceImpl;

/**
 * Servlet implementation class MyListController
 */
@WebServlet("/order/myList")
public class MyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Service service = new ServiceImpl();
		product.service.Service p_service = new product.service.ServiceImpl();

		Member m = (Member)session.getAttribute("m");
		
		String id = m.getId();

		ArrayList<Order> o_list = service.selectOList(id);

		ArrayList<Product> p_list = new ArrayList<Product>();
		
		for (Order o : o_list) {
			
			Product p = p_service.getProduct(o.getPro_num());
			
			p_list.add(p);
		}
		
		request.setAttribute("p_list", p_list);
		request.setAttribute("o_list", o_list);
		
		
		
		String path = "/view/order/myList.jsp";

		RequestDispatcher dis = request.getRequestDispatcher(path);
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
