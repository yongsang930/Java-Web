import java.util.Scanner;

public class yeonsan1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int one = scan.nextInt();
		int two = scan.nextInt();
		int thr = scan.nextInt();
		scan.close();
		
		int sum = one + two + thr;
		int avg = (one + two + thr)/3;
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);
	}
}
