package step7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.PersonVO;
import vo.ProductVO;

/**
 * Servlet implementation class ListViewServlet
 */
@WebServlet("/ListViewServlet")
public class ListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	//init() ���� ServletContext�� ���� list�� �޾� �Ҵ��Ѵ�.
    private ArrayList list;
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    public ListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		ServletContext context=this.getServletContext();
		list= (ArrayList)context.getAttribute("table");
		//�ݺ��� ���ϱ� ���ؼ� ~~doGet���� �ݺ��� ����.
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(list==null){
			out.print("�������� �����ϴ�.");
		}else{
		int count=1;
		out.print("	<table border=1>");
		out.println("<td> �ο��� </td><td>���̵�</td><td>�г���</td>");
		for (int i = 0; i < list.size(); i++) {
			PersonVO vo=(PersonVO)list.get(i);
			out.print("	<tr>");
			out.println("<td>"+count+"</td>");
			out.println("<td>"+vo.getId()+"</td>");
			out.println("<td>"+vo.getNick()+"</td>");
			out.print("	</tr>");
			count++;
		}
		out.print("	</table>");
		}
		//���þ��� ������ ȣ���� �����ϴ�.
		//� �����̵��� ȣ���� �����ϴ�.
		//out.print("<hr>ServletContextListener �׽�Ʈ<br>");
//		ProductVO vo=(ProductVO) this.getServletContext().getAttribute("pvo");
//		out.print("pvo : "+vo);
//		out.close();
	}
	 /* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
