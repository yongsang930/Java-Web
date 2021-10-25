package step5;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class ShopServlet
 */
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//url�� ��û�� ������ doGet()
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				MemberDao dao=new MemberDao();
					HttpSession session=request.getSession(false);
				if(session==null||session.getAttribute("userId")==null){
					//������ ������  userId�� ���� ������  �Ǵ�
					out.print("<script type='text/javascript'>");
					out.print("alert('���̵� �Է��ϼ���~~!!!');");
					out.print("location.href='login.html';");
					out.print("</script>");
				}else{
					ArrayList<MemberVO> list=(ArrayList)session.getAttribute("userId");
					out.println(list.get(0).getAddress()+"�� ��� "+list.get(0).getName()+"�� ���θ� ����ȯ��");
					out.print("<hr><a href=LogoutServlet>�α׾ƿ�</a>");
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
