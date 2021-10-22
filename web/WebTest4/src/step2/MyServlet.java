package step2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		response.setCharacterEncoding("euc-kr");

		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String hobby[] = request.getParameterValues("hobby");
		String grade = request.getParameter("grade");
		String content = request.getParameter("content");

		out.print("<html><body>");
		out.print("<h3>파라메터 이름으로 하나씩 읽어서 출력</h3>");
		out.print("id:" + id + "<br>");
		out.print("pwd:" + pwd + "<br>");
		out.print("gender:" + gender + "<br>");
		for (int i = 0; i < hobby.length; i++) {
			out.print("hobby:" + hobby[i] + "<br>");
		}
		out.print("grade:" + grade + "<br>");
		out.print("content:" + content + "<br>");

		out.print("<h3>이름 전체 검색</h3>");
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();

			if (name.equals("hobby")) {
				String[] values = request.getParameterValues(name);
				for (int i = 0; i < values.length; i++) {
					out.print(name + ":" + values[i] + "<br>");
				}
			} else {
				String value = request.getParameter(name);
				out.print(name + ":" + value + "<br>");
			}

		}

		out.print("<h3>맵으로 전체 검색</h3>");
		Map<String, String[]> map = request.getParameterMap();
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String name = it.next();
			String[] values = map.get(name);
			if (values.length == 1) {
				String value = values[0];
				out.print(name + ":" + value + "<br>");
			} else {
				for(int i=0;i<values.length;i++){
					out.print(name + ":" + values[i] + "<br>");
				}
			}
		}
		out.print("</body></html>");
		
	
	}

}
