import java.util.Scanner;

public class yeonsan2 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int one = scan.nextInt();
		int two = scan.nextInt();
		scan.close();
		
		int thr = one + 100;
		int fou = two % 10;
		
		System.out.printf("%d %d",thr, fou);
	}
}
