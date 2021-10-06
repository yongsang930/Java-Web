import java.util.Scanner;

public class yeonsan3 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int one = scan.nextInt();
		scan.close();
		
		System.out.println(one++);
		System.out.println(++one);
	}
}
