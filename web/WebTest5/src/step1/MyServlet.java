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

/*서블릿을 컨테이너에 등록 한다 name은 서블릿 이름 ,urlPatterns은 이 서블릿의 URL을 설정한다. 
 InitParam는 초기화 파라메터를 설정하는 WebServlet의 송석이다. 이 속성에 초기화 파라메터 리스트
 를 작성한다. 각 파라메터는 @WebInitParam어노테이션으로 정의하고 name은 파라메터의 이름,value는 
 값을 나타내는 속성 이다.   
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
/*객체 소멸시에 호출된다. 
 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
/*init()은 객체 생성시 한번 호출된다. 파라메터가 없는 것을 사용해도 되고 ServletConfig객체가 하나 있는 것을 사용 할 
 * 수 있다. ServletConfig객체가 하나 있는 것을 사용할 수 있다. ServletConfig 객체는 서블릿 객체마다 하나씩 
 * 할당된다. 그래서 ServletConfig 객체는 현제 서블릿 파일 안에서만 사용할 정보나 초기화 파라메터 를 저장 하는 용도로 
 * 사용된다.  
 * ServletConfig의 getInitParameter()메서드는 초기화 파라메터를 파라메터 이름으로 검색한다 
 *  getInitParameterName()메서드는 초기화 파라메터 전체 이름을 검색하여 Enumeration 형태로 반환한다.  
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
