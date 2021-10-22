package step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */

/*������ �����̳ʿ� ��� �Ѵ� name�� ���� �̸� ,urlPatterns�� �� ������ URL�� �����Ѵ�. 
 InitParam�� �ʱ�ȭ �Ķ���͸� �����ϴ� WebServlet�� �ۼ��̴�. �� �Ӽ��� �ʱ�ȭ �Ķ���� ����Ʈ
 �� �ۼ��Ѵ�. �� �Ķ���ʹ� @WebInitParam������̼����� �����ϰ� name�� �Ķ������ �̸�,value�� 
 ���� ��Ÿ���� �Ӽ� �̴�.   
 * */
@WebServlet(name = "MyServlet", urlPatterns = { "/MyServlet" }, initParams = {
		@WebInitParam(name = "param1", value = "value1"),
		@WebInitParam(name = "param2", value = "value2") })
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
/*��ü �Ҹ�ÿ� ȣ��ȴ�. 
 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
/*init()�� ��ü ������ �ѹ� ȣ��ȴ�. �Ķ���Ͱ� ���� ���� ����ص� �ǰ� ServletConfig��ü�� �ϳ� �ִ� ���� ��� �� 
 * �� �ִ�. ServletConfig��ü�� �ϳ� �ִ� ���� ����� �� �ִ�. ServletConfig ��ü�� ���� ��ü���� �ϳ��� 
 * �Ҵ�ȴ�. �׷��� ServletConfig ��ü�� ���� ���� ���� �ȿ����� ����� ������ �ʱ�ȭ �Ķ���� �� ���� �ϴ� �뵵�� 
 * ���ȴ�.  
 * ServletConfig�� getInitParameter()�޼���� �ʱ�ȭ �Ķ���͸� �Ķ���� �̸����� �˻��Ѵ� 
 *  getInitParameterName()�޼���� �ʱ�ȭ �Ķ���� ��ü �̸��� �˻��Ͽ� Enumeration ���·� ��ȯ�Ѵ�.  
  * */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println(config.getInitParameter("param1"));
		System.out.println(config.getInitParameter("param2"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		out.print("<html><body>name=" + name + "</body></html>");
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
