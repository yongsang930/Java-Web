package product.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Product;
import product.service.Service;
import product.service.ServiceImpl;

/**
 * Servlet implementation class AddController
 */
@WebServlet("/seller/Add")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddController() {
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
		Service service = new ServiceImpl();
		HttpSession session = request.getSession(false);
//		"C:\\JSP\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\shop_img\\";
		// D:\yonsang\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\webapps\shop_img

		String s_id = (String) session.getAttribute("id");
		Product p = new Product();
		p.setS_id(s_id);
		p.setNum(service.makeNum());

		String img = "";

		int maxSize = 1024 * 1024 * 10;

		MultipartRequest multi = null;

		String uploadPath = "D:\\yonsang\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\shop_img";

		try {
			multi = new MultipartRequest(request, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());

			p.setName(multi.getParameter("name"));
			p.setQuantity((Integer.valueOf(multi.getParameter("quantity"))));
			p.setPrice((Integer.valueOf(multi.getParameter("price"))));
			p.setContent(multi.getParameter("content"));

			// 작성된 파일에 대한 이름들을 가져옴
			Enumeration files = multi.getFileNames();

			while (files.hasMoreElements()) {
				String file1 = (String) files.nextElement();

				// 해당하는 파일들의 이름을 가져옴
				img = multi.getOriginalFileName(file1);

				// 파일 업로드
				File file = multi.getFile(file1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 경로를 세팅
		p.setImg("/shop_img/" + img);
		service.add(p);
//		RequestDispatcher dis = request.getRequestDispatcher("/seller/List");
//		dis.forward(request, response);
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
