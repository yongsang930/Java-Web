package member.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.Service;
import member.service.ServiceImpl;
import model.Member;


/**
 * Servlet implementation class JoinController
 */
@WebServlet("/JoinController")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinController() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("postcode")+" "+request.getParameter("r_addr")+" "+ request.getParameter("d_addr");
		int type = (Integer.parseInt(request.getParameter("type")));
		
		Service service = new ServiceImpl();
		
		boolean chk = service.check(id);
		
		if(!chk) {
		service.join(new Member(id,pwd,name,email,address,type));
		session.setAttribute("chk", chk);
		}
		else {
			String dupl = "중복된 아이디가 있습니다.";
			
			session.setAttribute("dupl", dupl);
			
			RequestDispatcher dis = request.getRequestDispatcher("/view/member/form.jsp");
			dis.forward(request, response);
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("/view/member/loginForm.jsp");
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
