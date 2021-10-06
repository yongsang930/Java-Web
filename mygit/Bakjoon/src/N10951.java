import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10951 {
	public static void main(String[] args) throws NullPointerException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] str = br.readLine().split(" ");
			int num1 = Integer.parseInt(str[0]);
			int num2 = Integer.parseInt(str[1]);
			System.out.println(num1 + num2);
		}
	}
}
