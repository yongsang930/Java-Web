import java.util.Scanner;

public class yeonsan4 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int mon = scan.nextInt();
		
		switch (mon) {
		case 1, 3, 5, 7, 8, 10, 12: {
			System.out.println("31");
			break;
		}
		case 4, 6, 9, 11: {
			System.out.println("30");
			break;
		}
		default : {
			System.out.println("28");
		}
		}
		scan.close();
	}
}
