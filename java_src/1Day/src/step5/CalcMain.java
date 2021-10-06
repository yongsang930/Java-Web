package step5;

import java.util.Scanner;

public class CalcMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("두개의 숫자 입력: ");

		int x = sc.nextInt();
		int y = sc.nextInt();

		Calc c = new Calc(x, y);

		String op = sc.next();

		if (op.equals("+")) {
			System.out.println(c.add());
		} else if (op.equals("-")) {
			System.out.println(c.sub());
		} else if (op.equals("*")) {
			System.out.println(c.mul());
		} else if (op.equals("/")) {
			System.out.println(c.div());
		} else {
			System.out.println("연산자 오류");
		}

	}
}
