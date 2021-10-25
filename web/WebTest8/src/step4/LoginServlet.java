package step4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDao;
import model.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		response.setCharacterEncoding("utf-8");
		MemberDao dao=new MemberDao();
		String id=request.getParameter("userId");
		String pass=request.getParameter("userPass");
		
			ArrayList<MemberVO> list=dao.LoginMemberList(id,pass);
			if(list.size()!=0){
				HttpSession session=request.getSession();
				session.setAttribute("userId", list);
			for(int i=0;i<list.size();i++){
				out.print(list.get(i).getName()+"�� ����ȯ��");
			}
			out.print("<hr><a href=ShopServlet>���θ���</a>");
			}else{
				out.print("<script type='text/javascript'>");
				out.print("alert('�α��ν���');");
				out.print("location.href='login.html';");
				out.print("</script>");
			}
		
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
