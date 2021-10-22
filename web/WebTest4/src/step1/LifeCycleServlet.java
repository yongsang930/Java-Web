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
     * LifeCycleServlet 의 서비스를 받는 모든 클라이언트가 
     * 공유하는 데이터 
     * why?  servlet은 객체생성이 한번 수행되고
     * 			이렇게 생성된 하나의 servlet에 각각의 클라이언트는 thread를이용해 
     * 			service() 메서드에 접근할 수있으므로 
     */
	private int count;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
        super();
        System.out.println("객체생성");
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
		PrintWriter out = response.getWriter();//웹페이지에서 출력 out.println()/ System.out.println() 콘솔에서 출력
		count++;
		out.print("<font size=7>count:"+count+"</font>");
		out.close();
	}

	@Override
	public void destroy() {
		System.out.println("***destroy 전 백업시작***");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("***destroy 전 백업종료***");
	}

}
