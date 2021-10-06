package step5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class El {

	public static void main(String[] args) throws Exception{
		
		int a, b;
		String c;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("두개의 숫자를 입력해: ");
		
		a = Integer.valueOf(in.readLine());
		b = Integer.valueOf(in.readLine());
		
		System.out.println("연산자 입력해: ");
		c = in.readLine();
		
		if(c.equals("+"))
			System.out.println(a + b);
		else if(c.equals("-"))
			System.out.println(a - b);
		else if(c.equals("*"))
			System.out.println(a * b);
		else if(c.equals("/"))
			System.out.println(a / b);
		else if(c.equals("%"))
			System.out.println(a % b);
		else {
			System.out.println("잘못 입력 했다구");
		}
	}
}
