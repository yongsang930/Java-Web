package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ProductVO;

/**
 * Servlet implementation class SetProductServlet
 */
@WebServlet("/SetProductServlet")
public class SetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ServletContext�� 
				//new ProductVO("nexus","�ؼ���S",100);
				//setting
				//GetProductServlet���� ��ũ�ɾ Ȯ��
				//GetProductServelt������
				//��ǰ ���̵� : .... ��ǰ �̸� : ... ���� : .. 
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				ServletContext context=this.getServletContext();
				context.setAttribute("product", new ProductVO("nexus","�ؼ���S",100));
				out.print("ServletContext�� data setting...");
				out.print(this.getServletName()+"ServletContext�� vo setting"+"<hr>");
				//getServletName() -->���� ���� �̸�
				out.print("<a href=GetProductServlet>GetProductServlet���� �̵�</a>");
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
