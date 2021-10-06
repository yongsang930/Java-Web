import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException  {
		char num = (char)System.in.read();
		
		System.out.println(num);
		
		for (int i = 1; i <= (int)num; i++) {

			if (i % 2 == 0)
				System.out.print(i + " ");

		}
	}
}
