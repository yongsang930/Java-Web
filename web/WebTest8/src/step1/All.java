package step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDao;
import model.MemberVO;

/**
 * Servlet implementation class All
 */
@WebServlet("/All")
public class All extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public All() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDao dao=new MemberDao();

			ArrayList<MemberVO> list = dao.getAllMemberList	();
			//아래는 화면 표현 부분만 담당하다.
			out.print("	<table border=1>");
			out.println("<td> Id </td><td>Name</td><td>Password</td><td>Address</td>");
			for(int i=0;i<list.size();i++){
				out.print("<tr>");
				out.println("<td>"+ list.get(i).getId()+"</td><td>"+list.get(i).getName()+"</td><td>"+list.get(i).getPassword()+"</td><td>"+list.get(i).getAddress()+"</td>");
				out.print("</tr>");
				}
			out.print("	</table>");
			
		
			// TODO Auto-generated catch block
		
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
