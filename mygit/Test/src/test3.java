import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int hou = scan.nextInt();
		int min = scan.nextInt();
		scan.close();

		if (hou == 0) {
			hou = 24;
		}

		if (min < 45) {
			hou--;
			min += 15;
		} else {
			min += 15;
		}
		
		if(min == 60) {
			min = 0;
		}else if (min > 60) {
			min -= 60;
		}
		
		System.out.print(hou + " ");
		System.out.println(min);
	}
}
