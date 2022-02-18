package product.controller;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import oracle.net.aso.p;
import product.service.Service;
import product.service.ServiceImpl;

/**
 * Servlet implementation class ProdDelController
 */
@WebServlet("/seller/Del")
public class ProdDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProdDelController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Service service = new ServiceImpl();
		
		
		int num = Integer.valueOf(request.getParameter("num"));
		Product p = service.getProduct(num);
		service.delProduct(num);
		String uploadPath = "D:\\yonsang\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\shop_img";
		
		String[] arr = p.getImg().split("/");
		String fname = arr[arr.length-1];
		File f = new File(uploadPath+fname);
		f.delete();
		
		response.sendRedirect("/shop2/seller/List");
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
