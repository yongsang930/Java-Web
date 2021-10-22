package step6;

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

/**
 * Servlet implementation class EnterServlet
 */
@WebServlet("/EnterServlet")
public class EnterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//������ ��� ������ �����ϴ� list
		//�� ����Ʈ�� init()���� ServletContext�� �����Ѵ�.
		private ArrayList list=new ArrayList();
	       
	    @Override
		public void init() throws ServletException {
			ServletContext context=this.getServletContext();
			//list�� �ּҰ��� �����ϰ� �����Ƿ� ���ο� ����� �߰��� list.add()�� �Ѵ�.
			//�ᱹlist�� ����Ű�� �ּҰ��� ���������� list�� ��ü���� ��� �߰��� �ο��� �����Ѵ�.
			context.setAttribute("table",list);
			System.out.println("init()....list add");
		}

		/**
	     * @see HttpServlet#HttpServlet()
	     */
	    public EnterServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print(request.getParameter("nick")+"�� ����ȯ��"+"<hr>");
			//list�� ��� ��ü �߰�
			list.add(new PersonVO(request.getParameter("id"),request.getParameter("nick")));
			out.print("<a href=ListViewServlet>�����ܺ���</a>");
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
