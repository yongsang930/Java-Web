import java.util.Arrays;
import java.util.Scanner;


public class FirstClass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] under = new String[30];
		
		for (int i = 0; i < under.length; i++) {
			under[i] = " ";
		}
		
		int cnt = 0;

		for (int i = 0; i < under.length; i++) {

			under[i] = scan.next();
			cnt++;
			System.out.println("i="+ i + " 배열에 값은 " + under[i]);
			System.out.println(cnt);
			
			if(under[i].equals(" ")) {
				System.out.println("널널하네~");
				scan.close();
				break;
			}
		}
	  System.out.println("cnt =" + cnt);
	}
}
