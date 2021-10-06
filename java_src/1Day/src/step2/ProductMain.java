package step2;

import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Product p = new Product();
		
		p.input(sc);
		p.print();
		
		// 성적 처리프로그램
		// 이름, 국어, 영어, 수학, 총점 ,평균으로 구성
	}
	
}
