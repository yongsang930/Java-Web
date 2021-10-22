package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * LifeCycleServlet �� ���񽺸� �޴� ��� Ŭ���̾�Ʈ�� 
     * �����ϴ� ������ 
     * why?  servlet�� ��ü������ �ѹ� ����ǰ�
     * 			�̷��� ������ �ϳ��� servlet�� ������ Ŭ���̾�Ʈ�� thread���̿��� 
     * 			service() �޼��忡 ������ �������Ƿ� 
     */
	private int count;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
        super();
        System.out.println("��ü����");
    }
    
	@Override
	public void init() throws ServletException {
		System.out.println("init() call");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();//������������ ��� out.println()/ System.out.println() �ֿܼ��� ���
		count++;
		out.print("<font size=7>count:"+count+"</font>");
		out.close();
	}

	@Override
	public void destroy() {
		System.out.println("***destroy �� �������***");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("***destroy �� �������***");
	}

}
