package step5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet6
 */
@WebServlet("/MyServlet6")
public class MyServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//request ��ü�� ���� ���� 
		//���� ��û�� ���� ������ ���޵Ǳ� ������ ��ȿ
		request.setAttribute("requestInfo", "test1");
		
		//���� session ��ü ȹ��
		HttpSession session = request.getSession();
		
		//session�� ���� ���� 
		//Ŭ���̾�Ʈ�� ������ ���� ������ ��ȿ
		session.setAttribute("sessionInfo", "test2");
		
		//ServletContext ��ü ȹ��. ���ø����̼� ��ü�� ���� ���� ����
		ServletContext application = getServletContext();
		
		//application ��ü�� ����
		//�� ���ø����̼��� ������ ������ ��� ������ ����
		application.setAttribute("applicationInfo", "test3");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/MyServlet7");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
