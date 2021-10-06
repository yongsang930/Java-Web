package step3;

import java.util.Scanner;

public class GradeMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Grade g = new Grade();
		
		g.Input(sc);
		g.tot();
		g.avg();
		g.print();
	
	}
}
