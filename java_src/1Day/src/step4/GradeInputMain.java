package step4;

import java.util.Scanner;

public class GradeInputMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		GradeInput[] r = new GradeInput[3];

		for (int i = 0; i < r.length; i++) {
			r[i] = new GradeInput();
			r[i].Input(sc);
			System.out.println();
			r[i].tot();
			r[i].avg();
		}

		for (int i = 0; i < r.length; i++) {
			r[i].print();
		}
	}
}
