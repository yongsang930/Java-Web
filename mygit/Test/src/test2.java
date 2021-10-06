import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] num = new int[100];

		for (int i = 0; i < num.length; i++) {num[i] = 0;}

		for (int i = 0; i < num.length; i++) {
			num[i] = scan.nextInt();

			if (num[i] == 0) {
				for (int j = i; j > 0; j--) {
					--i;
					System.out.print(num[i] + " ");
				}
				break;
			}
		}scan.close();
	}
}
