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
		//요청시 넘어온 데이터를 name과 value형식으로 표현 
		// String, key String[] value
		
		Map<String, String[]> map=request.getParameterMap();
		
		//map으로 부터 key들을 반환받는다. keySet(); 
		//keySet()은 Set을 반환하므로 iterator()로 열거할 수 있다.
		//iterator()로 수행하면서 next()를 호출하면 key가 반환되고 
		//이는 html name이다. name을 map에 get(name)하면 
        //value가 반환되는데 이 value의 타입은 String[]이므로 
		//for loop를 수행하면 name과 value를 출력하면 된다. 
		
		Set<String> set=map.keySet(); 
		Iterator<String> it =set.iterator();
		String str=null; 
		String str1[];
		
		//Map이 object로 반환되는 이유는 
		//map이 무슨타입을 반환해야 할지 판단할 수 가 없다. 
		//그러므로 out.print(it.next())할경우에는 
		//자체적으로 오버라이딩된 toString()으로 String 값을 출력해 준다.
		//하지만 String key=it.next(); 는 map의 입장에서 무엇을 반환해야 하는지 판단
        //할수가 없다. 그러므로 Set<String> set=map.keySet();	
		//Iterator<String> it =set.iterator(); 
		//처럼 제너릭을 설정하여 String 값을 받는다고 선언해주거나 
		//it.next().toString()을 해주야 key값을 출력 받을 수 있다. 
		//그러므로 map은 최상위 객체인 object로 반환해 주는 것이다.
		
		while(it.hasNext()) {
			str=it.next(); 
			str1=map.get(str); //배열이 반환
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
