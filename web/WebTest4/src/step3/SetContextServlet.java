package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetContextServlet
 */
@WebServlet("/SetContextServlet")
public class SetContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetContextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
//javax.servlet.ServletContext�� ���ǵǾ�����.
//������ �����̳� ���� ������ ���� ����Ѵ�
//���ؽ�Ʈ(�� ���ø����̼�)���� �ϳ��� ServletContext�� �����ȴ�
//�������� �ڿ�(������)�� �����ϴµ� ����Ѵ�
//�����̳� ����� �����ǰ� �����̳� ����� �Ҹ�ȴ�.


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//ServletContext�� �����͸� setting
		ServletContext context=this.getServletContext();
		context.setAttribute("info", "�տ���");
		out.print("ServletContext�� data setting...");
		out.print("<a href=GetContextServlet>GetContextServlet���� �̵�</a>");
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
