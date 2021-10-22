package step4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MapServlet
 */
@WebServlet("/MapServlet")
public class MapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out= response.getWriter(); 
		//��û�� �Ѿ�� �����͸� name�� value�������� ǥ�� 
		// String, key String[] value
		
		Map<String, String[]> map=request.getParameterMap();
		
		//map���� ���� key���� ��ȯ�޴´�. keySet(); 
		//keySet()�� Set�� ��ȯ�ϹǷ� iterator()�� ������ �� �ִ�.
		//iterator()�� �����ϸ鼭 next()�� ȣ���ϸ� key�� ��ȯ�ǰ� 
		//�̴� html name�̴�. name�� map�� get(name)�ϸ� 
        //value�� ��ȯ�Ǵµ� �� value�� Ÿ���� String[]�̹Ƿ� 
		//for loop�� �����ϸ� name�� value�� ����ϸ� �ȴ�. 
		
		Set<String> set=map.keySet(); 
		Iterator<String> it =set.iterator();
		String str=null; 
		String str1[];
		
		//Map�� object�� ��ȯ�Ǵ� ������ 
		//map�� ����Ÿ���� ��ȯ�ؾ� ���� �Ǵ��� �� �� ����. 
		//�׷��Ƿ� out.print(it.next())�Ұ�쿡�� 
		//��ü������ �������̵��� toString()���� String ���� ����� �ش�.
		//������ String key=it.next(); �� map�� ���忡�� ������ ��ȯ�ؾ� �ϴ��� �Ǵ�
        //�Ҽ��� ����. �׷��Ƿ� Set<String> set=map.keySet();	
		//Iterator<String> it =set.iterator(); 
		//ó�� ���ʸ��� �����Ͽ� String ���� �޴´ٰ� �������ְų� 
		//it.next().toString()�� ���־� key���� ��� ���� �� �ִ�. 
		//�׷��Ƿ� map�� �ֻ��� ��ü�� object�� ��ȯ�� �ִ� ���̴�.
		
		while(it.hasNext()) {
			str=it.next(); 
			str1=map.get(str); //�迭�� ��ȯ
            for(int i=0; i<str1.length; i++){
            	out.println(str+""+str1[i]);
            } 
		    out.print("<br>");
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
